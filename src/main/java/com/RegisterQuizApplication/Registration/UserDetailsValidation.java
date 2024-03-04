package com.RegisterQuizApplication.Registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDetailsValidation {
    // Function to validate the FirstName and LastName
    public static boolean isValidName(String name){
        String regex = "^[A-Za-z]\\w{2,29}$";
        return isValid(regex,name);
    }

    // Function to validate the UserName
    public static boolean isValidUserName(String name){
        String regex = "^[A-Za-z][A-Za-z0-9_]{5,29}$";
        return isValid(regex,name);
    }

    // Function to validate MailID
    public static boolean isValidMailId(String mailId){
        String regex = "^(.+)@(\\S+)$";
        return isValid(regex,mailId);
    }

    // Function to validate PhoneNumber
    public static boolean isValidPhoneNumber(String phNo){
        String regex = "^(\\d{3}[- .]?){2}\\d{4}$";
        return isValid(regex,phNo);
    }
    // Function to validate Password
    public static boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return isValid(regex,password);
    }

    public static boolean isValid(String regex,String data)
    {

        // Regex to check valid username.
        // String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if (data == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(data);

        // Return if the username
        // matched the ReGex
        return m.matches();
    }

}
