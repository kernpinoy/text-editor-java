package main.java.com.control_v;

import java.awt.BorderLayout;

import main.java.com.control_v.components.AppFrame;
import main.java.com.control_v.components.AppMenuBar;
import main.java.com.control_v.components.TextArea;

public class GUI 
{   
    private AppFrame frame = AppFrame.getInstance();
    private AppMenuBar menuBar = AppMenuBar.getInstance();
    private TextArea textArea = TextArea.getInstance();
    
    public GUI()
    {   
        initGUI();
    }

    // Initialize GUI
    private void initGUI()
    {   
        frame.getFrame().getContentPane().add(menuBar.getMenuBar(), BorderLayout.NORTH);
        frame.getFrame().getContentPane().add(textArea.getScrollPane(), BorderLayout.CENTER);
        frame.getFrame().pack();
        frame.getFrame().setVisible(true);
    }
}