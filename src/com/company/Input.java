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
    BufferedReader reader;
    FileInput(String filename)
    {
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            Main.logger.log(Level.INFO, "file input created, file: " + filename);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Main.logger.log(Level.WARNING, e.toString());
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
            Main.printMessage(e.getMessage());
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
    Scanner scanner;
    ConsoleInput()
    {
        scanner = new Scanner(System.in).useDelimiter("\n");
        Main.logger.log(Level.INFO, "console input created");
    }
    @Override
    public String getLine()
    {
        String str;
        while((str = scanner.next()).length() == 0);
        return str;
    }

    @Override
    public boolean inputEnd(String line)
    {
        return line.equals(".");
    }
}