package CinemaInc;

import javax.swing.ImageIcon;
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
public class Image { //Stores all methods that display images to JLabels

    /**
     * Constructor method for the Image class
     */
    public Image() {

    }

    /**
     * Sets 3 JLabels in MainMenuUI class to appropriate event icons
     *
     * @param eventTypes 1D array of the event types for the 3 closest events
     * displayed on the Main Menu Form
     * @param eventIcon1 JLabel for event 1
     * @param eventIcon2 JLabel for event 2
     * @param eventIcon3 JLabel for event 3
     */
    public void setMainMenuIcons(String[] eventTypes, JLabel eventIcon1, JLabel eventIcon2, JLabel eventIcon3) {
        String[] eventIconPaths = new String[3]; //Array stores file paths of images to be displayed to the 3 JLabels

        //Collects file paths of images corresponding to the input event types into eventIconPath
        for (int i = 0; i < 3; i++) {
            if (eventTypes[i].equals("Film")) {
                eventIconPaths[i] = "/Resources/FilmIcon.jpg";
            }
            if (eventTypes[i].equals("Music")) {
                eventIconPaths[i] = "/Resources/MusicIcon.jpg";
            }
            if (eventTypes[i].equals("Other")) {
                eventIconPaths[i] = "/Resources/OtherIcon.jpg";
            }
        }

        //New ImageIcon objects created for the relevant image file paths
        ImageIcon icon1 = new ImageIcon(getClass().getResource(eventIconPaths[0]));
        ImageIcon icon2 = new ImageIcon(getClass().getResource(eventIconPaths[1]));
        ImageIcon icon3 = new ImageIcon(getClass().getResource(eventIconPaths[2]));
        
        //Displays ImageIcon objects to JLabels
        eventIcon1.setIcon(icon1);
        eventIcon2.setIcon(icon2);
        eventIcon3.setIcon(icon3);
    }

    /**
     * Sets JLabel to appropriate event icon
     * 
     * @param eventType event type of JLabels event
     * @param eventIcon JLabel for event
     */
    public void setEventIcon(String eventType, JLabel eventIcon) {
        String eventIconPath = ""; //Stores file path of image to be displayed to the JLabel

        //Collects file path of image corresponding to the input event type
        if (eventType.equals("Film")) {
            eventIconPath = "/Resources/FilmIcon.jpg";
        }
        if (eventType.equals("Music")) {
            eventIconPath = "/Resources/MusicIcon.jpg";
        }
        if (eventType.equals("Other")) {
            eventIconPath = "/Resources/OtherIcon.jpg";
        }

        ImageIcon icon = new ImageIcon(getClass().getResource(eventIconPath)); //New ImageIcon object created for 
                                                                               //the relevant image file path
        eventIcon.setIcon(icon); //Displays ImageIcon object to JLabel
    }

}
