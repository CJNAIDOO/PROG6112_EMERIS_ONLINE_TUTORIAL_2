package com.example.tutorial2.cam;

//needed to use JOptionPane
import javax.swing.JOptionPane;

public class CardioSession extends TrainingSession {
    
    public CardioSession(String name, String trainer, int duration){
        //  parent (TrainingSession) constructor is reused
        super(name, trainer, duration);
    }
    
    @Override
    public void startSession(){
        //display message for starting yoga session
        JOptionPane.showMessageDialog(null,"Starting cardio session: " + getName() + ". Let's get that heart rate up!");   
    }
    
}
