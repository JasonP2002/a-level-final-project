package CinemaInc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
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
public class FileHandling { //Class contains all methods for handling records in files (adding, editing, deleting, generating primary keys)
    
    /**
     * Constructor method for FileHandling class
     */
    public FileHandling() {

    }
    
    /**
     * Generates a records primary key
     *
     * @param recordType record type of record
     * @return String of generated primary key for record
     */
    public static String generatePK(String recordType) {
        String id; //Stores generated primary key for record
        int number = 0; //Stores number section of primary key
        
        while ((String.valueOf(number)).length() != 6) { //While random number generated isnt of length 6...
            number = 0 + new Random().nextInt(900000);
        }
        
        id = recordType + String.valueOf(number);
        return id;
    }

    /**
     * Appends a record to a file
     *
     * @param record record to be added to the file
     * @param file file being written to
     * @return boolean stating whether record was added successfully or not
     */
    public static boolean addRecord(String record, String file) {
        boolean addSuccess = false; //Stores whether record was added successfully or not

        try {
            FileWriter fileWriter = new FileWriter(file, true); //New FileWriter object created for file
            fileWriter.write(record + "\n"); //Writes record and starts new line in file
            fileWriter.close();

            addSuccess = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
            JOptionPane.showMessageDialog(null, "Could not be created.", "Error", JOptionPane.ERROR_MESSAGE);

            addSuccess = false;
            return addSuccess;
        }

        return addSuccess;
    }

    /**
     * Edits a certain record in a file
     *
     * @param editPrimaryKey primary key of record to be edited
     * @param editedRecord edited record to replace old version of record
     * @param recordLength length of record being edited
     * @param file file being read from
     * @return boolean stating whether record was successfully edited or not
     */
    public static boolean editRecord(String editPrimaryKey, String editedRecord, int recordLength, String file) {
        boolean editSuccess = false; //Stores whether record was successfully edited or not
        String tempFile = "temp.txt"; //Temporary name of new file to be written to

        File oldFile = new File(file); //New File object created for old file
        File newFile = new File(tempFile); //New File object created for new file

        String currentLine; //Stores current line of file
        String[] currentRecord = new String[recordLength]; //Stores current record of file as an array
        String currentPrimaryKey; //Stores primary key of current record

        boolean delete; //Catches boolean returned from the File class .delete() method
        boolean rename; //Catches boolean returned from the File class .renameTo() method

        try {
            FileReader fileReader = new FileReader(file); //New FileReader object created for old file
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader
            FileWriter fileWriter = new FileWriter(tempFile, true); //New FileWriter object created for new file

            while (((currentLine = bufferReader.readLine()) != null)) {
                currentRecord = currentLine.split(","); //Current record split into an array
                currentPrimaryKey = currentRecord[0];

                if (currentPrimaryKey.equals(editPrimaryKey)) { //If current pk = pk of record to be edited...
                    fileWriter.write(editedRecord + "\n"); //Write edited record to new file
                    editSuccess = true;
                } else {
                    fileWriter.write(currentLine + "\n"); //Write current record to new file
                }
            }

            fileReader.close();
            bufferReader.close();
            fileWriter.close();
            System.gc();

            delete = oldFile.delete();
            rename = newFile.renameTo(oldFile);

            return editSuccess;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
            JOptionPane.showMessageDialog(null, "Could not be edited.", "Error", JOptionPane.ERROR_MESSAGE);

            return editSuccess;
        }
    }

    /**
     * Deletes a certain record from a file
     *
     * @param deletePrimaryKey primary key of record to be deleted
     * @param recordLength length of record being deleted
     * @param file file to be read from
     * @return boolean stating whether record was successfully deleted or not
     */
    public static boolean deleteRecord(String deletePrimaryKey, int recordLength, String file) {
        boolean deleteSuccess = false; //Stores whether record was succesfully deleted or not
        String tempFile = "temp.txt"; //Temporary name of new file to be written to

        File oldFile = new File(file); //New File object created for old file
        File newFile = new File(tempFile); //New File object created for new file

        String currentLine; //Stores current line of file
        String[] currentRecord = new String[recordLength]; //Stores current record of file as an array
        String currentPrimaryKey; //Stores primary key of current record

        boolean delete; //Catches boolean returned from the File class .delete() method
        boolean rename; //Catches boolean returned from the File class .renameTo() method

        try {
            FileReader fileReader = new FileReader(file); //New FileReader object created for old file
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader
            FileWriter fileWriter = new FileWriter(tempFile, true); //New FileWriter object created for new file

            while ((currentLine = bufferReader.readLine()) != null) {
                currentRecord = currentLine.split(","); //Current record split into an array
                currentPrimaryKey = currentRecord[0];

                if (!currentPrimaryKey.equals(deletePrimaryKey)) { //If current pk is not equal to pk of record to be deleted...
                    fileWriter.write(currentLine + "\n"); //Write current record to new file
                }
            }

            fileReader.close();
            bufferReader.close();
            fileWriter.close();
            System.gc();

            delete = oldFile.delete();
            rename = newFile.renameTo(oldFile);

            deleteSuccess = true;
            return deleteSuccess;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
            JOptionPane.showMessageDialog(null, "Could not be deleted.", "Error", JOptionPane.ERROR_MESSAGE);

            return deleteSuccess;
        }
    }
    
