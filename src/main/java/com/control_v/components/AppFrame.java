package main.java.com.control_v.components;

import main.java.com.control_v.Consts;

import javax.swing.JFrame;

import java.awt.BorderLayout;

public class AppFrame
{
    // Interface to pass 
    private static AppFrame newInstance = new AppFrame();

    // Component
    private JFrame frame;

    // Constructor
    private AppFrame()
    {
        initFrame();
    }

    public static AppFrame getInstance()
    {
        return newInstance;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    // Initialize frame
    private void initFrame()
    {   
        frame = new JFrame(Consts.appName + " - " + Consts.untitled);
        frame.setSize(1280, 720);
        //frame.setBounds(100, 100, 874, 530);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setResizable(true);
        //frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
    }
}