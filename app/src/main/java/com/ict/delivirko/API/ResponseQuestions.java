package com.ict.delivirko.API;

import com.google.gson.annotations.SerializedName;
import com.ict.delivirko.Module.restaurant.Questions;
import java.util.List;

public class ResponseQuestions {
    private String message;
    @SerializedName("data")
    private List<Questions> questions;
    private boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public List<Questions> getQuestions() {
        return this.questions;
    }
}
