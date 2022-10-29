package CinemaInc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class Sort { //Class contains all sort algorithms
    
    /**
     * Constructor method for the Sort class
     */
    public Sort(){
        
    }

    /**
     * Compares two primary keys to see whether two records require swapping
     * 
     * @param currentPrimaryKey the primary key at the sorts current position
     * @param nextPrimaryKey the primary key at the position one up from the sorts current position
     * @return boolean stating whether records require swapping or not
     */
    public boolean comparePK(String currentPrimaryKey, String nextPrimaryKey) {
        //Primary keys split into arrays
        String[] currentPKArray = currentPrimaryKey.split("");
        String[] nextPKArray = nextPrimaryKey.split("");

        //Stores first character of primary key, which determines record type
        char currentPKType = currentPrimaryKey.charAt(0);
        char nextPKType = nextPrimaryKey.charAt(0);
        
        //Stores last 6 digits of primary keys
        int currentPKNum = Integer.parseInt(currentPKArray[3] + currentPKArray[4] + currentPKArray[5] + currentPKArray[6] + currentPKArray[7] + currentPKArray[8]);
        int nextPKNum = Integer.parseInt(nextPKArray[3] + nextPKArray[4] + nextPKArray[5] + nextPKArray[6] + nextPKArray[7] + nextPKArray[8]); 

        boolean swap = false; //Stores whether records require swapping or not

        if (currentPKType > nextPKType) {
            swap = true;
        } else {
            if (currentPKType == nextPKType) {
                if (currentPKNum > nextPKNum) {
                    swap = true;
                }
            }
        }

        return swap;
    }

    /**
     * Collects the contents of a file into a 2D array
     * Sorts the 2D array into ascending order of primary key
     * Writes the 2D array to a new file
     * 
     * @param file the file that requires sorting
     * @param recordLength the length of the records inside the file
     * @param numberRecords the number of records stored in the file
     */
    public void bubbleSort(String file, int recordLength, int numberRecords) {
        String currentLine; //Stores current line of file
        String[] currentRecord = new String[recordLength]; //Stores current record of file
        String[][] recordArray = new String[numberRecords][recordLength]; //Stores all file records
        int i = 0;

        boolean flag = false;
        boolean swap; //Stores whether records require swapping or not
        String currentPrimaryKey;
        String nextPrimaryKey;
        String[] tempRecord = new String[recordLength];

        String tempfile = "temp.txt"; //Temporary file to be written to
        String record;
        File oldFile = new File(file); //New File object created for old file
        File newFile = new File(tempfile); //New File object created for new file
        boolean delete; //Catches boolean returned from the File class .delete() method
        boolean rename; //Catches boolean returned from the File class .renameTo() method

        try {
            FileReader fileReader = new FileReader(file); //New FileReader object created for file
            BufferedReader bufferReader = new BufferedReader(fileReader); //New BufferedReader object created for fileReader

            while ((currentLine = bufferReader.readLine()) != null) {
                currentRecord = currentLine.split(","); //Current line of file split into array

                //All currentRecord data moved into recordArray
                for (int column = 0; column < recordLength; column++) {
                    recordArray[i][column] = currentRecord[column];
                }
                i = i + 1;

            }
            fileReader.close();
            bufferReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        while (flag == false) {
            flag = true;

            for (int j = 0; j < numberRecords - 1; j++) {
                currentPrimaryKey = recordArray[j][0];
                nextPrimaryKey = recordArray[j + 1][0];

                swap = comparePK(currentPrimaryKey, nextPrimaryKey); //Primary keys compared

                if (swap == true) {
                    //Records swapped
                    tempRecord = recordArray[j + 1];
                    recordArray[j + 1] = recordArray[j];
                    recordArray[j] = tempRecord;
                    flag = false;
                }
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(tempfile, true); //New FileWriter object created for tempfile

            for (int recordNumber = 0; recordNumber < numberRecords; recordNumber++) {
                //Current records data joined and written to file
                record = String.join(",", recordArray[recordNumber]);
                fileWriter.write(record + "\n");
            }

            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong" + ex);
        }

        delete = oldFile.delete(); 
        rename = newFile.renameTo(oldFile);
    }

    /**
     * Sorts 2D array of event records into ascending order of event date
     * 
     * @param eventsArray 2D array containing all event records
     * @param numberOfEvents number of event records in eventsArray
     * @param recordLength length of event records being sorted
     * @param datePosition position of date in event record
     * @return 2D array of event records sorted into ascending order of event date
     */
    public String[][] eventsToAscendingOrder(String[][] eventsArray, int numberOfEvents, int recordLength, int datePosition) {
        Boolean flag = false;
        String temp[] = new String[recordLength]; //Stores event record being swapped temporarily

        String currentEventDate[] = new String[10];
        int currentEventYear;
        int currentEventMonth;
        int currentEventDay;

        String nextEventDate[] = new String[10];
        int nextEventYear;
        int nextEventMonth;
        int nextEventDay;

        while (flag == false) {
            flag = true;

            for (int i = 0; i < numberOfEvents - 1; i++) {
                //Event dates split into arrays
                currentEventDate = eventsArray[i][datePosition].split("");
                nextEventDate = eventsArray[i + 1][datePosition].split("");

                //Event years constructed and converted to integer
                currentEventYear = Integer.parseInt(currentEventDate[6] + currentEventDate[7] + currentEventDate[8] + currentEventDate[9]);
                nextEventYear = Integer.parseInt(nextEventDate[6] + nextEventDate[7] + nextEventDate[8] + nextEventDate[9]);

                if (currentEventYear > nextEventYear) {
                    //Swap event records
                    temp = eventsArray[i + 1];
                    eventsArray[i + 1] = eventsArray[i];
                    eventsArray[i] = temp;
                    flag = false;
                } else {
                    
                    //Event months constructed and converted to integer
                    currentEventMonth = Integer.parseInt(currentEventDate[3] + currentEventDate[4]);
                    nextEventMonth = Integer.parseInt(nextEventDate[3] + nextEventDate[4]);

                    if ((currentEventYear == nextEventYear) && (currentEventMonth > nextEventMonth)) {
                        //Swap event records
                        temp = eventsArray[i + 1];
                        eventsArray[i + 1] = eventsArray[i];
                        eventsArray[i] = temp;
                        flag = false;
                    } else {

                        //Event days constructed and converted to integer
                        currentEventDay = Integer.parseInt(currentEventDate[0] + currentEventDate[1]);
                        nextEventDay = Integer.parseInt(nextEventDate[0] + nextEventDate[1]);

                        if ((currentEventYear == nextEventYear) && (currentEventMonth == nextEventMonth) && (currentEventDay > nextEventDay)) {
                            //Swap event records
                            temp = eventsArray[i + 1];
                            eventsArray[i + 1] = eventsArray[i];
                            eventsArray[i] = temp;
                            flag = false;
                        }
                    }
                }

            }
        }

        return eventsArray;
    }

    /**
     * Recursively sorts 2D array of event records into alphabetical order of event title
     * 
     * @param eventsArray 2D array containing all event records
     * @param first position of first event record being sorted
     * @param last position of last event record being sorted
     * @return 2D array of event records sorted into alphabetical order of event title
     */
    public String[][] eventsToAlphabeticalOrder(String[][] eventsArray, int first, int last) {
        int left = first;
        int right = last;
        int pivot = (left + right) / 2;

        String leftTitle = eventsArray[left][0];
        String rightTitle = eventsArray[right][0];
        String pivotTitle = eventsArray[pivot][0];

        String[] tempEvent = new String[5]; //Stores event record being swapped temporarily
        String tempTitle;

        while (left <= right) {
            while ((leftTitle.compareToIgnoreCase(pivotTitle)) < 0) { //While leftTitle < pivotTitle
                left = left + 1;
                leftTitle = eventsArray[left][0];
            }

            while ((rightTitle.compareToIgnoreCase(pivotTitle)) > 0) { //While rightTitle > pivotTitle
                right = right - 1;
                rightTitle = eventsArray[right][0];
            }

            if (left <= right) {
                //Swap event records
                tempEvent = eventsArray[left];
                eventsArray[left] = eventsArray[right];
                eventsArray[right] = tempEvent;
                
                //Swap event titles
                tempTitle = leftTitle;
                leftTitle = rightTitle;
                rightTitle = tempTitle;

                left = left + 1;
                right = right - 1;
            }
        }

        if (first < right) {
            //Recursive call
            eventsToAlphabeticalOrder(eventsArray, first, left - 1);
        }

        if (left < last) {
            //Recursive call
            eventsToAlphabeticalOrder(eventsArray, right + 1, last);
        }

        return eventsArray;
    }

}
