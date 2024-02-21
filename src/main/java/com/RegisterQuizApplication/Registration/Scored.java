package com.RegisterQuizApplication.Registration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scored {
    private int score;

    public Scored(int score){
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
