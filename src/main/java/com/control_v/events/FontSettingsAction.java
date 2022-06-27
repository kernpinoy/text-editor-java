package main.java.com.control_v.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.control_v.logic.FontSetting;

public class FontSettingsAction implements ActionListener 
{   
    private FontSetting fontSetting = new FontSetting();

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Change font size"))
        {
            fontSetting.changeFontSize();
        }

        if(e.getActionCommand().equals("Change font"))
        {
            fontSetting.changeFont();
        }
    }    
}
