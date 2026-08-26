
package com.example.tutorial2.cam;

//needed for JOptionPane
import javax.swing.JOptionPane;


public class StrengthSession extends TrainingSession{
    
    public StrengthSession(String name, String trainer, int duration){
        //  parent (TrainingSession) constructor is reused
        super(name, trainer, duration);
    }
    
    @Override
    public void startSession(){
        //display message for starting yoga session
        JOptionPane.showMessageDialog(null,"Starting strength session: " + getName() + ". Time to lift!");   
    }
    
}
