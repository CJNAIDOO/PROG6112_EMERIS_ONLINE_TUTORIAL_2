package com.example.tutorial2.cam;


public class YogaSession extends TrainingSession {

    public YogaSession(String name, String trainer, int duration){
        //  parent (TrainingSession) constructor is reused
        super(name, trainer, duration);
    }
    
    //  abstract method is overriden
    @Override
    public void startSession() {
        //display message for starting yoga session
        System.out.println("Starting yoga session: " + getName() + ". Breathe in... breathe out...");    
    }
}
