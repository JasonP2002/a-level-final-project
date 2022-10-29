package CinemaInc;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;
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
public class Booking { //Booking class stores details of current Booking in progress, as well as methods relating to the SeatingPlanUI class

    static int numTickets = 0; //Stores number of tickets being booked
    static float bookingPrice = 0; //Stores cost of current Booking

    static boolean[] seats = new boolean[50]; //Stores booleans representing all seats and whether they are selected(true) or unselected(false)
    static String[] currentBookingSeats = new String[5]; //Stores seats currently selected

    static String editBookingID = ""; //Stores primary key of basket item currently being edited

    /**
     * Constructor method for Booking class
     */
    public Booking() {

    }

    /**
     * Returns number of tickets being booked
     *
     * @return numTickets
     */
    public static int getNumTickets() {
        return numTickets;
    }

    /**
     * Sets number of tickets currently being booked
     *
     * @param numTickets number of tickets being booked
     */
    public static void setNumTickets(int numTickets) {
        Booking.numTickets = numTickets;
    }

    /**
     * Returns cost of current Booking
     *
     * @return bookingPrice
     */
    public static float getBookingPrice() {
        return bookingPrice;
    }

    /**
     * Sets cost of current Booking
     *
     * @param bookingPrice cost of current Booking
     */
    public static void setBookingPrice(float bookingPrice) {
        Booking.bookingPrice = bookingPrice;
    }

    /**
     * Updates the seats[] and currentBookingSeats[] arrays depending on the
     * seat a user has selected/unselected in the SeatingPlanUI class
     *
     * @param loa level of access of user accessing SeatingPlanUI
     * @param arrayNum position in seats[] array of boolean corresponding to
     * relevant seat
     * @param seatCode code representing relevant seat
     * @param button JButton of relevant seat
     * @param label JLabel which outputs selected seats
     */
    public static void updateSeatingPlan(String loa, int arrayNum, String seatCode, JButton button, JLabel label) {
        if (loa.equals("customer")) { //If user accessing SeatingPlanUI is a Customer...
            //(Prevents other levels of access selecting seats when they view SeatingPlanUI)
            String selected = ""; //Stores whether seat is being selected or unselected

            if (seats[arrayNum] == false) { //If seat was previously unselected...
                seats[arrayNum] = true; //Seat is selected
                int i = 0;
                boolean updated = false; //Stores if currentBookingSeats[] array has been updated

                while ((i < numTickets) && (updated == false)) {

                    if (currentBookingSeats[i] == null) { //If position is free...
                        currentBookingSeats[i] = seatCode;
                        selected = "Selected";
                        updated = true;
                    } else {
                        i = i + 1;
                    }

                }

            } else { //If seat was previously selected...
                seats[arrayNum] = false; //Seat is unselected
                int i = 0;
                boolean found = false; //Stores whether seat has been found in currentBookingSeats[]

                while ((i < numTickets) && (found == false)) {

                    if (currentBookingSeats[i] != null) { //If position is taken...

                        if (currentBookingSeats[i].equals(seatCode)) { //If position contains seat being unselected...
                            currentBookingSeats[i] = null;
                            selected = "Unselected";
                            found = true;
                        }
                    }
                    i = i + 1;
                }

            }

            if (selected.equals("Selected")) {
                button.setBackground(Color.green);
            }
            if (selected.equals("Unselected")) {
                button.setBackground(null);
            }

            label.setText("Seats Selected: " + getCurrentBookingSeatsString());
        }

    }

    /**
     * Disables a seat button in the SeatingPlanUI class that corresponds to a
     * previously booked seat
     *
     * @param button JButton representing booked seat
     */
    public static void disableBookedSeats(JButton button) {
        button.setEnabled(false);
    }

    /**
     * Returns seats selected during current Booking as a comma separated String
     *
     * @return comma separated String of selected seats
     */
    public static String getCurrentBookingSeatsString() {
        String bookingSeats = ""; //Stores selected seats as String

        //All null items in currentBookingSeats[] removed for String
        for (int i = 0; i < numTickets; i++) {
            if (currentBookingSeats[i] != null) {
                bookingSeats = bookingSeats + currentBookingSeats[i] + ",";
            }
        }

        return bookingSeats;
    }

    /**
     * Clears selected seats
     */
    public static void emptySeats() {
        Arrays.fill(Booking.seats, false); //Sets all booleans in seats[] array to false(unselected)
        Arrays.fill(Booking.currentBookingSeats, null); //Clears currentBookingSeats[] array
    }

    /**
     * Constructs record of a Booking including the primary keys of the Booking,
 user and event being booked, with the number of tickets, selected seats
 and Booking price
     *
     * @param bookingPK primary key of the current Booking
     * @param userID primary key of the user currently Booking
     * @param eventID primary key of the event being booked
     * @return commas separated String of the Booking record
     */
    public static String getFullBooking(String bookingPK, String userID, String eventID) {
        String booking; //Stores Booking record as a comma separated String
        String[] bookingArray = new String[6]; //Stores Booking record as an array
        String seats = currentBookingSeats[0]; //Stores selected seats as a String

        bookingArray[0] = bookingPK;
        bookingArray[1] = userID;
        bookingArray[2] = eventID;

        bookingArray[3] = String.valueOf(numTickets);

        //All null items in currentBookingSeats[] removed for Booking record
        for (int i = 1; i < 5; i++) {
            if (currentBookingSeats[i] != null) {
                seats = seats + "-" + currentBookingSeats[i];
            }
        }

        bookingArray[4] = seats;
        bookingArray[5] = String.valueOf(bookingPrice);

        booking = String.join(",", bookingArray);
        return booking;
    }

    /**
     * Clears all details of a Booking including the number of tickets, Booking
 price and selected seats
     */
    public static void emptyBooking() {
        Booking.numTickets = 0;
        Booking.bookingPrice = 0;
        Arrays.fill(Booking.seats, false); //Sets all booleans in seats[] array to false(unselected)
        Arrays.fill(Booking.currentBookingSeats, null); //Clears currentBookingSeats[] array
    }

    /**
     * Returns the primary key of the Booking currently being edited
     *
     * @return editBookingID
     */
    public static String getEditBookingID() {
        return editBookingID;
    }

    /**
     * Sets the primary key of the Booking being edited
     *
     * @param newEditBookingID PK of Booking currently being edited
     */
    public static void setEditBookingID(String newEditBookingID) {
        editBookingID = newEditBookingID;
    }

    /**
     * Clears the primary key of a Booking being edited
     */
    public static void removeEditBookingID() {
        editBookingID = "";
    }

}