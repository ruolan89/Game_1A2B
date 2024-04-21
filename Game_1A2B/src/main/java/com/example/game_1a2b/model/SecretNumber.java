package com.example.game_1a2b.model;

import java.util.ArrayList;

public class SecretNumber {
    private ArrayList<Integer> secretNumber;
    private int length;

    public SecretNumber(int length) {
        this.secretNumber = new ArrayList<>();
        this.length = length;
    }

    public int generateNumber(){
        return (int) (Math.random() * 10);
    }

    public void createNumbers(){
        // if secretNumber is empty or null
        if (this.secretNumber.isEmpty()){
            this.secretNumber.add(generateNumber());
        }
        // insert all numbers into numberList, every number is unique
        while (this.secretNumber.size() < this.length) {
            int num = generateNumber();
            if (!this.secretNumber.contains(num)) {
                this.secretNumber.add(num);
            }
        }
    }

    public ArrayList<Integer> getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(ArrayList<Integer> numberList) {
        this.secretNumber = numberList;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
