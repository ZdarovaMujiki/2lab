package com.company.tests;

import com.company.operations.Operation;
import com.company.operations.Push;
import com.company.operations.Sqrt;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class SqrtTest
{
    Operation sqrt = new Sqrt();
    Stack<Double> stack = new Stack<>();

    @Test
    public void SqrtExec()
    {
        stack.push(4.0);
        sqrt.exec(stack, null);
        Assert.assertEquals(2.0, stack.peek(), 0.00001);
        sqrt.exec(stack, null);
        Assert.assertEquals( Math.sqrt(2.0), stack.peek(), 0.00001);
    }

    @Test
    public void SqrtException()
    {
        Assert.assertThrows(EmptyStackException.class, () -> { sqrt.exec(stack, null); });
    }
}