package com.example.game_1a2b.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Game {
    private SecretNumber secret;
    private ArrayList<Guess> history;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Game(SecretNumber secret) {
        this.secret = secret;
        this.history = new ArrayList<>();
        this.startTime = LocalDateTime.now();
        this.endTime = null;
    }

    public void updateHistory(Guess guess){
        this.history.add(guess);
        if (guess.getFeedback().equals("4A0B")){
            this.endTime = LocalDateTime.now();
        }
    }

    public boolean isEnd(){
        if(this.endTime==null){
            return false;
        }
        return true;
    }

    public String gameTime(){
        //the difference between startTime and endTime
        long amount = SECONDS.between(this.startTime, this.endTime);
        int seconds = (int) amount;

        int h = seconds  / 3600;
        int m = seconds % 3600 / 60;
        int s = seconds % 60;

        if (h<1){
            if (m<1){
                return s + " seconds";
            }
            return m + " minutes " + s + " seconds";
        }
        return h + " hour " + m + " minutes " + s + " seconds";
    }

    public SecretNumber getSecret() {
        return secret;
    }

    public void setSecret(SecretNumber secret) {
        this.secret = secret;
    }

    public ArrayList<Guess> getHistory() {
        return history;
    }

    public void setHistory(Guess guess) {
        this.history.add(guess);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
