package com.ict.delivirko.Module.restaurant;

import java.io.Serializable;

public class Questions implements Serializable {
    private String answer;
    private int id;
    private String question;

    public int getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }
}
