package main.java.com.control_v.logic;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import main.java.com.control_v.components.AppFrame;

public class ThemeSwitcher 
{   
    // instance
    private static ThemeSwitcher currentInstance = new ThemeSwitcher();

    // to be themed
    private FileOperation operation = FileOperation.getInstance();
    private AppFrame frame = AppFrame.getInstance();

    // Constructor
    private ThemeSwitcher() {}

    public static ThemeSwitcher getInstance()
    {
        return currentInstance;
    }

    // switches theme to dark
    public void changeDark()
    {
        try 
        {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(frame.getFrame().getRootPane());
            SwingUtilities.updateComponentTreeUI(operation.getFileChooser());
            frame.getFrame().pack();
        } 
        catch (UnsupportedLookAndFeelException e) 
        {
            e.printStackTrace();
        }
    }

    // switches theme to light
    public void changeLight()
    {
        try 
        {   
            UIManager.setLookAndFeel(new FlatLightLaf());
            SwingUtilities.updateComponentTreeUI(frame.getFrame().getRootPane());
            SwingUtilities.updateComponentTreeUI(operation.getFileChooser());
            frame.getFrame().pack();
        } 
        catch (UnsupportedLookAndFeelException e) 
        {

            e.printStackTrace();
        }
    }
}