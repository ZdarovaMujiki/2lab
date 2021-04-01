package com.company.operations;

import com.company.Main;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Print implements Operation
{
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (!stack.empty())
        {
            System.out.println(stack.peek());
            Main.logger.log(Level.INFO, stack.peek() + " printed, stack size: " + stack.size());
        }
        else
        {
            throw new EmptyStackException();
        }
    }
}
