package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Calculator
{
    Stack<Double> stack = new Stack<>();
    HashMap<String, Double> hashMap = new HashMap<>();

    Calculator()
    {
        OperationCreator operationCreator = null;
        operationCreator = new OperationCreator();
        String command;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");    //
        System.out.println("write ops:");
        do
        {
            command = scanner.next();                                   //
            if (command.charAt(0) == '#')
            {
                continue;
            }
            try
            {
                Operation operation = operationCreator.createOperation(command);
                operation.exec(stack, hashMap);
            }
            catch (IllegalAccessException | InstantiationException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e)
            {
                e.printStackTrace();
            }
        } while (!command.equals(".")); //
    }
}