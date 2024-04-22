package com.example.game_1a2b.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public void feedBack(SecretNumber secretNumber){
        String guessStr = this.guess;
        // store the guessStr as int[]
        int[] guessArr = new int[guessStr.length()];
        char[] cha = guessStr.toCharArray();

        for (int i = 0; i < guessStr.length(); i++) {
            char c = cha[i];
            guessArr[i] = cha[i] - '0';
        }

        ArrayList<Integer> secret = secretNumber.getSecretNumber();

        int amountA = 0;
        int amountB = 0;

        for (int i=0;i<secretNumber.getLength();i++){
            // check amount of A
            if (secret.get(i)==guessArr[i]){
                amountA++;
            }

            // check amount of B
            for (int j=0;j<guessStr.length();j++){
                if (secret.get(i)==guessArr[j]){
                    amountB++;
                }
            }
        }

        amountB -= amountA;

        String feedback = amountA + "A" + amountB + "B";
        this.setFeedback(feedback);
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
