package main.java.com.control_v.logic;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import main.java.com.control_v.components.TextArea;

public class FontSetting
{   
    // textArea
    private TextArea textArea = TextArea.getInstance();

    public void changeFont()
    {   
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JComboBox<String> comboBox = new JComboBox<String>(fonts);
        comboBox.setSelectedItem(textArea.getTextArea().getFont().getFontName());

        int response = JOptionPane.showOptionDialog(null, comboBox, "Select a font", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if(response == JOptionPane.OK_OPTION)
        {
            textArea.getTextArea().setFont(new Font((String)comboBox.getSelectedItem(), Font.PLAIN, textArea.getTextArea().getFont().getSize()));
        }
    }

    public void changeFontSize()
    {
        SpinnerNumberModel sModel = new SpinnerNumberModel(textArea.getTextArea().getFont().getSize(), 1, 100, 1);
        JSpinner spinner = new JSpinner(sModel);
        spinner.setValue(textArea.getTextArea().getFont().getSize());

        int response = JOptionPane.showOptionDialog(null, spinner, "Select a font size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if(response == JOptionPane.OK_OPTION)
        {
            textArea.getTextArea().setFont(new Font(textArea.getTextArea().getFont().getFamily(), Font.PLAIN, (int)spinner.getValue()));
        }
    }
}