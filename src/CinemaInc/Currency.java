package CinemaInc;

import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class Currency { //Class deals with currency conversions

    static int currencyIndex = 0; //Stores index of users chosen currency

    /**
     * Constructor method for the Currency class
     */
    public Currency() {

    }

    /**
     * Sets currencyIndex upon the user leaving the Main Menu Form, where users
     * can switch between currencys
     *
     * @param newCurrencyIndex new index of a currency selected on the Main Menu
     * Form
     */
    public static void setCurrencyIndex(int newCurrencyIndex) {
        currencyIndex = newCurrencyIndex;
    }

    /**
     * Returns the index of the current currency
     *
     * @return currencyIndex
     */
    public static int getCurrencyIndex() {
        return currencyIndex;
    }

    /**
     * Converts an amount from pounds to dollars
     *
     * @param amount amount in pounds
     * @return amount in dollars
     */
    public static float poundToDollar(float amount) {
        float dollars; //Stores amount in dollars
        dollars = (float) (amount * 1.30); //Casting used in conversion from pounds to dollars
        return dollars;
    }

    /**
     * Converts an amount from pounds to euros
     *
     * @param amount amount in pounds
     * @return amount in euros
     */
    public static float poundToEuro(float amount) {
        float euro; //Stores amount in euros
        euro = (float) (amount * 1.17); //Casting used in conversion from pounds to euros
        return euro;
    }

    /**
     * Formats a converted amount to 2 decimal places
     *
     * @param money amount of money recently converted to a different currency
     * @return amount to 2 decimal places
     */
    public static String formatConversion(String money) {
        float amount = Float.parseFloat(money); //Stores money as a float

        DecimalFormat df = new DecimalFormat("0.00"); //New DecimalFormat object created for format "0.00"
        df.setMaximumFractionDigits(2); //Sets maximum decimal places to 2
        String amountFormatted = df.format(amount); //Formats amount to 2.d.p.

        return amountFormatted;
    }

    /**
     * Finds symbol of users chosen currency
     * 
     * @param index index of users chosen currency
     * @return symbol of users chosen currency
     */
    public static String findSymbol(int index) {
        //Stores symbol of users chosen currency
        String currencySymbol = "";
        
        if (index == 0) {
            currencySymbol = "£";
        }
        if (index == 1) {
            currencySymbol = "$";
        }
        if (index == 2) {
            currencySymbol = "€";
        }
        
        return currencySymbol;
    }

    /**
     * Converts amount to users chosen currency
     * Formats converted amount to "0.00" format
     * 
     * @param amount amount to be converted
     * @param index index of users chosen currency
     * @return amount converted to users currency and formatted to "0.00" format
     */
    public static String convertAmount(float amount, int index) {
        String amountString = ""; //Stores converted amount as a String
        String amountFormatted = ""; //Stores formatted amount as a String

        //Converts amount depending on users chosen currency
        if (currencyIndex == 0) {
            amountString = String.valueOf(amount);
        }
        if (currencyIndex == 1) {
            amountString = String.valueOf(poundToDollar(amount));
        }
        if (currencyIndex == 2) {
            amountString = String.valueOf(poundToEuro(amount));
        }
        
        //Formats amount to "0.00" format
        amountFormatted = formatConversion(amountString);
        
        return amountFormatted;
    }

}
