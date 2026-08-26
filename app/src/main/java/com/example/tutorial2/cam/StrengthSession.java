
package com.example.tutorial2.cam;


public class StrengthSession extends TrainingSession{
    
    public StrengthSession(String name, String trainer, int duration){
        //  parent (TrainingSession) constructor is reused
        super(name, trainer, duration);
    }
    
    @Override
    public void startSession(){
        //display message for starting yoga session
        System.out.println("Starting strength session: " + getName() + ". Time to lift!");   
    }
    
    
}
