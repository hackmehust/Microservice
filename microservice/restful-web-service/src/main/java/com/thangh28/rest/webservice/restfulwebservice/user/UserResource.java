package com.thangh28.rest.webservice.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoSerrvice serrvice;

    public UserResource(UserDaoSerrvice serrvice) {
        this.serrvice = serrvice;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return serrvice.findAll();
    }


    // http://localhost:8080/users

    // EntityMdoel
    // WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = serrvice.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUsers = serrvice.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUsers.getId()).toUri(); // thay thế vào {id}
        return ResponseEntity.created(location).build(); // location ở đây sẽ trả về URI trong header
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        serrvice.deleteById(id);
    }
}
