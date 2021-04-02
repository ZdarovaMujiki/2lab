package com.company.tests;

import com.company.operations.Define;
import com.company.operations.Div;
import com.company.operations.Operation;
import com.company.operations.Push;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class DivTest
{
    Operation div = new Div();
    Stack<Double> stack = new Stack<>();
    @Test
    public void DivExec()
    {
        stack.push(10.0);
        stack.push(5.0);
        div.exec(stack, null);
        Assert.assertEquals(0.5, stack.peek(), 0.00001);
        stack.push(0.0);
        div.exec(stack, null);
        Assert.assertEquals(0, stack.peek(), 0.00001);
    }
    @Test
    public void DivException()
    {
        Assert.assertThrows(EmptyStackException.class, () -> { div.exec(stack, null); });
        stack.push(0.0);
        Assert.assertThrows(EmptyStackException.class, () -> { div.exec(stack, null); });
        stack.push(10.0);
        Assert.assertThrows(ArithmeticException.class, () -> { div.exec(stack, null); });
    }
}