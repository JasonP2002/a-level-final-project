package CinemaInc;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class EventSearchUI extends javax.swing.JFrame { //EventSearchUI class initializes and stores all methods related to
                                                       //the Search For Event Form

    //New Clock, Currency, Current, Search and Sort objects created
    Clock searchClock = new Clock();
    Currency currency = new Currency();
    Current current = new Current();
    Search search = new Search();
    Sort sort = new Sort();

    String loa = current.getLoa(); //Stores current users level of access
    
    int numRecords = search.countRecords("events.txt"); //Stores number of records currently in events file
    String[][] allEvents = search.getAllEvents(numRecords); //Stores all event records as a 2D array
    String[][] eventsArray; //Stores event details to be displayed to table as 2D array
    int order = 0; //Stores index of current table sort

    /**
     * Constructor method for EventSearchUI class
     *
     * Creates new form EventSearchUI
     * Sets form features depending on current users level of access 
     * Starts clock 
     * Displays event details to table
     */
    public EventSearchUI() {
        initComponents();

        setLocationRelativeTo(null);

        setFeatures();

        searchClock.setLabel(timeLbl);
        searchClock.setFrame(this);
        searchClock.start();

        eventsForTable(allEvents, numRecords);
        eventsIntoTable(eventsArray);
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
        eventTitleLbl = new javax.swing.JLabel();
        eventTypeLbl = new javax.swing.JLabel();
        eventTitleTxt = new javax.swing.JTextField();
        eventDateTxt = new javax.swing.JTextField();
        eventDateLbl = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        eventTypeTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        orderBox = new javax.swing.JComboBox<>();
        orderLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cinemaLbl.setFont(new java.awt.Font("Tahoma", 3, 60)); // NOI18N
        cinemaLbl.setText("Cinema Inc.");

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Search For Event");

        timeLbl.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        timeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeLbl.setText("00:00");

        eventTitleLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eventTitleLbl.setText("Event Title: ");

        eventTypeLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eventTypeLbl.setText("Event Type:");

        eventTitleTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        eventDateTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        eventDateLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eventDateLbl.setText("Event Date: ");

        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        eventTypeTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        eventsTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eventsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Title", "Event Type", "Event Date ", "Event Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eventsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(eventsTable);
        if (eventsTable.getColumnModel().getColumnCount() > 0) {
            eventsTable.getColumnModel().getColumn(0).setResizable(false);
            eventsTable.getColumnModel().getColumn(1).setResizable(false);
            eventsTable.getColumnModel().getColumn(2).setResizable(false);
            eventsTable.getColumnModel().getColumn(3).setResizable(false);
        }

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backBtn.setText("To Main Menu");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        viewBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewBtn.setText("View Event");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addBtn.setText("Add New Event");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        orderBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        orderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending Date", "Alphabetical" }));
        orderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBoxActionPerformed(evt);
            }
        });

        orderLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        orderLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        orderLbl.setText("Order:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cinemaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(eventTitleLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eventDateLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eventTypeLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(eventTypeTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                        .addComponent(eventTitleTxt, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eventDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(orderLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(orderBox, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cinemaLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eventTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventTitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eventTypeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderBox)
                    .addComponent(orderLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        current.setCurrentForm("Add An Event"); //Sets currentForm in Current class to "Add An Event"

        searchClock.stopClock();
        AddEventUI addEventForm = new AddEventUI(); //Creates new AddEventUI object
        addEventForm.setVisible(true);
        dispose(); //Current form disposed of
    }//GEN-LAST:event_addBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        current.setCurrentForm("Main Menu"); //Sets currentForm in Current class to "Main Menu"

        searchClock.stopClock();
        MainMenuUI mainMenuForm = new MainMenuUI(); //Creates new MainMenuUI object
        mainMenuForm.setVisible(true);
        dispose(); //Current form disposed of
    }//GEN-LAST:event_backBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        int selectedRow = eventsTable.getSelectedRow(); //Stores table row of selected event
        String searchEventID; //Stores primary key of selected event
        String event[]; //Stores selected events details as an array

        if (selectedRow != -1) { //If event has been selected...
            searchEventID = eventsArray[selectedRow][4];

            event = search.eventBinarySearch(searchEventID, numRecords);

            if (event[0] != null) { //If event found...
                current.setCurrentEvent(event); //Sets currentEvent[] in Current class to event[]

                current.setCurrentForm("Event Info"); //Sets currentForm in Current class to "Event Info"

                searchClock.stopClock();
                EventInfoUI eventInfoForm = new EventInfoUI(); //New EventInfoUI object created
                eventInfoForm.setVisible(true);
                dispose(); //Current form disposed of
            }
        } else { //If event has not been selected...
            JOptionPane.showMessageDialog(null, "Please Select an Event to view.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        //Stores search criteria inputs
        String searchTitle = eventTitleTxt.getText();
        String searchType = eventTypeTxt.getText();
        String searchDate = eventDateTxt.getText();

        if ((searchTitle.equals("")) && (searchType.equals("")) && (searchDate.equals(""))) { //If all search criteria text fields empty...
            JOptionPane.showMessageDialog(null, "Please enter search criteria.", "Search Error", JOptionPane.ERROR_MESSAGE);

        } else { //If search criteria present...
            //Stores all event records that match search criteria as a 2D array
            //(Contains max number of rows possible in case all records meet search criteria)
            String foundEvents[][] = new String[numRecords][8];
            String currentLine; //Stores current line being read from file
            String currentEvent[] = new String[8]; //Stores current line as an array
            int currentRow = 0; //Stores number of event records stored in foundEvents[][] array

            boolean eventFound; //Stores whether current event meets search criteria or not
            boolean anyEventFound = false; //Stores whether or not any event matching the search criteria has been found

            DefaultTableModel eventsModel = (DefaultTableModel) eventsTable.getModel(); //New DefaultTableModel created for eventsTable

            try {
                eventsModel.setRowCount(0); //Events table cleared

                FileReader fileReader = new FileReader("events.txt"); //New FileReader object created for "events.txt"
                BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

                while ((currentLine = bufferReader.readLine()) != null) {
                    currentEvent = currentLine.split(","); //Current line split into an array
                    eventFound = true;

                    if (!(searchTitle.equals(""))) { //If search criteria title was entered...
                        if (!(currentEvent[1].equalsIgnoreCase(searchTitle))) { //If current events title does not match search criteria title...
                            eventFound = false;
                        }
                    }

                    if (!(searchType.equals(""))) { //If search criteria type was entered...
                        if (!(currentEvent[2].equalsIgnoreCase(searchType))) { //If current events type does not match search criteria type...
                            eventFound = false;
                        }
                    }

                    if (!(searchDate.equals(""))) { //If search criteria date was entered...
                        if (!(currentEvent[4].equals(searchDate))) { //If current events date does not match search criteria date...
                            eventFound = false;
                        }
                    }

                    if (eventFound == true) { //If event matches all entered search criteria...
                        foundEvents[currentRow] = currentEvent;

                        currentRow = currentRow + 1; //One more event meets search criteria
                        anyEventFound = true;
                        eventFound = false;
                    }
                }

                fileReader.close();
                bufferReader.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Something went wrong" + ex);
            }

            if (anyEventFound == true) {
                //Events that match search criteria shown on table
                eventsForTable(foundEvents, currentRow);
                eventsIntoTable(eventsArray);
            } else { //If no events matching search criteria found...
                JOptionPane.showMessageDialog(null, "Sorry, we could not find any events.", "No Events Found", JOptionPane.ERROR_MESSAGE);
            }

            //Search criteria text fields cleared
            eventTitleTxt.setText("");
            eventTypeTxt.setText("");
            eventDateTxt.setText("");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void orderBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBoxActionPerformed
        //New DefaultTableModel created for eventsTable
        DefaultTableModel eventsModel = (DefaultTableModel) eventsTable.getModel();
        order = orderBox.getSelectedIndex();

        //Events sorted into new order and shown to table
        eventsForTable(allEvents, numRecords);
        eventsModel.setRowCount(0); //Events table cleared
        eventsIntoTable(eventsArray);
    }//GEN-LAST:event_orderBoxActionPerformed

    /**
     * Sets form features depending on current users level of access
     */
    public void setFeatures() {
        //If current user is either a customer or a worker...
        if (loa.equals("customer") || loa.equals("worker")) {
            addBtn.setVisible(false);
            addBtn.setEnabled(false);
        }
    }

    /**
     * Takes a 2D array of events and stores details to be displayed
     * to the events table in eventsArray[], sorted depending on 
     * the users chosen sort
     *
     * @param allEvents 2D array of events to be displayed to table
     * @param numberEvents number of event records stored in allEvents[][]
     */
    public void eventsForTable(String[][] allEvents, int numberEvents) {
        //Stores event details to be displayed to the table in a 2D array
        String[][] tableEvents = new String[numberEvents][5];

        String currencySymbol = "??"; //Stores currency symbol to be shown on the tables ticket prices
        int currencyIndex = currency.getCurrencyIndex(); //Stores index of currency user has selected
        float amount = 0; //Stores current events ticket price in users selected currency

        //Sets currency symbol depending on index of users chosen currency
        if (currencyIndex == 1) {
            currencySymbol = "$";
        }
        if (currencyIndex == 2) {
            currencySymbol = "???";
        }

        for (int i = 0; i < numberEvents; i++) { //While more event records...
            tableEvents[i][0] = allEvents[i][1];
            tableEvents[i][1] = allEvents[i][2];
            tableEvents[i][2] = allEvents[i][4];

            amount = Float.parseFloat(allEvents[i][6]);
            //Converts an events ticket price to the users chosen currency
            if (currencyIndex == 1) {
                amount = currency.poundToDollar(amount);
            }
            if (currencyIndex == 2) {
                amount = currency.poundToEuro(amount);
            }

            tableEvents[i][3] = currencySymbol + currency.formatConversion(String.valueOf(amount));
            tableEvents[i][4] = allEvents[i][0];

            amount = 0; //Ticket price reset
        }

        //Sorts tableEvents[][] array depending on index of users chosen sort
        if (order == 0) {
            tableEvents = sort.eventsToAscendingOrder(tableEvents, numberEvents, 5, 2);
        }
        if (order == 1) {
            tableEvents = sort.eventsToAlphabeticalOrder(tableEvents, 0, numberEvents - 1);
        }

        this.eventsArray = tableEvents;
    }

    /**
     * Displays a 2D array of event details to the events table
     * 
     * @param eventsArray 2D array of event details
     */
    public void eventsIntoTable(String[][] eventsArray) {
        //New DefaultTableModel created for eventsTable
        DefaultTableModel eventsModel = (DefaultTableModel) eventsTable.getModel();
        String row[] = new String[4]; //Stores current row to be added to table

        for (int currentrow = 0; currentrow < eventsArray.length; currentrow++) { //While more events...

            for (int currentcolumn = 0; currentcolumn < 4; currentcolumn++) { //While more event details...

                row[currentcolumn] = eventsArray[currentrow][currentcolumn];
            }
            
            eventsModel.addRow(row); //Event added to table
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
            java.util.logging.Logger.getLogger(EventSearchUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventSearchUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventSearchUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventSearchUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventSearchUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cinemaLbl;
    private javax.swing.JLabel eventDateLbl;
    private javax.swing.JTextField eventDateTxt;
    private javax.swing.JLabel eventTitleLbl;
    private javax.swing.JTextField eventTitleTxt;
    private javax.swing.JLabel eventTypeLbl;
    private javax.swing.JTextField eventTypeTxt;
    private javax.swing.JTable eventsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> orderBox;
    private javax.swing.JLabel orderLbl;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
