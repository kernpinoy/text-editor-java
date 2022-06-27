package main.java.com.control_v.logic;

import javax.swing.undo.UndoManager;

public class UndoEngine 
{   
    // Instance
    private static UndoEngine currentManager = new UndoEngine();

    // Conmponets
    private UndoManager manager;

    // Constructor
    private UndoEngine()
    {
        manager = new UndoManager();
    }

    // Pass instance
    public static UndoEngine getInstance()
    {
        return currentManager;
    }

    // pass components
    public UndoManager getUndoManager()
    {
        return manager;
    }
}