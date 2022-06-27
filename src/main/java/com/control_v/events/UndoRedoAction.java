package main.java.com.control_v.events;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import main.java.com.control_v.logic.UndoEngine;

public class UndoRedoAction implements UndoableEditListener
{   
    // Helper instance
    private UndoEngine engine = UndoEngine.getInstance();

    @Override
    public void undoableEditHappened(UndoableEditEvent e) 
    {
        engine.getUndoManager().addEdit(e.getEdit());
    }
}