package com.company.operations;

import com.company.Main;

import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Push implements Operation
{
    String argument;

    public Push(String argument) {
        this.argument = argument;
    }

    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (map.containsKey(argument))
        {
            stack.push(map.get(argument));
            Main.logger.log(Level.INFO, map.get(argument) + " pushed, stack size: " + stack.size());
        }
        else
        {
            stack.push(Double.valueOf(argument));
            Main.logger.log(Level.INFO, Double.valueOf(argument) + " pushed, stack size: " + stack.size());
        }
    }
}
