package com.company.tests;

import com.company.operations.Minus;
import com.company.operations.Mul;
import com.company.operations.Operation;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.*;

public class MulTest
{
    Operation mul = new Mul();
    Stack<Double> stack = new Stack<>();
    @Test
    public void MulExec()
    {
        stack.push(10.0);
        stack.push(5.0);
        mul.exec(stack, null);
        Assert.assertEquals(50.0, stack.peek(), 0.00001);
        stack.push(0.5);
        mul.exec(stack, null);
        Assert.assertEquals(25.0, stack.peek(), 0.00001);
    }
    @Test
    public void MulException()
    {
        Assert.assertThrows(EmptyStackException.class, () -> { mul.exec(stack, null); });
        stack.push(0.0);
        Assert.assertThrows(EmptyStackException.class, () -> { mul.exec(stack, null); });
    }
}