package com.company;

import com.company.operations.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;

class OperationCreator
{
    private HashMap<String, String> map = new HashMap<>();
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
            Main.logger.log(Level.WARNING, e.toString() + ", no file 'conf', shutting down");
            System.exit(-1);
        }
    }

    Operation createOperation(String command) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        String[] splitCommand = command.split(" ");
        int commandAmount = splitCommand.length - 1;
        Object[] args = new Object[commandAmount];
        Class[] classes = new Class[commandAmount];

        for (int i = 0; i < commandAmount; ++i)
        {
            args[i] = splitCommand[i + 1];
            classes[i] = String.class;
        }
        if (map.containsKey(splitCommand[0]))
        {
            return (Operation) Class.forName(map.get(splitCommand[0])).getDeclaredConstructor(classes).newInstance(args);
        }
        else
        {
            throw new ClassNotFoundException();
        }
    }
}