package com.RegisterQuizApplication.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuizController {

    @Autowired
    QuizRepository repository;



    //Display the Questions to the User (10 Questions)
    @GetMapping(path="questions")
    public List<Quiz> get(
            @RequestParam(required = false) String field
    ){
        if (field==null)
         return repository.getQuizQuestions();
        else return repository.getQuizQuestionsField(field);

    }



}
