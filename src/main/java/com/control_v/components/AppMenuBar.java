package main.java.com.control_v.components;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import main.java.com.control_v.events.FileMenuActions;
import main.java.com.control_v.events.FontSettingsAction;
import main.java.com.control_v.events.ThemeMenuActions;
import main.java.com.control_v.events.EditMenuActions;

public class AppMenuBar 
{   
    // Event handler
    private FileMenuActions fileActions = new FileMenuActions();
    private EditMenuActions editActions = new EditMenuActions();
    private ThemeMenuActions themeActions = new ThemeMenuActions();
    private FontSettingsAction fontAction = new FontSettingsAction();

    // Instance
    private static AppMenuBar bar = new AppMenuBar();

    // Variables
    private final String[] menuItem = {"File", "Edit", "Themes", "Font settings"};
    private final String[] fileMenuItemNames = {"Open", "Save", "Save as", "Exit"};
    private final String[] editMenuItemNames = {"Cut", "Copy", "Paste", "Select all", "Undo", "Redo"};
    private final String[] themeMenuItems = {"Light theme", "Dark theme"};
    private final String[] fontSettingsItemNames = {"Change font size", "Change font"};

    // Components
    private JMenuBar menuBar;
    private JMenu[] menuItems = new JMenu[menuItem.length];
    {
        for(int i = 0, n = menuItems.length; i < n; ++i)
        {
            menuItems[i] = new JMenu(menuItem[i]);
        }
    }
    private JMenuItem[] editMenuItems = new JMenuItem[editMenuItemNames.length];
    {
        for(int i = 0, n = editMenuItems.length; i < n; ++i) 
        {
            editMenuItems[i] = new JMenuItem(editMenuItemNames[i]);
        }
    }
    private JMenuItem[] fileMenuItems = new JMenuItem[fileMenuItemNames.length];
    {
        for(int i = 0, n = fileMenuItems.length; i < n; ++i) 
        {
            fileMenuItems[i] = new JMenuItem(fileMenuItemNames[i]);
        }
    }
    private JRadioButtonMenuItem[] themesButton = new JRadioButtonMenuItem[themeMenuItems.length];
    {
        for(int i = 0, n = themesButton.length; i < n; ++i)
        {
            themesButton[i] = new JRadioButtonMenuItem(themeMenuItems[i]);
        }

        themesButton[0].setSelected(true);
    }
    private JMenuItem[] fontSettingsItems = new JMenuItem[fontSettingsItemNames.length];
    {
        for(int i = 0, n = fontSettingsItems.length; i < n; ++i)
        {
            fontSettingsItems[i] = new JMenuItem(fontSettingsItemNames[i]);
        }
    }

    private ButtonGroup bg;

    // Constructor
    private AppMenuBar()
    {
        setupComponents();
        setupComponentListeners();
        setupMenuBar();
        setMmemonic();
        setAccelerator();
    }

    // returns the instance
    public static AppMenuBar getInstance()
    {
        return bar;
    }

    // returns the JMenuBar (already set up)
    public JMenuBar getMenuBar()
    {
        return menuBar;
    }

    // setup components
    private void setupComponents()
    {   
        bg = new ButtonGroup();
        menuBar = new JMenuBar();

        // Setup fileMenu items
        for(JMenuItem item : fileMenuItems)
        {   
            menuItems[0].add(item);
        }

        // Setup editMenu items
        for(JMenuItem item : editMenuItems)
        {
            menuItems[1].add(item);
        }

        // setup themeMenu items
        for(JRadioButtonMenuItem item : themesButton)
        {
            menuItems[2].add(item);
            bg.add(item);
        }

        // fontSettings
        for(JMenuItem item : fontSettingsItems)
        {
            menuItems[3].add(item);
        }
    }

    // setup event listeners
    private void setupComponentListeners()
    {   
        // fileMenuItems listeners    
        for(int i = 0; i < fileMenuItemNames.length; ++i)
        {
            fileMenuItems[i].addActionListener(fileActions);
            fileMenuItems[i].setActionCommand(fileMenuItemNames[i]);
        }

        // editMenuitems listener
        for(int i = 0, n = editMenuItems.length; i < n; ++i)
        {
            editMenuItems[i].addActionListener(editActions);
            editMenuItems[i].setActionCommand(editMenuItemNames[i]);
        }

        // editMenuitems listener
        for(int i = 0, n = themesButton.length; i < n; ++i)
        {
            themesButton[i].addActionListener(themeActions);
            themesButton[i].setActionCommand(themeMenuItems[i]);
        }

        //font setting
        for(int i = 0, n = fontSettingsItems.length; i < n; ++i)
        {
            fontSettingsItems[i].addActionListener(fontAction);
            fontSettingsItems[i].setActionCommand(fontSettingsItemNames[i]);
        }
    }
            
    // Setup menuBar 
    private void setupMenuBar()
    {
        for(int i = 0, n = menuItems.length; i < n; ++i)
        {
            menuBar.add(menuItems[i]);
        }
    }

    // mmemonics for everyone
    private void setMmemonic()
    {  
        // menuItems setMmemonics
        for(int i = 0, n = menuItems.length; i < n; ++i)
        {
            char[] m = {'F', 'E', 'T', 'S'};
            menuItems[i].setMnemonic(m[i]);    
        }

        // fileMenuItems
        for(int i = 0,n = fileMenuItems.length; i < n; ++i)
        {
            char[] m = {'O', 'S', 'A', 'E'};
            fileMenuItems[i].setMnemonic(m[i]);
        }

        // editMenuItems
        for(int i = 0, n = editMenuItems.length; i < n; ++i)
        {
            char[] m = {'C', 'O', 'P', 'S', 'U', 'r'};
            editMenuItems[i].setMnemonic(m[i]);
        }

        // themeMenuItems
        for(int i = 0, n = themesButton.length; i < n; ++i)
        {
            char[] m = {'L', 'D'};
            themesButton[i].setMnemonic(m[i]);
        }

        // fontSetting
        for(int i = 0, n = fontSettingsItems.length; i < n; ++i)
        {
            char[] m = {'F', 'O'};
            fontSettingsItems[i].setMnemonic(m[i]);
        }
    }

    // sets accelerators for buttons
    private void setAccelerator()
    {
        // fileMenu
        fileMenuItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)); // Open function
        fileMenuItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)); // Save function
        fileMenuItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK)); // Save As function
        fileMenuItems[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK)); // Exit function

        // editMenu
        editMenuItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK)); // Cut function
        editMenuItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK)); // Copy function
        editMenuItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK)); // Paste function
        editMenuItems[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK)); // Select All function
        editMenuItems[4].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK)); // Undo function
        editMenuItems[5].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK)); // Redo function

        // themeButton
        themesButton[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK)); // Light theme function
        themesButton[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK)); // Dark theme function

        // fontSetting buttons
        fontSettingsItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK)); // Font Size function
        fontSettingsItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK)); // Font change function
    }
}