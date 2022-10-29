package CinemaInc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class BookingTimer { //BookingTimer class stores how many seconds a user has left during a booking,
                           //for a Timer object on a booking form to count down from an appropriate amount of time
    
    static int secondsLeft = 300; //Stores how many seconds a user has left during a booking
    
    /**
     * Constructor method for the BookingTimer class
     */
    public BookingTimer(){
        
    }

    /**
     * Returns how many seconds a user has left during a booking
     * 
     * @return secondsLeft
     */
    public static int getSecondsLeft() {
        return secondsLeft;
    }

    /**
     * Sets the updated amount of time a user has left during a booking
     * 
     * @param newSecondsLeft the updated amount of time the user has left
     */
    public static void setSecondsLeft(int newSecondsLeft) {
        secondsLeft = newSecondsLeft;
    }
    
    /**
     * Sets secondsLeft back to 5 minutes (300 seconds)
     * for the variable to be used again for future booking timers
     */
    public static void resetSecondsLeft(){
        secondsLeft = 300;
    }
    
}
