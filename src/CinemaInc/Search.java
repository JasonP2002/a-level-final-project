package CinemaInc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class Search { //The Search class contains all methods related to searching through files

    Current current = new Current(); //New Current object created

    /**
     * Constructor method for the Search class
     */
    public Search() {

    }

    /**
     * Searches for a record containing an email inputted by a user in the
     * LogInUI class. If this email is found, the password in the record is
     * compared with the password also inputted by the user. If they match, the
     * user is allowed access to the system and the currentUser variable in the
     * Current class is set
     *
     * @param email email inputted by the user in the LogInUI class
     * @param password password inputted by the user in the LogInUI class
     * @return boolean stating whether a user has been given access to the
     * system or not
     */
    public boolean logIn(String email, String password) {
        boolean loggedIn = false; //Stores whether a user has been given access to the system or not
        boolean emailFound = false; //Determines if a users email is found to be linked with an account

        String currentLine; //Stores the current line being read from the file
        String[] currentAccount = new String[11]; //Stores the current line of the file as an array

        try {
            FileReader fileReader = new FileReader("users.txt"); //A new FileReader object is created to read through "users.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //A new BufferedReader object is created for fileReader

            while (((currentLine = bufferReader.readLine()) != null) && (emailFound == false)) {
                currentAccount = currentLine.split(","); //Current line of file split into array

                if (currentAccount[1].equals(email)) {
                    emailFound = true;

                    if (currentAccount[2].equals(password)) {
                        current.setCurrentUser(currentAccount); //User given access to the system (currentUser variable set in Current class)
                        JOptionPane.showMessageDialog(null, "Welcome Back " + currentAccount[3] + "!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
                        loggedIn = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Password. Please try again.", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        if (emailFound == false) {
            JOptionPane.showMessageDialog(null, "This email is not registered to an account. Please sign up below.", "Account Not Found", JOptionPane.ERROR_MESSAGE);
        }

        return loggedIn;
    }

    /**
     * Searches through the user account file to determine if the email a user
     * is trying to register with an account is already linked to an existing
     * account
     *
     * @param email email a user is attempting to register with an account
     * @return boolean stating whether or not the inputted email is already
     * linked to an account
     */
    public static boolean emailSearch(String email) {
        boolean emailExists = false; //Stores whether email is already linked to an account or not

        String currentLine; //Stores current line being read from the file
        String currentAccount[] = new String[11]; //Stores current line of file as an array

        try {
            FileReader fileReader = new FileReader("users.txt"); //New FileReader object created to read through "users.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while (((currentLine = bufferReader.readLine()) != null) && (emailExists == false)) {
                currentAccount = currentLine.split(","); //Current line of file split into array

                if (currentAccount[1].equals(email)) {
                    emailExists = true;
                    JOptionPane.showMessageDialog(null, "This email is already registered to an account. Please try a different email.", "Email Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return emailExists;
    }

    /**
     * A binary search to find an events record by its primary key Only works
     * when events file is sorted
     *
     * @param searchEventPK primary key of event record being searched for
     * @param numRecords number of records currently in events file
     * @return event record as a 1D array
     */
    public static String[] eventBinarySearch(String searchEventPK, int numRecords) {
        boolean found = false; //Stores whether or not record has been found

        int min = 1; //Stores minimum position of record in file which will be searched
        int max = numRecords; //Stores maximum position of record in file which will be searched
        int mid; //Stores position of record at the mid point between the min and max values

        String currentLine; //Stores current line being read from the file
        String currentEvent[] = new String[8]; //Stores current line of file as an array
        String midPK; //Stores primary key of record at mid position

        try {
            while ((found == false) && (max >= min)) {
                mid = (max + min) / 2;

                currentLine = Files.readAllLines(Paths.get("events.txt")).get(mid - 1); //Record at mid position is found
                currentEvent = currentLine.split(","); //Current line split into array
                midPK = currentEvent[0];

                if ((searchEventPK.compareToIgnoreCase(midPK)) > 0) { //If searchEventPK > midPK...
                    min = mid + 1; //Minimum position moved up
                }

                if ((searchEventPK.compareToIgnoreCase(midPK)) < 0) { //If searchEventPK < midPK...
                    max = mid - 1; //Maximum position moved down
                }

                if ((searchEventPK.compareToIgnoreCase(midPK)) == 0) { //If searchEventPK = midPK...
                    found = true;
                    return currentEvent;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return currentEvent;
    }

    /**
     * Searches for an event based on the title, date and time inputted by a
     * user in the quick search feature of the MainMenuUI class
     *
     * @param eventTitle title inputted by user
     * @param eventDate date inputted by user
     * @param eventTime time inputted by user
     * @return boolean stating whether or not event has been found and set in
     * the Current class
     */
    public boolean quickSearch(String eventTitle, String eventDate, String eventTime) {
        boolean found = false; //Stores whether or not event has been found and set

        String currentLine; //Stores line currently being read from file
        String[] currentEvent = new String[8]; //Stores current line as an array

        try {
            FileReader fileReader = new FileReader("events.txt"); //New FileReader object created to read through "events.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while (((currentLine = bufferReader.readLine()) != null) && (found == false)) {
                currentEvent = currentLine.split(","); //Current line split into array

                if (currentEvent[1].equalsIgnoreCase(eventTitle) && currentEvent[4].equals(eventDate) && currentEvent[5].equals(eventTime)) { //If event is found...
                    current.setCurrentEvent(currentEvent); //currentEvent variable set in Current class
                    found = true;
                    return found;
                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
            JOptionPane.showMessageDialog(null, "This event could not be found. Please make sure title, date and time are correct.", "Event Not Found", JOptionPane.ERROR_MESSAGE);
            return found;
        }

        return found;
    }

    /**
     * Counts how many records are in a certain file
     *
     * @param file file with records being counted
     * @return integer storing the amount of records
     */
    public static int countRecords(String file) {
        int numRecords = 0; //Stores number of records in file
        String currentLine; //Stores current line of file being read from

        try {
            FileReader fileReader = new FileReader(file); //New FileReader object created to read through file
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while ((currentLine = bufferReader.readLine()) != null) { //While more records...
                numRecords = numRecords + 1;
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return numRecords;
    }

    /**
     * Searches through the events file to collect all event records into a 2D
     * array
     *
     * @param numRecords number of records currently in events file
     * @return 2D array containing all event records
     */
    public static String[][] getAllEvents(int numRecords) {
        String[][] recordArray = new String[numRecords][8]; //Stores all event records in a 2D array

        String currentLine; //Stores current line being read from file
        String currentRecord[] = new String[8]; //Stores current line as an array
        int currentRow = 0; //Stores current row of array being added to

        try {
            FileReader fileReader = new FileReader("events.txt"); //New FileReader object created to read through "events.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while ((currentLine = bufferReader.readLine()) != null) { //While more records...
                currentRecord = currentLine.split(","); //Current line split into array

                recordArray[currentRow] = currentRecord;

                currentRow = currentRow + 1;
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return recordArray;
    }

    /**
     * Searches through either basket or finalized bookings file to see if a
     * user has already added the event they are trying to book for to their
     * basket/has a finalized booking for the event already in place
     *
     * @param filePath file to be searched through
     * @param userID primary key of the user attempting to book for an event
     * @param eventID primary key of the event being booked for
     * @return boolean stating whether or not a record linking the user and
     * event already exists
     */
    public static boolean bookingFileSearch(String filePath, String userID, String eventID) {
        boolean bookingExists = false; //Stores whether a record linking the user and event has been found or not

        String currentLine; //Stores current line of file being read from
        String[] currentBooking = new String[6]; //Stores current line as an array

        try {
            FileReader fileReader = new FileReader(filePath); //New FileReader object created for filePath
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            //While more records + record linking user and event not found...
            while (((currentLine = bufferReader.readLine()) != null) && (bookingExists == false)) {
                currentBooking = currentLine.split(","); //Current line split into array
                
                if ((currentBooking[1].equals(userID)) && (currentBooking[2].equals(eventID))) { //If record links user and event...
                    bookingExists = true;
                    return bookingExists;
                }

            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) { //If error...
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
            bookingExists = true; //Assumes record exists to ensure that if the record does actually exist the user cant book for the event twice
            return bookingExists;
        }

        return bookingExists;
    }

    /**
     * Searches through the finalized bookings file to collect all the seats
     * booked for a specific event
     *
     * @param eventID primary key of event thats booked seats are being searched
     * for
     * @return "-" separated String storing seat codes of all booked seats
     */
    public static String getBookedSeats(String eventID) {
        String bookedSeats = ""; //Stores seat codes of all booked seats

        String currentLine; //Stores current line of file being read through
        String[] currentBooking = new String[6]; //Stores current line as an array

        try {
            FileReader fileReader = new FileReader("bookings.txt"); //New FileReader object created for "bookings.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while ((currentLine = bufferReader.readLine()) != null) {
                currentBooking = currentLine.split(","); //Current line split into an array

                if (currentBooking[2].equals(eventID)) { //If current booking is for the specified event...
                    bookedSeats = bookedSeats + currentBooking[4] + "-";

                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return bookedSeats;
    }

    /**
     * Counts how many basket items a specific user has
     *
     * @param currentUserID primary key of user whose basket items are being
     * searched for
     * @return integer storing how many basket items the user has
     */
    public static int countBasketItems(String currentUserID) {
        int numberItems = 0; //Stores how many basket items a user has

        String currentLine; //Stores current line being read from file
        String[] currentBasketItem = new String[6]; //Stores current line as an array

        try {
            FileReader fileReader = new FileReader("basket.txt"); //New FileReader object created for "basket.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while ((currentLine = bufferReader.readLine()) != null) {
                currentBasketItem = currentLine.split(","); //Current line split into an array

                if (currentBasketItem[1].equals(currentUserID)) { //If current basket item relates to specified user...
                    numberItems = numberItems + 1;
                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return numberItems;
    }

    /**
     * Collects all of a specific users basket items into a 2D array
     *
     * @param currentUserID primary key of user whose basket items are being
     * collected
     * @param numberItems number of basket items a specified user has
     * @return 2D array containing all of a specified users basket items
     */
    public static String[][] getBasketItems(String currentUserID, int numberItems) {
        String[][] basketItems = new String[numberItems][6]; //Stores a users basket items

        String currentLine; //Stores current line being read from file
        String[] currentBasketItem = new String[6]; //Stores current line as an array
        int row = 0; //Stores current row of 2D array being added to

        try {
            FileReader fileReader = new FileReader("basket.txt"); //New FileReader object created for "basket.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while ((currentLine = bufferReader.readLine()) != null) {
                currentBasketItem = currentLine.split(","); //Current line split into array

                if (currentBasketItem[1].equals(currentUserID)) { //If current basket item is one of the specified users...
                    basketItems[row] = currentBasketItem;
                    row = row + 1;
                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return basketItems;
    }

    /**
     * Searches for an events title based on its primary key
     *
     * @param eventID primary key of event
     * @return String containing title of event
     */
    public static String getEventTitle(String eventID) {
        String eventTitle = "Event Title Not Found"; //Stores title of event

        boolean found = false; //Stores whether title has been found or not
        String currentLine; //Stores current line being read from file
        String[] currentEvent = new String[8]; //Stores current line as an array

        try {
            FileReader fileReader = new FileReader("events.txt"); //New FileReader object created for "events.txt"
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            //While more records + title not found...
            while (((currentLine = bufferReader.readLine()) != null) && (found == false)) {
                currentEvent = currentLine.split(","); //Current line split into array

                if (currentEvent[0].equals(eventID)) { //If current pk = searchpk...
                    eventTitle = currentEvent[1];
                    found = true;
                    return eventTitle;
                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        return eventTitle;
    }

    /**
     * Upon a user trying to delete their account, searches through either the
     * basket file or the finalized bookings file to ensure they have no basket
     * items/ bookings in place. If they do, they are unable to delete their
     * account
     *
     * @param filepath file being searched through
     * @param currentUserID primary key of user trying to delete their account
     * @return boolean stating whether or not a user has basket items/finalized
     * bookings in place
     */
    public static boolean deleteAccountSearch(String filepath, String currentUserID) {
        boolean bookings = false; //Stores whether a user has basket items/finalized bookings in place

        String currentLine; //Stores current line being read from file
        String[] currentBooking = new String[6]; //Stores current line as an array

        try {
            FileReader fileReader = new FileReader(filepath); //New FileReader object created for filepath
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            //While more records + no bookings from user found...
            while (((currentLine = bufferReader.readLine()) != null) && (bookings == false)) {
                currentBooking = currentLine.split(","); //Current line split into array

                if (currentBooking[1].equals(currentUserID)) { //If current booking is from the specified user...
                    bookings = true;
                    return bookings;
                }
            }

            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) { //If error...
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
            JOptionPane.showMessageDialog(null, "Cannot delete account.", "Error!", JOptionPane.ERROR_MESSAGE);

            bookings = true; //Assumes user has booking to ensure if they actually do they cannot delete their account
            return bookings;
        }

        return bookings;
    }

}
