package CinemaInc;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class Current { //Class contains all variables/methods regarding current details of the system (form, user and event)

    static String currentForm = ""; //Stores current form of system
    static String[] currentUser = new String[11]; //Stores details of user currently logged into system
    static String[] currentEvent = new String[8]; //Stores details of event currently being referenced in system

    /**
     * Constructor method for Current class
     */
    public Current() {

    }

    /**
     * Sets currentForm upon a new form being loaded in the system
     * 
     * @param currentForm current form of system
     */
    public static void setCurrentForm(String currentForm) {
        Current.currentForm = currentForm;
    }

    /**
     * Returns the current form of the system
     * 
     * @return currentForm
     */
    public static String getCurrentForm() {
        return Current.currentForm;
    }

    /**
     * Sets currentUser upon a user logging into the system
     * 
     * @param userDetails details of user logging into the system
     */
    public static void setCurrentUser(String[] userDetails) {
        Current.currentUser = userDetails;
    }

    /**
     * Returns the details of the user currently logged into the system
     * 
     * @return currentUser
     */
    public static String[] getCurrentUserDetails() {
        return Current.currentUser;
    }

    /**
     * Returns the primary key of the user currently logged into the system
     * 
     * @return currentUser[0]
     */
    public static String getCurrentUserID() {
        return Current.currentUser[0];
    }

    /**
     * Returns the level of access of the user currently logged into the system
     * 
     * @return current users level of access
     */
    public static String getLoa() {
        String id = Current.currentUser[0]; //Stores the current users primary key
        String[] idArray = new String[9]; //Stores the current users primary key as an array
        idArray = id.split(""); //Current users primary key split into array

        //Stores current users type from the first 3 characters of their primary key
        String userType = idArray[0] + idArray[1] + idArray[2];
        
        String loa = "loa not found"; //Stores current users level of access

        if (userType.equals("CUS")) {
            loa = "customer";
        }
        if (userType.equals("WOR")) {
            loa = "worker";
        }
        if (userType.equals("MAN")) {
            loa = "manager";
        }
        
        return loa;
    }

    /**
     * Calculates the current users age
     * 
     * @param currentDate the date the method is called
     * @return current users age
     */
    public static int ageCalc(String currentDate) {
        int age; //Stores the current users age
        String[] dobArray = currentUser[10].split(""); //Stores current users date of birth as an array
        String[] currentDateArray = currentDate.split(""); //Stores current date as an array

        //Current users birth day, month and year constructed and converted to integer
        int birthDay = Integer.parseInt(dobArray[0] + dobArray[1]);
        int birthMonth = Integer.parseInt(dobArray[3] + dobArray[4]);
        int birthYear = Integer.parseInt(dobArray[6] + dobArray[7] + dobArray[8] + dobArray[9]);
        
        //Current day, month and year constructed and converted to integer
        int currentDay = Integer.parseInt(currentDateArray[0] + currentDateArray[1]);
        int currentMonth = Integer.parseInt(currentDateArray[3] + currentDateArray[4]);
        int currentYear = Integer.parseInt(currentDateArray[6] + currentDateArray[7] + currentDateArray[8] + currentDateArray[9]);

        age = (currentYear - 1) - birthYear; //User is atleast as old as they were last year
        
        if ((birthMonth >= currentMonth) && (birthDay >= currentDay)) { //If users birthday has passed...
            age = age + 1;
        }

        return age;
    }

    /**
     * Empties currentUser upon a user logging out
     */
    public static void logOutUser() {
        Current.currentUser = null;
    }

    /**
     * Sets currentEvent upon an event being referenced to in the system
     * 
     * @param event event being referenced to by a form
     */
    public static void setCurrentEvent(String[] event) {
        Current.currentEvent = event;
    }

    /**
     * Returns the details of the event currently being referenced to in the system
     * 
     * @return currentEvent
     */
    public static String[] getCurrentEvent() {
        return Current.currentEvent;
    }

    /**
     * Empties currentEvent upon an event no longer being referenced to 
     */
    public static void removeCurrentEvent() {
        Current.currentEvent = null;
    }

    /**
     * Returns the primary key of the current event
     * 
     * @return currentEvent[0]
     */
    public static String getCurrentEventID() {
        return Current.currentEvent[0];
    }

    /**
     * Returns the title of the current event
     * 
     * @return currentEvent[1]
     */
    public static String getCurrentEventTitle() {
        return Current.currentEvent[1];
    }

    /**
     * Returns the age rating of the current event
     * 
     * @return currentEvent[3]
     */
    public static int getCurrentEventRating() {
        return Integer.parseInt(currentEvent[3]);
    }

    /**
     * Returns the date the system is currently being run on
     * 
     * @return current date
     */
    public static String getCurrentDate() {
        //New SimpleDateFormat object created for the "dd/MM/yyyy" format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(); //New Date object created
        
        String currentDate = dateFormat.format(date); //Stores the current date in the format "dd/MM/yyyy"
        return currentDate;
    }

}
