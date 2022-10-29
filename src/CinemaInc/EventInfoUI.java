package CinemaInc;

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
public class EventInfoUI extends javax.swing.JFrame { //EventInfoUI class initializes and contains all methods related
                                                     //to the Event Information Form

    //New Clock, Currency, Current, Image and Search objects created
    Clock eventInfoClock = new Clock();
    Currency currency = new Currency();
    Current current = new Current();
    Image image = new Image();
    Search search = new Search();

    String currentForm = current.getCurrentForm(); //Stores current purpose of form
    String loa = current.getLoa(); //Stores level of access of current user

    String[] currentEvent = current.getCurrentEvent(); //Stores details of current event as an array

    /**
     * Constructor method for EventInfoUI class
     *
     * Creates new form EventInfoUI
     * Sets form features depending on current users level of access 
     * Starts clock 
     * Displays certain events details + icon
     */
    public EventInfoUI() {
        initComponents();

        setLocationRelativeTo(null);

        setFeatures();

        eventInfoClock.setLabel(timeLbl);
        eventInfoClock.setFrame(this);
        eventInfoClock.start();

        setEvent();
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
        timeLbl = new javax.swing.JLabel();
        imageLbl = new javax.swing.JLabel();
        eventTitleLbl = new javax.swing.JLabel();
        typeLbl = new javax.swing.JLabel();
        eventTimeLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        rightBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cinemaLbl.setFont(new java.awt.Font("Tahoma", 3, 60)); // NOI18N
        cinemaLbl.setText("Cinema Inc.");

        timeLbl.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        timeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeLbl.setText("00:00");

        imageLbl.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        imageLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventTitleLbl.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        eventTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventTitleLbl.setText("Event Title - Age Rating");
        eventTitleLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        typeLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        typeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeLbl.setText("Event Type");
        typeLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        eventTimeLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        eventTimeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eventTimeLbl.setText("Time");
        eventTimeLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dateLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLbl.setText("Date");
        dateLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        priceLbl.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        priceLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLbl.setText("Ticket Price");
        priceLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        descriptionLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLbl.setText("Description");
        descriptionLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backBtn.setText("Go To Events");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        rightBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rightBtn.setText("Add To Basket");
        rightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        editBtn.setText("Edit Event Details");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cinemaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eventTitleLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(priceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventTimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(rightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cinemaLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(timeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eventTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eventTimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(rightBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        current.removeCurrentEvent(); //Clears currentEvent[] variable in Current class

        if (currentForm.equals("Event Info")) { //If form being used to view events details
            //(previous form was EventSearchUI)...
            current.setCurrentForm("Search For Event"); //Sets currentForm variable in Current class to "Search For Event"

            eventInfoClock.stopClock();
            EventSearchUI eventSearchForm = new EventSearchUI(); //New EventSearchUI object created
            eventSearchForm.setVisible(true);
            dispose(); //Current form disposed of
        }

        if (currentForm.equals("Closest Event Info")) { //If form being used to view one of the 3 closest events
            //details (previous form was MainMenuUI)...
            current.setCurrentForm("Main Menu"); //Sets currentForm variable in Current class to "Main Menu"

            eventInfoClock.stopClock();
            MainMenuUI mainMenuForm = new MainMenuUI(); //New MainMenuUI object created
            mainMenuForm.setVisible(true);
            dispose(); //Current form disposed of
        }
    }//GEN-LAST:event_backBtnActionPerformed

    private void rightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBtnActionPerformed
        if (loa.equals("customer")) { //If current user is a customer...

            String userID = current.getCurrentUserID(); //Stores current users primary key
            String eventID = current.getCurrentEventID(); //Stores current events primary key

            //Stores whether or not the user has the current event in their basket already
            boolean bookingExistsBasket = search.bookingFileSearch("basket.txt", userID, eventID);
            //Stores whether or not the user has a finalized booking for the current event already
            boolean bookingExistsFile;

            String currentDate; //Stores current date
            int age; //Stores current users age
            int ageRating; //Stores age rating of current event

            int numberItems; //Stores number of items user current has in basket

            Search search = new Search(); //New Search object created

            if (bookingExistsBasket == true) { //If user has current event in their basket...
                JOptionPane.showMessageDialog(null, "This event is already in your basket.", "Event Already In Basket!", JOptionPane.ERROR_MESSAGE);

            } else { //If user does not have current event in their basket...
                bookingExistsFile = search.bookingFileSearch("bookings.txt", userID, eventID);

                if (bookingExistsFile == true) { //If user has finalized booking for current event...
                    JOptionPane.showMessageDialog(null, "You have already booked for this event.", "Event Already Booked!", JOptionPane.ERROR_MESSAGE);

                } else { //If user does not have finalized booking for current event...
                    currentDate = current.getCurrentDate();
                    age = current.ageCalc(currentDate);
                    ageRating = current.getCurrentEventRating();

                    if (age >= ageRating) { //If user is old enough to book for event...
                        numberItems = search.countBasketItems(userID);

                        if (numberItems < 3) { //If user has less than 3 items in their basket...
                            current.setCurrentForm("Booking View 1"); //currentForm variable in Current class set to "Booking View 1"

                            eventInfoClock.stopClock();
                            EventBookingUI bookingForm1 = new EventBookingUI(); //New EventBookingUI object created
                            bookingForm1.setVisible(true);
                            dispose(); //Current form disposed of

                        } else { //If user has 3 items in their basket...
                            JOptionPane.showMessageDialog(null, "Your basket is full!", "Basket Full!", JOptionPane.ERROR_MESSAGE);
                        }

                    } else { //If user too young to book for event...
                        JOptionPane.showMessageDialog(null, "Sorry, you are too young to book for this event.", "Cannot Book", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        //If current user is a worker or manager...
        if (loa.equals("worker") || loa.equals("manager")) {
            current.setCurrentForm("Customer Bookings"); //currentForm variable in Current class set to "Customer Bookings"

            eventInfoClock.stopClock();
            CustomerBookingsUI customerBookingsForm = new CustomerBookingsUI(); //New CustomerBookingsUI object created
            customerBookingsForm.setVisible(true);
            dispose(); //Current form disposed of
        }
    }//GEN-LAST:event_rightBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        current.setCurrentForm("Edit Event"); //currentForm variable in Current class set to "Edit Event"

        eventInfoClock.stopClock();
        AddEventUI editEventForm = new AddEventUI(); //New AddEventUI object created
        editEventForm.setVisible(true);
        dispose(); //Current form disposed of
    }//GEN-LAST:event_editBtnActionPerformed

    /**
     * Sets form features depending on current users level of access
     */
    public void setFeatures() {
        //If user is a customer or worker...
        if (loa.equals("customer") || loa.equals("worker")) {
            editBtn.setEnabled(false);
            editBtn.setVisible(false);
        }
        //If user is a worker or manager...
        if (loa.equals("worker") || loa.equals("manager")) {
            rightBtn.setText("View Bookings");
        }
    }

    /**
     * Displays a certain events details to the form from the currentEvent[]
     * array
     */
    public void setEvent() {
        //Stores ticket price as a float
        float price = Float.parseFloat(currentEvent[6]);
        String outputPrice = ""; //Stores ticket price as a String

        //If user is a customer, currency may be different...
        String currencySymbol = "£"; //Stores symbol of currency chosen by user
        int index; //Stores index of users chosen index

        eventTitleLbl.setText(currentEvent[1] + " - " + currentEvent[3]);
        typeLbl.setText(currentEvent[2]);
        dateLbl.setText(currentEvent[4]);
        eventTimeLbl.setText(currentEvent[5]);

        //If user is a customer (given ability to change currencys)...
        if (loa.equals("customer")) {
            index = currency.getCurrencyIndex();

            if (index == 1) {
                price = currency.poundToDollar(price);
                currencySymbol = "$";
            }
            if (index == 2) {
                price = currency.poundToEuro(price);
                currencySymbol = "€";
            }

            //Formats ticket price after currency conversion and displays to JLabel
            outputPrice = currency.formatConversion(String.valueOf(price));
            priceLbl.setText(currencySymbol + outputPrice + " per ticket");

        } else { //If user is a worker or manager...
            //Formats ticket price and displays to JLabel
            outputPrice = currency.formatConversion(String.valueOf(price));
            priceLbl.setText("£" + outputPrice + " per ticket");
        }

        descriptionLbl.setText(currentEvent[7]);
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
            java.util.logging.Logger.getLogger(EventInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventInfoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cinemaLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel eventTimeLbl;
    private javax.swing.JLabel eventTitleLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JButton rightBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables
}
