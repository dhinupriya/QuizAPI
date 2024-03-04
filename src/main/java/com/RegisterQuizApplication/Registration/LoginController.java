package com.RegisterQuizApplication.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    UserRepository repository;
    @GetMapping(path="login/{username}/{password}")
    public String get(@PathVariable String username,@PathVariable String password){
        String password_sql=repository.getpasswordbyusername(username);
        if(password_sql==null && password_sql.isEmpty()) {
            return "The Username \"" + username + "\" is incorrect.";
        }else if(password_sql.equals(password)){
            return "The User " + username + " is logged in successfully.";
        }else {
            return "Please enter the correct password";
        }
    }
}
