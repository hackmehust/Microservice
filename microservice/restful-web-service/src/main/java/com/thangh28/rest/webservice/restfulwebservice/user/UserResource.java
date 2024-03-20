package com.thangh28.rest.webservice.restfulwebservice.user;

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

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = serrvice.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUsers = serrvice.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUsers.getId()).toUri(); // thay thế vào {id}
        return ResponseEntity.created(location).build(); // location ở đây sẽ trả về URI trong header
    }
}
