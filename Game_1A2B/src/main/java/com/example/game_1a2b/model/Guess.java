package com.example.game_1a2b.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Guess {
    private String guess;
    private String feedback;
    private LocalDateTime createTime;

    public Guess(String guess) {
        this.guess = guess;
        this.feedback = null;
        this.createTime = LocalDateTime.now();
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
