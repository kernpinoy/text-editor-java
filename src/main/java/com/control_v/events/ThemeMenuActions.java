package main.java.com.control_v.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.control_v.logic.ThemeSwitcher;

public class ThemeMenuActions implements ActionListener 
{
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Dark theme"))
        {   
            ThemeSwitcher.getInstance().changeDark();
        }

        if(e.getActionCommand().equals("Light theme"))
        {
            ThemeSwitcher.getInstance().changeLight();
        }
    }
}
