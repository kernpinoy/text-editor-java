package main.java.com.control_v.logic;

import java.io.File;

import javax.swing.JFileChooser;

public class FileOperation 
{
    // Instance to be passed
    private static FileOperation currentInstance = new FileOperation();

    // Components
    private JFileChooser fileChooser;

    // Constructor
    private FileOperation()
    { 
        fileChooser = new JFileChooser(System.getProperty("user.home"));
    }

    public static FileOperation getInstance()
    {
        return currentInstance;
    }

    // Opens a popup and returns a File
    public File openFile()
    {   
        File file = null;
        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION)
        {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }
        
        return file;
    }

    public JFileChooser getFileChooser()
    {
        return fileChooser;
    }

    public File saveAsFile()
    {
        File file = null;

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION)
        {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        return file;
    }
}