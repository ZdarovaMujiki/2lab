package com.company.operations;

import com.company.Main;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Pop implements Operation
{
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        logger.log(Level.INFO, stack.peek() + " popped, stack size: " + (stack.size() - 1));
        stack.pop();
    }
}
