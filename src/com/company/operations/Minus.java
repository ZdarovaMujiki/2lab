package com.company.operations;

import com.company.Main;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Minus implements Operation
{
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (stack.size() > 1)
        {
            Double a = stack.pop();
            Double b = stack.pop();
            stack.push(a - b);
            Main.logger.log(Level.INFO, a + " - " + b + " = " + (a - b) + " pushed, stack size: " + stack.size());
        }
        else
        {
            throw new EmptyStackException();
        }
    }
}
