/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package havilah;

import ui.GUI;

/**
 *
 * @author jpainam
 */
public class Havilah {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SplashScreen s = new SplashScreen("src/resources/havilah.jpg", "src/resources/progressbar.gif", 4);
        
    }
}
