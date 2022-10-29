package CinemaInc;

import java.util.Timer;
import java.util.TimerTask;
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
public class EventBookingUI extends javax.swing.JFrame { //EventBookingUI class initializes and contains all methods
                                                        //related to the Ticket Booking Form

    //New Booking, BookingTimer, Clock, Currency, Current, FileHandling,
    //Image, Search, Sort and Timer objects created
    Booking booking = new Booking();
    BookingTimer secondsLeft = new BookingTimer();
    Clock eventBookingClock = new Clock();
    Currency currency = new Currency();
    Current current = new Current();
    FileHandling fileHandling = new FileHandling();
    Image image = new Image();
    Search search = new Search();
    Sort sort = new Sort();
    Timer bookingTimer = new Timer();

    String[] currentEvent = current.getCurrentEvent(); //Stores details of current event
    String currentForm = current.getCurrentForm(); //Stores forms current purpose

    int currencyIndex = currency.getCurrencyIndex(); //Stores index of users chosen currency
    String currencySymbol = currency.findSymbol(currencyIndex); //Stores symbol of users chosen currency
    float ticketPrice = Float.parseFloat(currentEvent[6]); //Stores cost per ticket for current event in £
    //Stores converted cost per ticket as a String
    String convertedTicketPrice = currency.convertAmount(ticketPrice, currencyIndex);

    int numTickets = booking.getNumTickets(); //Stores number of tickets user has already selected
    float bookingPrice = booking.getBookingPrice(); //Stores cost of already selected tickets in £

    //Stores amount of seconds user has left to book tickets
    int timeLeft = secondsLeft.getSecondsLeft();
    String minutes; //Stores number of minutes user has left to book tickets as a String
    String seconds; //Stores number of seconds user has left to book tickets as a String

    //New TimerTask object created
    TimerTask task = new TimerTask() {
        //run() method contains task for timer - runs once every second
        public void run() {

            timeLeft = timeLeft - 1;

            if (timeLeft == -1) { //If user has run out of time...
                bookingTimer.cancel();
                secondsLeft.resetSecondsLeft(); //Resets secondsLeft in BookingTimer class to 300 seconds (5 minutes)

                JOptionPane.showMessageDialog(null, "Sorry, you have run out of time.", "Timed Out!", JOptionPane.ERROR_MESSAGE);

                booking.emptyBooking(); //Clears variables in Booking class
                current.removeCurrentEvent(); //Clears currentEvent[] in Current class

                eventBookingClock.stopClock();

                //If form being used to add tickets to basket...
                if (currentForm.equals("Booking View 1") || currentForm.equals("Booking View 2")) {
                    current.setCurrentForm("Main Menu"); //Sets currentForm in Current class to "Main Menu"

                    MainMenuUI mainMenuForm = new MainMenuUI(); //New MainMenuUI object created
                    mainMenuForm.setVisible(true);
                }

                //If form being used to edit tickets already in basket...
                if (currentForm.equals("Edit Booking 1") || currentForm.equals("Edit Booking 2")) {
                    current.setCurrentForm("Basket"); //Sets currentForm in Current class to "Basket"

                    BasketUI basketForm = new BasketUI(); //New BasketUI object created
                    basketForm.setVisible(true);
                }

                dispose(); //Current form disposed of
            }

            //Minutes left is result of time left divided by 60 (seconds)
            minutes = String.valueOf(timeLeft / 60);
            //Seconds left is remainder of time left divided by 60 (seconds)
            seconds = String.valueOf(timeLeft % 60);

            if (seconds.length() == 1) { //If seconds in single digits...
                seconds = 0 + seconds;
            }

            timerLbl.setText("Time Left: " + minutes + ":" + seconds);
        }
    };

