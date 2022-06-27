package main.java.com.control_v.logic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ReadWrite 
{
    // Instance to be passed
    private static ReadWrite newInstance = new ReadWrite();
    private static Charset utf8 = Charset.forName("UTF8");

    // Constructor
    private ReadWrite() {}

    // return the instance of the class
    public static ReadWrite getInstance()
    {
        return newInstance;
    }

    // Opens a file and grabs it contents
    public String fileOpen(File newFile)
    {
        Scanner scanner = null;
        String text = "";
        
        if(newFile.isFile())
        {    
            try 
            {
                scanner = new Scanner(newFile, utf8);

                while(scanner.hasNext())
                {
                    text += scanner.nextLine();

                    if(scanner.hasNextLine())
                    {
                        text += '\n';
                    }
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                scanner.close();
            }
        }
        
        return text;
    }

    // saves data to a file
    public void fileSave(File file, String text)
    {
        PrintWriter writer = null;

        try
        {
            writer = new PrintWriter(file, utf8);
            writer.println(text);
        }
        catch(Exception e)
        {   
            e.printStackTrace();
        }
        finally
        {
            writer.flush();
            writer.close();
        }

        if(file == null)
        {
            System.out.println("file is null");
        }
        
        if(file == null)
        {
            System.out.println("file is null");
        }
    }
}