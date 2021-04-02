package com.company.operations;

import com.company.Main;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Sqrt implements Operation
{
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        Double a = stack.pop();
        stack.push(Math.sqrt(a));
        logger.log(Level.INFO, "sqrt(" + a + ") = " + Math.sqrt(a) + " pushed, stack size: " + stack.size());
    }
}
