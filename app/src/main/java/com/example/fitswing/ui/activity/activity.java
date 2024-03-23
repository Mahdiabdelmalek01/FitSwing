package com.example.fitswing.ui.activity;

public class activity {

    String name;
    String calories;
    Boolean completed=false;
    String description;
    String date;
    public activity() {

    }

    public activity(String name, String calories, String description, String date) {
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.date = date;
        this.completed=false;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public activity(String name, String calories, Boolean completed, String description) {
        this.name = name;
        this.calories = calories;
        this.completed = completed;
        this.description = description;

    }

    public activity(String name, String calories, String description) {
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.completed=false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


}
