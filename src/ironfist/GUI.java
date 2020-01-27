/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ironfist;
import javax.swing.*;
/**
 *
 * @author jasonfujii
 */
public class GUI {
    //int width, height;
        //set up 
    
    //frame is the actual phsyical object
    //panel is what we're writing on
        //like a div in HTML
    JFrame frame;
    //set up width and height
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    JPanel panel;
    //make it visible
    //add to frame
        //frame.addPanel(panel)
    
    public GUI()
    {
        frame = new JFrame("Iron Fist");
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        panel = new JPanel();
        frame.add(panel);
        
    }
}
