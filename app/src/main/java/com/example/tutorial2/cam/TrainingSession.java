package com.example.tutorial2.cam;


public abstract class TrainingSession {
    
    // Shared fields for every kind of session
    private String name;
    private String trainer;
    private int duration; // in minutes
    
    /*  CONSTRUCTOR
            - Can use Setters instead of hard coding intialization
    */
    public TrainingSession(String name, String trainer, int duration) {
        this.name = name;
        this.trainer = trainer;
        this.duration = duration;
    }
 
    //  GETTERS
    public String getName() {
        return name;
    }
 
    public String getTrainer() {
        return trainer;
    }
 
    public int getDuration() {
        return duration;
    }
    
    //Setters
     public void setName(String name) {
        this.name=name;
    }
 
    public void setTrainer(String trainer) {
        this.trainer=trainer;
    }
 
    public void getDuration(int duration) {
       this.duration=duration;
    }
    
    /*
        ABSTRACT METHOD
            - No body here as every child class MUST override this.
    */
    public abstract void startSession();
 
    //Overriden, non-abstract toString method that EVERY session type uses, UNLESS overridden (optional, if child class needs different version of the method)
    @Override
    public String toString() {
        return "Session Name: " + name + " | Trainer Name: " + trainer + " | Duration: " + duration + " min";
    }
}
