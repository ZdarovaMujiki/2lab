package com.company.tests;
import com.company.operations.Operation;
import com.company.operations.Pop;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class PopTest
{
    Operation pop = new Pop();
    Stack<Double> stack = new Stack<>();

    @Test
    public void popExec()
    {
        int testAmount = 5;
        for (int i = 0; i < testAmount; i++)
        {
            stack.push((double) i);
        }
        for (int i = 0; i < testAmount; i++)
        {
            Assert.assertEquals(stack.peek(), testAmount - i - 1, 0.00001);
            Assert.assertEquals(testAmount - i - 1, stack.peek(), 0.00001);
            pop.exec(stack, null);
        }
        stack.push(3.4);
        stack.push(5.0);
        pop.exec(stack, null);
        Assert.assertEquals(3.4 ,stack.peek(), 0.00001);
    }

    @Test
    public void popException()
    {
        stack.push(5.0);
        pop.exec(stack, null);
        Assert.assertThrows(EmptyStackException.class, () -> { pop.exec(stack, null); });
    }
}