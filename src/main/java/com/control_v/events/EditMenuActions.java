package main.java.com.control_v.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.control_v.components.TextArea;
import main.java.com.control_v.logic.UndoEngine;

public class EditMenuActions implements ActionListener
{   
    // TextAre to be edited
    private TextArea textArea = TextArea.getInstance();

    // UndoEngine for undo and redo
    private UndoEngine engine = UndoEngine.getInstance();

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Cut"))
        {
            textArea.getTextArea().cut();
        }

        if(e.getActionCommand().equals("Copy"))
        {
            textArea.getTextArea().copy();
        }

        if(e.getActionCommand().equals("Paste"))
        {
            textArea.getTextArea().paste();
        }
        
        if(e.getActionCommand().equals("Select all"))
        {
            textArea.getTextArea().selectAll();
        }

        if(e.getActionCommand().equals("Undo"))
        {
            engine.getUndoManager().undo();
        }

        if(e.getActionCommand().equals("Redo"))
        {
            engine.getUndoManager().redo();
        }
    }  
}