    /**
     * Constructor method for EventBookingUI class
     *
     * Creates new form EventBookingUI
     * Sets form features depending on forms current purpose
     * Starts clock
     * Starts booking timer
     * Displays event icon
     */
    public EventBookingUI() {
        initComponents();

        setLocationRelativeTo(null);

        setFeatures();

        eventBookingClock.setLabel(timeLbl);
        eventBookingClock.setFrame(this);
        eventBookingClock.start();

        bookingTimer.schedule(task, 1000, 1000);

        image.setEventIcon(currentEvent[2], imageLbl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cinemaLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        imageLbl = new javax.swing.JLabel();
        eventTitleLbl = new javax.swing.JLabel();
        timerLbl = new javax.swing.JLabel();
        ticketLbl = new javax.swing.JLabel();
        minusBtn = new javax.swing.JButton();
        plusBtn = new javax.swing.JButton();
        bottomLbl = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        rightBtn = new javax.swing.JButton();
        leftBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cinemaLbl.setFont(new java.awt.Font("Tahoma", 3, 60)); // NOI18N
        cinemaLbl.setText("Cinema Inc.");

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Booking");

        timeLbl.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        timeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeLbl.setText("00:00");

        imageLbl.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        imageLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventTitleLbl.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        eventTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventTitleLbl.setText("Event Title + Age Rating ");
        eventTitleLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        timerLbl.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        timerLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timerLbl.setText("Time Left: 0:00");
        timerLbl.setToolTipText("");
        timerLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ticketLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ticketLbl.setText("Tickets: + Ticket Price (Max. 5): 0");
        ticketLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        minusBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        minusBtn.setText("-");
        minusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusBtnActionPerformed(evt);
            }
        });

        plusBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        plusBtn.setText("+");
        plusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusBtnActionPerformed(evt);
            }
        });

        bottomLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        bottomLbl.setText("Total: £0.00");
        bottomLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalLbl.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        totalLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalLbl.setText("Total Price: £0.00");
        totalLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rightBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rightBtn.setText("Choose Seats");
        rightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBtnActionPerformed(evt);
            }
        });

        leftBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        leftBtn.setText("View Event");
        leftBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(eventTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ticketLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                                        .addComponent(bottomLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(plusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(minusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cinemaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cinemaLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(timerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eventTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(ticketLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottomLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(leftBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBtnActionPerformed
        //If form being used as first form in ticket booking process...
        if (currentForm.equals("Booking View 1")) {
            bookingTimer.cancel();
            //Resets secondsLeft in BookingTimer class to 300 seconds (5 minutes)
            secondsLeft.resetSecondsLeft();
            //Clears variables in Booking class
            booking.emptyBooking();

            current.setCurrentForm("Event Info"); //Sets currentForm in Current class to "Event Info"

            eventBookingClock.stopClock();
            EventInfoUI eventInfoForm = new EventInfoUI(); //New EventInfoUI object created
            eventInfoForm.setVisible(true);
        }

        //If form being used as second form in ticket booking process...
        if (currentForm.equals("Booking View 2")) {
            bookingTimer.cancel();
            //Sets secondsLeft in Booking class to amount of seconds left on the booking timer
            secondsLeft.setSecondsLeft(timeLeft);
            //Clears users currently selected seats (next form loaded is SeatingPlanUI
            //to allow users to select new seats.)
            booking.emptySeats();

            current.setCurrentForm("Booking Seating Plan");

            eventBookingClock.stopClock();
            SeatingPlanUI seatingPlanForm = new SeatingPlanUI();
            seatingPlanForm.setVisible(true);
        }

        //If form being used as first form in basket item editing process...
        if (currentForm.equals("Edit Booking 1")) {
            bookingTimer.cancel();
            secondsLeft.resetSecondsLeft();
            booking.emptyBooking();
            //Clears variable in Booking class storing primary key of basket item being edited
            booking.removeEditBookingID();

            current.setCurrentForm("Basket");

            eventBookingClock.stopClock();
            BasketUI basketForm = new BasketUI();
            basketForm.setVisible(true);
        }

        //If form being used as second form in basket item editing process...
        if (currentForm.equals("Edit Booking 2")) {
            bookingTimer.cancel();
            secondsLeft.setSecondsLeft(timeLeft);
            booking.emptySeats();

            current.setCurrentForm("Edit Booking Seating Plan");

            eventBookingClock.stopClock();
            SeatingPlanUI editSeatingPlanForm = new SeatingPlanUI();
            editSeatingPlanForm.setVisible(true);
        }

        dispose(); //Current form disposed of
    }//GEN-LAST:event_leftBtnActionPerformed

    private void plusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusBtnActionPerformed
        if (numTickets < 5) { //If numTickets < max number of tickets a user can book...

            numTickets = numTickets + 1;
            bookingPrice = bookingPrice + ticketPrice;

            //Stores cost of current set of tickets after currency conversion as a String
            String bookingPriceLabel = currency.convertAmount(bookingPrice, currencyIndex);

            ticketLbl.setText("Tickets: " + currencySymbol + convertedTicketPrice + " (Max. 5): " + numTickets);
            bottomLbl.setText("Total: " + currencySymbol + bookingPriceLabel);
        }
    }//GEN-LAST:event_plusBtnActionPerformed

    private void minusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusBtnActionPerformed
        if (numTickets > 0) { //If numTickets > min number of tickets possible...

            numTickets = numTickets - 1;
            bookingPrice = bookingPrice - ticketPrice;

            //Stores cost of current set of tickets after currency conversion as a String
            String bookingPriceLabel = currency.convertAmount(bookingPrice, currencyIndex);

            ticketLbl.setText("Tickets: " + currencySymbol + convertedTicketPrice + " (Max. 5): " + numTickets);
            bottomLbl.setText("Total: " + currencySymbol + bookingPriceLabel);
        }
    }//GEN-LAST:event_minusBtnActionPerformed

    private void rightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBtnActionPerformed
        //If form being used as first form in ticket booking/basket item editing process...
        if (currentForm.equals("Booking View 1") || currentForm.equals("Edit Booking 1")) {

            if (numTickets == 0) { //If no tickets selected...
                JOptionPane.showMessageDialog(null, "Please specify how many tickets you require.", "Ticket Error", JOptionPane.ERROR_MESSAGE);
            } else {
                //Sets details about current booking in Booking class
                booking.setNumTickets(numTickets);
                booking.setBookingPrice(bookingPrice);

                bookingTimer.cancel();
                //Sets number of seconds left on the booking timer in Booking class
                secondsLeft.setSecondsLeft(timeLeft);
                eventBookingClock.stopClock();

                if (currentForm.equals("Booking View 1")) {
                    current.setCurrentForm("Booking Seating Plan"); //Sets currentForm in Current class to "Booking Seating Plan"

                    SeatingPlanUI seatingPlanForm = new SeatingPlanUI(); //New SeatingPlanUI object created
                    seatingPlanForm.setVisible(true);
                }

                if (currentForm.equals("Edit Booking 1")) {
                    current.setCurrentForm("Edit Booking Seating Plan");

                    SeatingPlanUI editSeatingPlanForm = new SeatingPlanUI();
                    editSeatingPlanForm.setVisible(true);
                }

                dispose(); //Current form disposed of
            }
        }

        //If form being used as second form in booking process...
        if (currentForm.equals("Booking View 2")) {
            String bookingPK = fileHandling.generatePK("BOO"); //Stores randomly generated primary key of booking record
            String currentUserID = current.getCurrentUserID(); //Stores primary key of current user
            String currentEventID = current.getCurrentEventID(); //Stores primary key of event being booked for

            //Stores full booking record as a comma separated String
            String fullBooking = booking.getFullBooking(bookingPK, currentUserID, currentEventID);
            //Stores whether or not record was added to file successfully
            boolean added = fileHandling.addRecord(fullBooking, "basket.txt");
            
            int numberRecords = search.countRecords("basket.txt"); //Stores number of records currently in basket file
            sort.bubbleSort("basket.txt", 6, numberRecords); //File sorted into ascending order of primary key

            if (added == true) { //If record was added to file successfully...
                JOptionPane.showMessageDialog(null, "Booking added to basket!", "Added To Basket", JOptionPane.INFORMATION_MESSAGE);
            } else { //If record was not added successfully...
                JOptionPane.showMessageDialog(null, "Booking could not be added to basket.", "Add Error", JOptionPane.ERROR_MESSAGE);
            }

            bookingTimer.cancel();
            //Resets secondsLeft in BookingTimer class to 300 seconds (5 minutes)
            secondsLeft.resetSecondsLeft();

            //Clears variables in Booking class
            booking.emptyBooking();
            //Clears currentEvent[] in Current class
            current.removeCurrentEvent();

            current.setCurrentForm("Main Menu");

            eventBookingClock.stopClock();
            MainMenuUI mainMenuForm = new MainMenuUI();
            mainMenuForm.setVisible(true);
            dispose();
        }

        //If form being used as second form in basket item editing process...
        if (currentForm.equals("Edit Booking 2")) {
            //Stores primary key of booking being edited
            String editBookingPK = booking.getEditBookingID();
            //Stores primary key of current user
            String currentUserID = current.getCurrentUserID();
            //Stores primary key of current event
            String currentEventID = current.getCurrentEventID();

            //Stores full edited record as a comma separated String
            String fullBooking = booking.getFullBooking(editBookingPK, currentUserID, currentEventID);
            //Stores whether record was successfully edited or not
            boolean edited = fileHandling.editRecord(editBookingPK, fullBooking, 6, "basket.txt");

            if (edited == true) { //If booking was edited successfully...
                JOptionPane.showMessageDialog(null, "Basket item edited!", "Edited!", JOptionPane.INFORMATION_MESSAGE);
            } else { //If booking could not be edited successfully...
                JOptionPane.showMessageDialog(null, "Could not edit basket item.", "Edit Error", JOptionPane.INFORMATION_MESSAGE);
            }

            bookingTimer.cancel();
            //Resets seconds in BookingTimer class to 300 seconds (5 minutes)
            secondsLeft.resetSecondsLeft();

            //Clears all variables in Booking class
            booking.removeEditBookingID();
            booking.emptyBooking();
            //Clears currentEvent[] in Current class
            current.removeCurrentEvent();

            current.setCurrentForm("Basket");

            eventBookingClock.stopClock();
            BasketUI basketForm = new BasketUI();
            basketForm.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_rightBtnActionPerformed

    /**
     * Sets form features depending on forms current purpose
     */
    public void setFeatures() {
        eventTitleLbl.setText(currentEvent[1] + " - " + currentEvent[3]);

        //Stores cost of selected number of tickets after currency conversion as a String
        String bookingPriceLabel = currency.convertAmount(bookingPrice, currencyIndex);

        String selectedSeats; //Stores a users selected seats as a comma separated String

        //Initializes first frame of Booking timer
        minutes = String.valueOf(timeLeft / 60);
        seconds = String.valueOf(timeLeft % 60);

        if (seconds.length() == 1) { //If seconds in single digits...
            seconds = 0 + seconds;
        }

        //If form being used as first form in ticket booking/basket item editing process...
        if ((currentForm.equals("Booking View 1")) || (currentForm.equals("Edit Booking 1"))) {
            timerLbl.setText("Time Left: " + minutes + ":" + seconds);

            ticketLbl.setText("Tickets: " + currencySymbol + convertedTicketPrice + " (Max. 5): " + numTickets);
            bottomLbl.setText("Total: " + currencySymbol + bookingPriceLabel);
            totalLbl.setVisible(false);
        }

        //If form being used as second form in ticket booking/basket item editing process...
        if ((currentForm.equals("Booking View 2")) || (currentForm.equals("Edit Booking 2"))) {
            timerLbl.setText("Time Left: " + minutes + ":" + seconds);

            ticketLbl.setText("Tickets: " + numTickets);
            plusBtn.setEnabled(false);
            plusBtn.setVisible(false);
            minusBtn.setEnabled(false);
            minusBtn.setVisible(false);
            selectedSeats = booking.getCurrentBookingSeatsString();
            bottomLbl.setText("Seats: " + selectedSeats);
            totalLbl.setText("Total: " + currencySymbol + bookingPriceLabel);

            leftBtn.setText("Choose Seats");
            rightBtn.setText("Add To Basket");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EventBookingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventBookingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventBookingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventBookingUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventBookingUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bottomLbl;
    private javax.swing.JLabel cinemaLbl;
    private javax.swing.JLabel eventTitleLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JButton leftBtn;
    private javax.swing.JButton minusBtn;
    private javax.swing.JButton plusBtn;
    private javax.swing.JButton rightBtn;
    private javax.swing.JLabel ticketLbl;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel timerLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
}
