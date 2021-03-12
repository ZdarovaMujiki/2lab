package com.company;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Operation
{
    void exec(Stack<Double> stack, HashMap<String, Double> map);
}

class Pop implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (!stack.empty())
        {
            logger.log(Level.INFO, stack.peek() + " popped, stack size: " + (stack.size() - 1));
            stack.pop();
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 1, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Push implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    String str;
    Push(String str)
    {
        this.str = str;
    }

    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (map.containsKey(str))
        {
            stack.push(map.get(str));
            logger.log(Level.INFO, map.get(str) + " pushed, stack size: " + stack.size());
        }
        else
        {
            stack.push(Double.valueOf(str));
            logger.log(Level.INFO, Double.valueOf(str) + " pushed, stack size: " + stack.size());
        }
    }
}

class Plus implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (stack.size() > 1)
        {
            Double a = stack.pop();
            Double b = stack.pop();
            stack.push(a + b);
            logger.log(Level.INFO, a + " + " + b + " = " + (a + b) + " pushed, stack size: " + stack.size());
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 2, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Minus implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (stack.size() > 1)
        {
            Double a = stack.pop();
            Double b = stack.pop();
            stack.push(a - b);
            logger.log(Level.INFO, a + " - " + b + " = " + (a - b) + " pushed, stack size: " + stack.size());
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 2, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Mul implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (stack.size() > 1)
        {
            Double a = stack.pop();
            Double b = stack.pop();
            stack.push(a * b);
            logger.log(Level.INFO, a + " * " + b + " = " + (a * b) + " pushed, stack size: " + stack.size());
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 2, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Div implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (stack.size() > 1)
        {
            Double a = stack.pop();
            Double b = stack.pop();
            stack.push(a / b);
            logger.log(Level.INFO, a + " / " + b + " = " + (a / b) + " pushed, stack size: " + stack.size());
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 2, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Sqrt implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (!stack.empty())
        {
            Double a = stack.pop();
            stack.push(Math.sqrt(a));
            logger.log(Level.INFO, "sqrt(" + a + ") = " + Math.sqrt(a) + " pushed, stack size: " + stack.size());
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 1, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Print implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        if (!stack.empty())
        {
            System.out.println(stack.peek());
            logger.log(Level.INFO, stack.peek() + " printed, stack size: " + stack.size());
        }
        else
        {
            logger.log(Level.WARNING, "not enough elements in stack! need: 1, stack size:" + stack.size());
            throw new EmptyStackException();
        }
    }
}

class Define implements Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    String str;
    Double d;
    Define(String str, String a)
    {
        this.str = str;
        d = Double.valueOf(a);
        logger.log(Level.INFO, str + " = " + d + " defined");
    }

    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map)
    {
        map.put(str, d);
    }
}