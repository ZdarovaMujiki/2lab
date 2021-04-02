package com.company.tests;

import com.company.operations.Minus;
import com.company.operations.Operation;
import com.company.operations.Plus;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class PlusTest
{
    private Operation plus = new Plus();
    private Stack<Double> stack = new Stack<>();
    @Test
    public void PlusExec()
    {
        stack.push(10.0);
        stack.push(5.0);
        plus.exec(stack, null);
        Assert.assertEquals(15.0, stack.peek(), 0.00001);
        stack.push(-20.0);
        plus.exec(stack, null);
        Assert.assertEquals(-5.0, stack.peek(), 0.00001);
    }
    @Test
    public void PlusException()
    {
        Assert.assertThrows(EmptyStackException.class, () -> plus.exec(stack, null));
        stack.push(0.0);
        Assert.assertThrows(EmptyStackException.class, () -> plus.exec(stack, null));
    }
}