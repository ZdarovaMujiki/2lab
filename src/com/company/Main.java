package com.company;

import com.company.operations.Operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main
{
    public static Logger logger;
    public static void main(String[] args)
    {
        try
        {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logger.properties"));
        } catch (IOException e)
        {
            System.out.println("No file logger.properties!");
        }
        logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO, "program started");
        OperationCreator operationCreator = new OperationCreator();
        Input input = args.length > 0 ? new FileInput(args[0]) : new ConsoleInput();
        Stack<Double> stack = new Stack<>();
        HashMap<String, Double> hashMap = new HashMap<>();
        String command = input.getLine();
        logger.log(Level.INFO, "current command: " + command);
        while (!input.inputEnd(command))
        {
            if (command.charAt(0) != '#')
            {
                try
                {
                    Operation operation = operationCreator.createOperation(command);
                    operation.exec(stack, hashMap);
                } catch (IllegalAccessException e)
                {
                    printMessage("Illegal access!");
                } catch (InstantiationException e)
                {
                    printMessage("Can't instantiate class!");
                } catch (InvocationTargetException e)
                {
                    printMessage("Exception in invoked method!");
                    try
                    {
                        throw e.getTargetException();
                    } catch (Throwable t)
                    {
                        printMessage(t.getMessage());
                    }
                } catch (ClassNotFoundException e)
                {
                    printMessage("No such operation!");
                } catch (NoSuchMethodException e)
                {
                    printMessage("Wrong amount of args!");
                } catch (EmptyStackException e)
                {
                    printMessage("Not enough elements in stack!");
                }
            }
            command = input.getLine();
            logger.log(Level.INFO, "current command: " + command);
        }
        logger.log(Level.INFO, "program finished");
    }
    public static void printMessage(String message)
    {
        System.out.println(message);
        logger.log(Level.WARNING, message);
    }
}
