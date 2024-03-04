package com.RegisterQuizApplication.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RegisterPageController {
    @Autowired
    UserRepository repository;
    @PostMapping(consumes = "application/json",path="/register")
    public String save(@RequestBody Registration registration){
        Registration newuser= new Registration();

        //New User Details Validations
        boolean isFirstNameValid= UserDetailsValidation.isValidName(registration.getFirstName());
        if(!isFirstNameValid) {
            return "Please enter correct FirstName. " +
                    "1. First and Last Name should contain minimum 3 characters and maximum 25 characters." +
                    "2. No Numbers allowed";
        }
        boolean isLastNameValid= UserDetailsValidation.isValidName(registration.getLastName());
        if(!isLastNameValid) {
            return "Please enter correct FirstName. " +
                    "1. First and Last Name should contain minimum 5 characters and maximum 25 characters." +
                    "2. No Numbers allowed";
        }
        boolean isUserNameValid= UserDetailsValidation.isValidUserName(registration.getUserName());
        if(!isUserNameValid) {
            return "Please enter correct UserName. " +
                    "1. Username Name should contain minimum 5 characters and maximum 25 characters." +
                    "2. No Numbers allowed";
        }
        boolean isPhoneNoValid= UserDetailsValidation.isValidPhoneNumber(registration.getPhoneNumber());
        if(!isPhoneNoValid) {
            return "Please enter correct PhoneNumber. ";
        }
        boolean isMailIdValid= UserDetailsValidation.isValidMailId(registration.getMailId());
        if(!isMailIdValid) {
            return "Please enter correct mail id Example:abc@domain.com";
        }
        boolean isPasswordValid= UserDetailsValidation.isValidPassword(registration.getPassword());
        if(!isPasswordValid) {
            return "Your password must meet the following criteria: "+
                    "- At least 8 characters and up to 20 characters in length."+
                    "- Include at least one digit (0-9)."+
                    "- Include at least one lowercase letter."+
                    "- Include at least one uppercase letter."+
                    "- Include at least one special character from the following set: @, #, $, %, ^, &, -, +, =."+
                    "- Avoid using any whitespaces."+

                    "Please ensure your password adheres to these requirements for security purposes.";
        }

        newuser.setFirstName(registration.getFirstName());
        newuser.setLastName(registration.getLastName());
        newuser.setMailId(registration.getMailId());
        newuser.setUserName(registration.getUserName());
        newuser.setPhoneNumber(registration.getPhoneNumber());
        newuser.setPassword(registration.getPassword());
        repository.save(newuser);
        return "The user "+newuser.getUserName()+" has been registered successfully.";
    }

}
