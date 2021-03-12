package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationCreator
{
    Logger logger = Logger.getLogger(Main.class.getName());
    HashMap<String, String> map = new HashMap<>();
    OperationCreator()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(OperationCreator.class.getResourceAsStream("conf")));

            String line;
            while((line = reader.readLine()) != null)
            {
                String[] names = line.split(" ");
                map.put(names[0], names[1]);
            }
        }
        catch (IOException | NullPointerException e)
        {
            logger.log(Level.WARNING, e.toString() + ", no file 'conf', shutting down");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Operation createOperation(String command) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        String[] splitCommand = command.split(" ");
        Object[] args = new Object[splitCommand.length - 1];
        Class[] classes = new Class[splitCommand.length - 1];
        for (int i = 0; i < splitCommand.length - 1; ++i)
        {
            args[i] = splitCommand[i + 1];
            classes[i] = String.class;
        }
        if (map.containsKey(splitCommand[0]))
        {
//            logger.log(Level.INFO, "creating object of class " + map.get(splitCommand[0]) + " with args " + Arrays.toString(args));
            return (Operation) Class.forName(map.get(splitCommand[0])).getDeclaredConstructor(classes).newInstance(args);
        }
        else
        {
            throw new ClassNotFoundException();
        }
    }
}