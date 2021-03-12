package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Input
{
    String getLine();
    boolean inputEnd(String line);
}

class FileInput implements Input
{
    Logger logger = Logger.getLogger(Main.class.getName());
    BufferedReader reader;
    FileInput(String filename)
    {
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            logger.log(Level.INFO, "file input created, file: " + filename);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            logger.log(Level.WARNING, e.toString());
        }
    }
    @Override
    public String getLine()
    {
        try
        {
            return reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            logger.log(Level.WARNING, e.toString());
        }
        return null;
    }

    @Override
    public boolean inputEnd(String line)
    {
        return line == null;
    }
}

class ConsoleInput implements Input
{
    Logger logger = Logger.getLogger(Main.class.getName());
    Scanner scanner;
    ConsoleInput()
    {
        scanner = new Scanner(System.in).useDelimiter("\n");
        logger.log(Level.INFO, "console input created");
    }
    @Override
    public String getLine()
    {
        return scanner.next();
    }

    @Override
    public boolean inputEnd(String line)
    {
        return line.equals(".");
    }
}