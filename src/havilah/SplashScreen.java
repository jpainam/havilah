
package havilah;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import ui.GUI;
import ui.LoginOkCancel;
/**
 *
 * @author jpainam
 * created : 01 - Nov - 2013
 * Last Modification : 01 - Nov - 2013
 */
public class SplashScreen extends JWindow implements  ActionListener{
    private int loadingDelay; 
    private Timer timer;


    
    public SplashScreen(String imagePath, String progressPath, int loadingDelay) {
        
        this.loadingDelay = loadingDelay;
        ImageIcon splashImage = new ImageIcon(imagePath);  
        ImageIcon splashProgress = new ImageIcon(progressPath);

        JLabel splashLabel =   new JLabel(splashImage);
        JLabel splashLabelProgress =   new JLabel(splashProgress);
        splashLabel.setPreferredSize(new Dimension(600,450));
        splashLabelProgress.setPreferredSize(new Dimension(600,20));
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(splashLabel, BorderLayout.CENTER);
        JPanel jpb = new JPanel();
        jpb.setPreferredSize(new Dimension(600,20));
        jpb.setBackground(Color.white);
        jpb.setLayout(new FlowLayout(FlowLayout.LEFT));
        jpb.add(splashLabelProgress);
        jp.add(jpb, BorderLayout.SOUTH);
        getContentPane().add(jp);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setVisible(true);	 
        load();
    }

    private void load() {

            timer = new Timer(0, this); 
            timer.setInitialDelay(loadingDelay * 1000); 
            timer.start(); 
}

    public void actionPerformed(ActionEvent e) {
            timer.stop();
            hide();
            //GUI g = new GUI();
            LoginOkCancel login = new LoginOkCancel(null, true);
            login.setVisible(true);
            
    }
}
