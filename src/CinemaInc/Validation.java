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
public class Validation { //Class contains all validation algorithms

    /**
     * Constructor method for the Validation class
     */
    public Validation() {

    }

    /**
     * Checks if a user has entered an input or not
     *
     * @param input users input
     * @return boolean stating whether input is present or not
     */
    public static boolean presenceCheck(String input) {
        boolean valid; //Indicates whether input is present(valid) or not

        if (input.matches("")) {
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    /**
     * Checks if an entered input is of a certain length
     *
     * @param input users input
     * @param length required length for input
     * @return boolean stating whether input is of required length or not
     */
    public static boolean lengthCheck(String input, int length) {
        boolean valid; //Indicates whether input is of required length(valid) or not

        if (input.length() != length) {
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    /**
     * Checks if a users input is above/equal to a certain minimum length
     *
     * @param input users input
     * @param minLength minimum length for input
     * @return boolean stating whether input is above/equal to the minimum
     * length or not
     */
    public static boolean aboveLengthCheck(String input, int minLength) {
        boolean valid; //Indicates whether input is above/equal to minimum length(valid) or not

        if (input.length() >= minLength) {
            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

    /**
     * Checks if a users input is below/equal to a certain maximum length
     *
     * @param input users input
     * @param maxLength maximum length for input
     * @return boolean stating whether input is below/equal to the maximum
     * length or not
     */
    public static boolean belowLengthCheck(String input, int maxLength) {
        boolean valid; //Indicates whether input is below/equal to maximum length(valid) or not

        if (input.length() <= maxLength) {
            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

    /**
     * Checks if a users inputted telephone number is in the correct format
     *
     * @param telephone users telephone number input
     * @return boolean stating whether input is in correct format or not
     */
    public static boolean telephoneFormatCheck(String telephone) {
        boolean valid = true; //Stores whether telephone input is in correct format or not
        String[] telephoneArray = new String[11]; //Stores telephone input as array

        //Checks input is of correct length
        if (telephone.length() != 11) {
            valid = false;
            return valid;
        }

        telephoneArray = telephone.split("");

        //Checks input characters are of correct data type
        for (int i = 0; i < 11; i++) {
            try {
                Integer.parseInt(telephoneArray[i]);
            } catch (Exception ex) {
                valid = false;
                return valid;
            }
        }

        return valid;
    }

    /**
     * Checks if a users inputted postcode is in the correct format
     *
     * @param inputPostcode users postcode input
     * @return boolean stating whether input is in correct format or not
     */
    public static boolean postcodeFormatCheck(String inputPostcode) {
        boolean valid = true; //Indicates whether postcode is in correct format(valid) or not

        int postcodeLength = inputPostcode.length(); //Stores length of postcode input

        //Checks input is the correct length
        if (postcodeLength < 6 || postcodeLength > 8) {
            valid = false;
            return valid;
        }

        String[] postcodeArray = inputPostcode.split(""); //Input split into array

        //Checks second half of input is correct (numeric, alpha, alpha format)
        for (int i = postcodeLength - 1; i > postcodeLength - 5; i--) {

            if (i == postcodeLength - 1 || i == postcodeLength - 2) {
                char letter = inputPostcode.charAt(i); //Stores a certain character of input
                
                if (!(letter >= 'A') || !(letter <= 'Z')) {
                    valid = false;
                    return valid;
                }
            }

            if (i == postcodeLength - 3) {
                try {
                    Integer.parseInt(postcodeArray[i]);
                } catch (Exception ex) {
                    valid = false;
                    return valid;
                }
            }

            //Checks for seperation in postcode
            if (i == postcodeLength - 4) {
                if (!(postcodeArray[i].equals(" "))) {
                    valid = false;
                    return valid;
                }
            }
            
        }
        return valid;
    }

    /**
     * Checks if a users inputted date is in the correct format (dd/mm/yyyy)
     * 
     * @param inputDate users date input
     * @return boolean stating whether input is in the correct format or not
     */
    public static boolean dateFormatCheck(String inputDate) {
        boolean valid = true; //Indicates whether date is in the correct format(valid) or not

        int inputDay;
        int inputMonth;
        int inputYear;

        int currentDay;
        int currentMonth;
        int currentYear;

        //Checks input is the correct length
        if (inputDate.length() != 10) {
            valid = false;
            return valid;
        }

        //Input is split into an array
        String[] inputDateArray = new String[10];
        inputDateArray = inputDate.split("");

        if (!(inputDateArray[2].equals("/")) || !(inputDateArray[5].equals("/"))) {
            valid = false;
            return valid;
        }

        //Checks input characters are of the correct data type
        for (int i = 0; i < 10; i++) {
            if ((i != 2) && (i != 5)) {

                try {
                    Integer.parseInt(inputDateArray[i]);
                } catch (Exception ex) {
                    valid = false;
                    return valid;
                }

            }
        }

        //Day, month and year inputs constructed and converted to integer
        inputDay = Integer.parseInt(inputDateArray[0] + inputDateArray[1]);
        inputMonth = Integer.parseInt(inputDateArray[3] + inputDateArray[4]);
        inputYear = Integer.parseInt(inputDateArray[6] + inputDateArray[7] + inputDateArray[8] + inputDateArray[9]);

        //Checks input numbers are in the correct range
        if (inputMonth < 1 || inputMonth > 12) {
            valid = false;
            return valid;
        }

        if ((inputMonth == 1) || (inputMonth == 3) || (inputMonth == 5) || (inputMonth == 7) || (inputMonth == 8) || (inputMonth == 10) || (inputMonth == 12)) {
            if ((inputDay > 31) || (inputDay < 1)) {
                valid = false;
                return valid;
            }
        }

        if ((inputMonth == 4) || (inputMonth == 6) || (inputMonth == 9) || (inputMonth == 11)) {
            if ((inputDay > 30) || (inputDay < 1)) {
                valid = false;
                return valid;
            }
        }

        //Leap year check
        if (inputMonth == 2) {
            if ((inputYear % 4) == 0) { //If leap year...
                
                if ((inputDay > 29) || (inputDay < 1)) {
                    valid = false;
                    return valid;
                }
                
            } else {
                
                if ((inputDay > 28) || (inputDay < 1)) {
                    valid = false;
                    return valid;
                }
            }
        }

        return valid;
    }

    /**
     * Checks if a users inputted date of birth is a valid date (in the past)
     * 
     * @param inputDate users date of birth input
     * @param currentDate the date of input
     * @return boolean stating whether inputted date of birth is in the past or not
     */
    public static boolean dobDateCheck(String inputDate, String currentDate) {
        boolean valid = true; //Stores whether inputted dob is in the past or not

        //Inputted dob split into array
        String[] dobDateArray = new String[10];
        dobDateArray = inputDate.split("");

        //Day, month and year inputs constructed and converted to integer
        int dobDay = Integer.parseInt(dobDateArray[0] + dobDateArray[1]);
        int dobMonth = Integer.parseInt(dobDateArray[3] + dobDateArray[4]);
        int dobYear = Integer.parseInt(dobDateArray[6] + dobDateArray[7] + dobDateArray[8] + dobDateArray[9]);

        //Current date split into array
        String[] currentDateArray = new String[10];
        currentDateArray = currentDate.split("");

        //Current day, month and year constructed and converted to integer
        int currentDay = Integer.parseInt(currentDateArray[0] + currentDateArray[1]);
        int currentMonth = Integer.parseInt(currentDateArray[3] + currentDateArray[4]);
        int currentYear = Integer.parseInt(currentDateArray[6] + currentDateArray[7] + currentDateArray[8] + currentDateArray[9]);

        if (dobYear > currentYear) {
            valid = false;
            return valid;
        }

        if (dobYear == currentYear) {
            
            if ((dobMonth > currentMonth)) {
                valid = false;
                return valid;
                
            } else {
                if ((dobMonth == currentMonth) && (dobDay > currentDay)) {
                    valid = false;
                    return valid;
                }
            }
        }

        return valid;
    }

    /**
     * Checks if a users inputted event date is a valid date (in the future)
     * 
     * @param inputDate users event date input
     * @param currentDate the date of input
     * @return boolean stating whether inputted event date is in the future or not
     */
    public static boolean eventDateCheck(String inputDate, String currentDate) {
        boolean valid = true; //Stores whether inputted event date is in the future or not

        //Inputted event date split into array
        String[] inputDateArray = new String[10];
        inputDateArray = inputDate.split("");

        //Day, month and year inputs constructed and converted to integer
        int inputDay = Integer.parseInt(inputDateArray[0] + inputDateArray[1]);
        int inputMonth = Integer.parseInt(inputDateArray[3] + inputDateArray[4]);
        int inputYear = Integer.parseInt(inputDateArray[6] + inputDateArray[7] + inputDateArray[8] + inputDateArray[9]);

        //Current date split into array
        String[] currentDateArray = new String[10];
        currentDateArray = currentDate.split("");

        //Current day, month and year constructed and converted to integer
        int currentDay = Integer.parseInt(currentDateArray[0] + currentDateArray[1]);
        int currentMonth = Integer.parseInt(currentDateArray[3] + currentDateArray[4]);
        int currentYear = Integer.parseInt(currentDateArray[6] + currentDateArray[7] + currentDateArray[8] + currentDateArray[9]);

        if (inputYear < currentYear) {
            valid = false;
            return valid;
        }

        if (inputYear == currentYear) {
            
            if ((inputMonth < currentMonth)) {
                valid = false;
                return valid;
                
            } else {
                if ((inputMonth == currentMonth) && (inputDay < currentDay)) {
                    valid = false;
                    return valid;
                }
            }
        }
        
        return valid;
    }

    /**
     * Checks if a users inputted time is in the correct format
     * 
     * @param inputTime users time input
     * @return boolean stating whether input is in correct format or not
     */
    public static boolean timeFormatCheck(String inputTime) {
        boolean valid = true; //Indicates whether input is in the correct format or not

        //Checks input is the correct length
        if (inputTime.length() != 5) {
            valid = false;
            return valid;
        }

        String[] timeArray = inputTime.split(""); //Stores input as an array

        //Checks each character of input is the correct data type
        for (int i = 0; i < 5; i++) {

            if (i != 2) {
                try {
                    Integer.parseInt(timeArray[i]);
                } catch (Exception ex) {
                    valid = false; 
                    return valid;
                }
            }

            if (i == 2) {
                if (!timeArray[i].equals(":")) {
                    valid = false;
                    return valid;
                }
            }
        }

        return valid;
    }

    /**
     * Checks if a users inputted ticket price is in the correct format
     * 
     * @param inputPrice users ticket price input
     * @return boolean stating whether input is in correct format or not
     */
    public static boolean priceFormatCheck(String inputPrice) {
        boolean valid = false; //Stores whether input is in correct format or not

        boolean point = false; //Stores whether input contains the "." character or not
        int decimalCount = 0; //Stores how many characters follow the "." character
        boolean allIntegers = true; //Stores whether all relevant characters are the integer
                                    //data type or not
                                    
        String[] price = inputPrice.split(""); //Stores input as an array

        for (int i = 0; i < price.length; i++) {

            if (point == true) { //If "." character has been passed...
                decimalCount = decimalCount + 1;
            }

            if ((point == false) && (price[i].equals("."))) { //If "." character is detected for the first time...
                point = true;
            }

            if ((point == false) || (decimalCount > 0)) { //If character is before/after the "." character...
                try {
                    Integer.parseInt(price[i]);
                } catch (Exception ex) {
                    allIntegers = false;
                }
            }
        }

        if ((allIntegers == true) && (point == true) && (decimalCount == 2)) { //If input is in the correct format...
            valid = true;
        }

        return valid;
    }

    /**
     * Ensures a users text field input does not contain a "," character
     * 
     * @param textFieldInput users text field input
     * @return boolean stating whether input contains a "," character or not
     */
    public static boolean textFieldCheck(String textFieldInput) {
        boolean valid = true; //Stores whether input contains a "," character or not
        
        String[] inputArray = textFieldInput.split(""); //Input stored in an array

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(",")) {
                valid = false;
            }
        }

        return valid;
    }

    /**
     * Ensures a users text area input does not contain a "," character/new line
     * 
     * @param textAreaInput users text area input
     * @return boolean stating whether input contains a "," character/new line or not
     */
    public static boolean textAreaCheck(String textAreaInput) {
        boolean valid = true; //Stores whether input contains a "," character/new line or not
        
        String[] inputArray = textAreaInput.split(""); //Input stored in an array

        for (int i = 0; i < inputArray.length; i++) {
            if ((inputArray[i].equals(",")) || (inputArray[i].equals("\n"))) {
                valid = false;
            }
        }

        return valid;
    }

    /**
     * Checks a users input is the integer data type
     * 
     * @param input users input
     * @return boolean stating whether input is an integer or not
     */
    public static boolean integerTypeCheck(String input) {
        boolean valid; //Stores whether input is an integer or not

        try {
            Integer.parseInt(input);
            valid = true;
        } catch (Exception ex) {
            valid = false;
        }

        return valid;
    }

    /**
     * Checks a users input is the float data type
     * 
     * @param input users input
     * @return boolean stating whether input is a float or not
     */
    public static boolean floatTypeCheck(String input) {
        boolean valid; //Stores whether input is a float or not

        try {
            Float.parseFloat(input);
            valid = true;
        } catch (Exception ex) {
            valid = false;
        }

        return valid;
    }

    /**
     * Checks a users input is between (or equal to one of) two specified values
     * 
     * @param input users input
     * @param lowestValue lowest possible value for input
     * @param highestValue highest possible value for input
     * @return boolean stating whether input is between (or equal to one of) two specified values or not
     */
    public static boolean rangeCheck(int input, int lowestValue, int highestValue) {
        boolean valid; //Stores whether input is between (or equal to one of) 
                       //two specified values or not

        if (input >= lowestValue && input <= highestValue) {
            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

}
