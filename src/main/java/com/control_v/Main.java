package main.java.com.control_v;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class Main 
{
    public static void main(String[] args) 
    {           
        try
        {   
            UIManager.setLookAndFeel(new FlatLightLaf());
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run() 
                {  
                    new GUI();
                 }
            });
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }   
}