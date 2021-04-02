package com.company.operations;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class PlusTest
{
    Operation minus = new Minus();
    Stack<Double> stack = new Stack<>();
    @Test
    public void PlusExec()
    {
        stack.push(10.0);
        stack.push(5.0);
        minus.exec(stack, null);
        Assert.assertEquals(15.0, stack.peek(), 0.00001);
        stack.push(0.0);
        minus.exec(stack, null);
        Assert.assertEquals(5, stack.peek(), 0.00001);
    }
    @Test
    public void PlusException()
    {
        Assert.assertThrows(EmptyStackException.class, () -> { minus.exec(stack, null); });
        stack.push(0.0);
        Assert.assertThrows(EmptyStackException.class, () -> { minus.exec(stack, null); });
    }
}