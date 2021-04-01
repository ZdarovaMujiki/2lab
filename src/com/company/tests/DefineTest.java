package com.company.tests;

import com.company.operations.Define;
import com.company.operations.Operation;
import com.company.operations.Pop;
import com.company.operations.Push;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class DefineTest
{
    Operation define;
    Operation push;
    Stack<Double> stack = new Stack<>();

    @Test
    public void DefineExec()
    {
        define = new Define("test", "3.5");

//        pop.exec();
    }
}