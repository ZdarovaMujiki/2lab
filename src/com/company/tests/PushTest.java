package com.company.tests;

import com.company.operations.Operation;
import com.company.operations.Push;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class PushTest
{
    private Operation push;
    private Stack<Double> stack = new Stack<>();
    private HashMap<String, Double> map = new HashMap<>();

    @Test
    public void PushExec()
    {
        push = new Push("3.14");
        push.exec(stack, map);
        Assert.assertEquals(3.14, stack.peek(), 0.00001);
    }

    @Test
    public void PushException()
    {
        push = new Push("asd");
        Assert.assertThrows(NumberFormatException.class, () -> push.exec(stack, map));
    }
}