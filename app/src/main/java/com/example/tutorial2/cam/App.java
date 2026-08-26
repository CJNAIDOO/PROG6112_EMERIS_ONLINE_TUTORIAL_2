package com.example.tutorial2.cam;

//needed to use ArrayList
import java.util.ArrayList;
//needed to use JOptionPane
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        
        /*  ArrayList of TrainingSessions
                -can be a TrainingSession, or any child YogaSession, TrainingSession, StrengthSession
        */
        ArrayList<TrainingSession> sessions=new ArrayList<>();
        // running check variable set to true intiially to being while loop
        boolean running=true;
        
        while(running==true){
            
            String menu="Fitness Training Scheduler \n"
                        +"1. Add Training Session \n"
                        +"2. View All Sessions \n"
                        +"3. Start a Session \n"
                        +"4. Quit  \n";
            
            //gather user input for menu selection
            String choice=JOptionPane.showInputDialog(null, menu, "Main Menu", JOptionPane.PLAIN_MESSAGE);
            
            if(choice==null){
                //if user closes dialog exit
                break;
            }
            
            switch(choice.trim()){
                case "1":
                    addSession(sessions);
                    break;
                case "2":
                    viewSessions(sessions);
                    break;   
                case "3":
                    startSession(sessions);
                    break;
                case "4":
                    //set running to false to break loop
                    running=false;
                    break;
                    //default case to handle all unexpected input
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
            }   
        }
        //exit message
        JOptionPane.showMessageDialog(null, "Goodbye!");
    }
    
      // ---------- Option 1: Add Training Session ----------
        private static void addSession(ArrayList<TrainingSession> sessions) {
            
            String type = JOptionPane.showInputDialog(null, "Enter session type: 'Yoga', 'Cardio' or 'Strength':");
 
            if (type == null){
                //if type is null exit
                return;
            }
 
            // get name, trainer and duration from muser
            String name = JOptionPane.showInputDialog(null, "Enter session name:");
            String trainer = JOptionPane.showInputDialog(null, "Enter trainer name:");
            String durationText = JOptionPane.showInputDialog(null, "Enter duration  (in minutes):");
 
            //convert durationText to int
            int duration;
            try {
                duration = Integer.parseInt(durationText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Duration must be a number.");
                return;
            }

            //if duration is successfully converted created a TrainingSession object
            TrainingSession newSession;

            // this switch statement determines which child class (Yoga, Cardio, Strength) needs to be created, based on what user provided for Type
            switch (type.trim().toLowerCase()) {
                case "yoga":
                    newSession = new YogaSession(name, trainer, duration);
                    break;
                case "cardio":
                    newSession = new CardioSession(name, trainer, duration);
                    break;
                case "strength":
                    newSession = new StrengthSession(name, trainer, duration);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unknown session type.");
                    return;
        }
 
        // add newSession to sessions ArrayList
        sessions.add(newSession);
        JOptionPane.showMessageDialog(null, "Session added!");
    }
 
    // ---------- Option 2: View All Sessions ----------
    private static void viewSessions(ArrayList<TrainingSession> sessions) {
        
        //if there are no sessions, display appropriate message
        if (sessions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sessions booked yet.");
            return;
        }
 
        //use stringbuilder to create string that contains ALL sessions from the ArrayList
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sessions.size(); i++) {
            // toString() is called here — same call,different output depending on the actual object type.
            sb.append("TrainingSession "+(i+1)).append(":       ").append(sessions.get(i).toString()).append("\n");
        }
 
        //display all sessions
        JOptionPane.showMessageDialog(null, sb.toString());
    }
 
    // ---------- Option 3: Start a Session ----------
    private static void startSession(ArrayList<TrainingSession> sessions) {

        //if there are no sessions, display appropriate message
        if (sessions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sessions to start.");
            return;
        }
 
        //  Show the list of sessions
        StringBuilder sb = new StringBuilder("Select a session by index:\n");
        for (int i = 0; i < sessions.size(); i++) {
            sb.append("TrainingSession "+i).append(":       ").append(sessions.get(i).toString()).append("\n");
        }
 
        //  get indexText input
        String indexText = JOptionPane.showInputDialog(null, sb.toString());
        
        if(indexText==null){
                //if user closes dialog exit
                return;
            }
        
        //  Parse and validate the index
        int index;
        //parse indexText to int
        try {
            index = Integer.parseInt(indexText.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            return;
        }
 
        //validate that index is valid
        if (index < 0 || index >= sessions.size()) {
            JOptionPane.showMessageDialog(null, "Index out of range.");
            return;
        }
        
        //the SAME call produces different output depending on whether the object is a YogaSession,CardioSession or StrengthSession. 
        // startSession() prints the appropriate message based on the type of session, calling the specific overriden version of TrainingSession's startSession()
        sessions.get(index).startSession();

    }
}

