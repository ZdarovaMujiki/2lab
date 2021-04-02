package com.company.tests;

import com.company.operations.Define;
import com.company.operations.Operation;
import com.company.operations.Pop;
import com.company.operations.Push;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

import static org.junit.Assert.*;

public class DefineTest
{
    Operation define;
    Operation push;
    Stack<Double> stack = new Stack<>();
    HashMap<String, Double> map = new HashMap<>();

    @Test
    public void DefineExec()
    {
        define = new Define("test", "3.5");
        define.exec(stack, map);
        push = new Push("test");
        push.exec(stack, map);
        Assert.assertEquals(3.5, stack.peek(), 0.00001);
    }
    @Test
    public void DefineException()
    {
        Assert.assertThrows(NumberFormatException.class, () -> { define = new Define("test", "abc"); });
        Assert.assertThrows(IllegalArgumentException.class, () -> { define = new Define("312", "555"); });
    }
}