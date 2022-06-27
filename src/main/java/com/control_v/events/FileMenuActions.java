package main.java.com.control_v.events;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import main.java.com.control_v.components.AppFrame;
import main.java.com.control_v.components.TextArea;
import main.java.com.control_v.logic.FileOperation;
import main.java.com.control_v.logic.ReadWrite;
import main.java.com.control_v.logic.UndoEngine;
import main.java.com.control_v.Consts;

public class FileMenuActions implements ActionListener 
{   
    // Method logic
    private FileOperation fileChooser = FileOperation.getInstance();
    private ReadWrite filer = ReadWrite.getInstance();

    // Variables
    private File file = null;

    // Components
    private AppFrame frame = AppFrame.getInstance();
    private TextArea textArea = TextArea.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) 
    {   
        // Open file
        if(e.getActionCommand().equals("Open"))
        {
            openFile();
            UndoEngine.getInstance().getUndoManager().discardAllEdits();
        }

        if(e.getActionCommand().equals("Save"))
        {   
            saveFile();
        }

        if(e.getActionCommand().equals("Save as"))
        {
            saveAs();
        }

        if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
    }

    private void openFile()
    {
        file = fileChooser.openFile();

        if(file != null)
        {
            textArea.getTextArea().setText(filer.fileOpen(file));
            frame.getFrame().setTitle(Consts.appName + " - " + file.getName());
        }
    }

    private void saveFile()
    {
        if(file == null)
        {
            saveAs();
        }
        else
        {
            filer.fileSave(file, textArea.getTextArea().getText());
        }
    }

    private void saveAs()
    {
        file = fileChooser.saveAsFile();
        filer.fileSave(file, textArea.getTextArea().getText());
    }
}