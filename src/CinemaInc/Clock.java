package CinemaInc;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class Clock extends Thread { //Clock is a subclass of the Thread class that contains all methods for handling clocks
                                   //Extends the Thread class to inherit its methods

    boolean tick = true; //Stores whether clock should be ticking or not
    JLabel label; //Stores current JLabel to display clock to
    JFrame frame; //Stores current JFrame to switch to dark mode

    Date date = new Date(); //New Date object created
    //New DateFormat objects created for formats "HH:mm" and "HH"
    DateFormat time = new SimpleDateFormat("HH:mm");
    DateFormat hour = new SimpleDateFormat("HH");
    String currentTime; //Stores current time as a String
    int currentHour; //Stores current hour as an integer

    /**
     * Constructor method for the Clock class
     */
    public Clock(){
        
    }

    /**
     * Stops run() method by setting tick boolean to false
     */
    public void stopClock() {
        this.tick = false;
    }

    /**
     * Sets label to clock JLabel of new form
     * 
     * @param newLabel clock JLabel of new form
     */
    public void setLabel(JLabel newLabel) {
        this.label = newLabel;
    }

    /**
     * Sets frame to JFrame of new form
     * 
     * @param newFrame JFrame of new form
     */
    public void setFrame(JFrame newFrame) {
        this.frame = newFrame;
    }

    /**
     * Constantly updates current time to label
     * Sets frame to dark mode if between the hours of 18:00PM and 06:00AM
     */
    public void run() {
        
        while (tick == true) {
            
            Calendar calendar = new GregorianCalendar(); //New Calendar object created

            date = calendar.getTime(); //Time stored in date object
            currentTime = time.format(date); //Time formatted to short time 24 hour format
            label.setText(currentTime); //Current time displayed to label
            
            currentHour = Integer.parseInt(hour.format(date)); //Current hour stored as an integer
            
            if ((currentHour >= 18) || (currentHour < 6)) { //If hour is between 18:00PM and 06:00AM...
                frame.getContentPane().setBackground(Color.darkGray); //Dark mode active
            }

            try {
                Thread.sleep(1000); //Pauses execution of thread for 1000 milliseconds
            } catch (Exception ex) {
            }
            
        }
        
    }
   
}
