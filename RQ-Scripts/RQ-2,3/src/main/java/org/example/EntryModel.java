package org.example;

public class EntryModel {
    String id;
    String smell;
    boolean modelPrediction;
    boolean userAnnotation;

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public boolean isModelPrediction() {
        return modelPrediction;
    }

    public void setModelPrediction(boolean modelPrediction) {
        this.modelPrediction = modelPrediction;
    }

    public boolean isUserAnnotation() {
        return userAnnotation;
    }

    public void setUserAnnotation(boolean userAnnotation) {
        this.userAnnotation = userAnnotation;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    String user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
