package com.example.thangnh28.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller  // @RestController dùng cho API, còn return View HTML thì dùng @Controller
@RequestMapping("/")  // Endpoint gốc là /
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    // Bên trong controller sẽ có nhiều method, mỗi cái sẽ bắt request cụ thể

    // Bắt GET /home request và trả về view
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "John");
        return "index";  // Return tên của View, model sẽ tự động pass vào view
    }

    // Hoặc có thể trả về data trong response body (như các API)
    @GetMapping("/users")
    @ResponseBody
    public List<User> getUserList() {
        return new ArrayList<>();
    }

    // Hoặc cái này tương tự như trên, nhưng có thể tùy chỉnh response status code, header,...
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String userId) {
        // Không cần @ResponseBody do có body rồi
        return ResponseEntity.status(200).body(new User());
    }

    @GetMapping("/")
    // Trả về Model là một List<UserModel>
    public @ResponseBody UserDto getUserList2() {

        User user = new User();
        user.setAge(18);
        user.setPassword("123456");
        user.setDisplayName("Thang");
        user.setUsername("thangnh28");

        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
