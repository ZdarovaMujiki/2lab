package com.company;

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
    public static void main(String[] args)
    {
        OperationCreator operationCreator = null;
        try
        {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logger.properties"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO, "program started");
        operationCreator = new OperationCreator();
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
                }
                catch (IllegalAccessException | InstantiationException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException | EmptyStackException e)
                {
                    e.printStackTrace();
                    logger.log(Level.WARNING, e.toString());
                }
            }
            command = input.getLine();
            logger.log(Level.INFO, "current command: " + command);
        }
        logger.log(Level.INFO, "program finished");
    }
}
