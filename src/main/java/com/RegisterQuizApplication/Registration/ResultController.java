package com.RegisterQuizApplication.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ResultController {
    @Autowired
    ResultRepository repository;

    @Autowired
    ScoreRepository scoreRepository;

    @PostMapping(consumes = "application/json",path="result/{username}",produces = "application/json")
    //Answers Submitted by the user

    public Scored post(@PathVariable String username, @RequestBody List<Result> userAnswer){
    try {
        Date date;
        List<Result> correctAnswer = repository.getAnswers();
        int correctAnswer_count = 0;
        for (int i = 0; i < correctAnswer.size(); i++) {
            if (correctAnswer.get(i).getCorrectOption().equals(userAnswer.get(i).getCorrectOption())) {
                ++correctAnswer_count;
            }
        }
        Score score = new Score();
        score.setUserName(username);
        score.setScore(correctAnswer_count);
        score.setTotalQuestions(userAnswer.size());
        score.setTimestamp(LocalDateTime.now());
        scoreRepository.save(score);
        return new Scored(correctAnswer_count);
    }   catch (Exception e) {
        throw e;
    }
    }






}