    /**
     * Adds a specific users basket items to the bookings file
     * 
     * @param basketItems 2D array of basket item records to be added to bookings file
     */
    public static void finalizeBookings(String[][] basketItems) {
        String[] currentRow = new String[6]; //Stores current row/record of 2D array to be added to file
        String currentItem; //Stores current record as a comma seperated String

        try {
            FileWriter fileWriter = new FileWriter("bookings.txt", true); //New FileWriter object created for bookings file

            for (int i = 0; i < basketItems.length; i++) { //While more records to add to file...
                currentRow = basketItems[i];
                currentItem = String.join(",", currentRow); //Current record joined by commas and stored as String
                fileWriter.write(currentItem + "\n");
            }

            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }
        
    }

    /**
     * Removes all of a specific users basket items from the basket file
     * 
     * @param bookingPK 1D array storing primary keys of all basket item records to be deleted from the file
     */
    public static void emptyBasket(String[] bookingPK) {
        String tempFile = "temp.txt"; //Temporary name of new file to be written to

        File oldFile = new File("basket.txt"); //New File object created for old file
        File newFile = new File(tempFile); //New File object created for new file

        String currentLine; //Stores current line of file
        String[] currentBasketItem = new String[6]; //Stores current line of file as an array
        String currentItemID; //Stores primary key of current record of file
        
        boolean write = true; //Stores whether current record should be written to new file or not
        boolean delete; //Catches boolean returned from the File class .delete() method
        boolean rename; //Catches boolean returned from the File class .renameTo() method

        try {
            FileReader fileReader = new FileReader("basket.txt"); //New FileReader object created for old file
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader
            FileWriter fileWriter = new FileWriter(tempFile, true); //New FileWriter object created for new file

            while ((currentLine = bufferReader.readLine()) != null) {
                currentBasketItem = currentLine.split(","); //Current record of file split into an array
                currentItemID = currentBasketItem[0];

                for (int i = 0; i < bookingPK.length; i++) { //While more pks of records to be deleted...
                    if (currentItemID.equals(bookingPK[i])) { //If current pk = pk of a record to be deleted
                        write = false;
                    }
                }
                
                if (write == true){
                    fileWriter.write(currentLine + "\n");
                }
                
                write = true;
            }
            fileReader.close();
            bufferReader.close();
            fileWriter.close();
            System.gc();

            delete = oldFile.delete();
            rename = newFile.renameTo(oldFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }
        
    }

    /**
     * Deletes records in basket file with seat selections clashing
     * with those of a newly finalized set of bookings
     * 
     * @param finalBookings 2D array of newly finalized set of bookings
     * @param numberItems number of newly finalized bookings
     */
    public static void removeBasketClashes(String[][] finalBookings, int numberItems) {
        String tempFile = "temp.txt"; //Temporary name of new file to be written to
        
        File oldFile = new File("basket.txt"); //File object created for old file
        File newFile = new File(tempFile); //File object created for new file

        String currentLine; //Stores current line of file
        String[] currentRecord = new String[6]; //Stores current record in file as a String
        String currentEventID; //Stores primary key of current record

        String[] finalBookingSeats; //Stores seats of current finalized booking
        String[] currentRecordSeats; //Stores seats of current record
        String currentSeat; //Stores a single seat of currentRecordSeats

        boolean match = false; //Stores whether event of current record matches event of current finalized booking
        boolean clash = false; //Stores whether seat in current record matches a seat in a finalized booking of the same event
        
        boolean delete; //Catches boolean returned from the File class .delete() method
        boolean rename; //Catches boolean returned from the File class .renameTo() method

        try {
            FileReader fileReader = new FileReader("basket.txt"); //New FileReader object created for old file
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader
            FileWriter fileWriter = new FileWriter(tempFile, true); //New FileWriter object created for new file

            while ((currentLine = bufferReader.readLine()) != null) {
                currentRecord = currentLine.split(","); //Current record of file stored as an array
                currentEventID = currentRecord[2];

                for (int i = 0; i < numberItems; i++) { //While more basket items...
                    
                    if (currentEventID.equals(finalBookings[i][2])) { //If event of current record matches event of finalized booking...
                        //Seats stored as arrays
                        finalBookingSeats = finalBookings[i][4].split("-");
                        currentRecordSeats = currentRecord[4].split("-");
 
                        for (int recordSeat = 0; recordSeat < currentRecordSeats.length; recordSeat++) { //While more current record seats...
                            currentSeat = currentRecordSeats[recordSeat];

                            for (int finalSeat = 0; finalSeat < finalBookingSeats.length; finalSeat++) { //While more finalized booking seats...

                                if (currentSeat.equals(finalBookingSeats[finalSeat])) {
                                    clash = true;
                                }
                                
                            }

                        }
                        
                    }

                }

                if (clash == false) { //If no clashes between seats in current record and finalized bookings...
                    fileWriter.write(currentLine + "\n"); //Current record and new line written to file
                }
                
                clash = false;
            }
            fileReader.close();
            bufferReader.close();
            fileWriter.close();
            System.gc();

            delete = oldFile.delete();
            rename = newFile.renameTo(oldFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }
        
    }

}
