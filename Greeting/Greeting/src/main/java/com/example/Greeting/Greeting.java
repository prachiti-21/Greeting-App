package com.example.Greeting;
public class Greeting {
    private String message;
    private String sender;

    // Constructors
    public Greeting() {
    }

    public Greeting(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
