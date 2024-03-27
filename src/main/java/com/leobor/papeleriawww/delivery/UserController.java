package com.leobor.papeleriawww.delivery;

import com.leobor.papeleriawww.application.UserService;
import com.leobor.papeleriawww.domain.User;
import com.leobor.papeleriawww.domain.UserValide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@Service
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> listing(){
        return userService.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/findByDocument")
    public User findByDocument(@RequestParam String documentType, @RequestParam String documentNumber) {
        return userService.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
    }

    @PostMapping("/login")
    public Boolean findByUsernameAndPassword(@RequestBody UserValide user){
        User User =  userService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        return User == null ? false : true;
    }




}
