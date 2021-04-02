package com.company.tests;

import com.company.operations.Operation;
import com.company.operations.Print;
import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class PrintTest
{
    Operation print = new Print();
    Stack<Double> stack = new Stack<>();
    @Test
    public void PlusExec()
    {
        stack.push(10.0);
        print.exec(stack, null);

        stack.push(-20.0);
        print.exec(stack, null);
    }
    @Test
    public void PrintException()
    {
        Assert.assertThrows(EmptyStackException.class, () -> { print.exec(stack, null); });
    }
}