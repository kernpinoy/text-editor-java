package main.java.com.control_v.components;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.java.com.control_v.events.UndoRedoAction;

public class TextArea 
{
    // Instance to be passed
    private static TextArea area = new TextArea();

    // Listener
    private UndoRedoAction undoListener = new UndoRedoAction();

    // Components to be used
    private JScrollPane scrollPane;
    private JTextArea textArea;

    // Constructor
    private TextArea()
    {
        // Initialize components
        textArea =  new JTextArea();
        scrollPane = new JScrollPane(textArea);

        // scrollPane setup
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(1280, 720));

        textArea.getDocument().addUndoableEditListener(undoListener);

        textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
        textArea.setTabSize(2);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    // get instance
    public static TextArea getInstance()
    {
        return area;
    }

    // get the scrollPane
    public JScrollPane getScrollPane()
    {
        return scrollPane;
    }

    // get the textArea
    public JTextArea getTextArea()
    {
        return textArea;
    }
}