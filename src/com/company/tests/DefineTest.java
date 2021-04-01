package com.company.tests;

import com.company.operations.Define;
import com.company.operations.Operation;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class DefineTest
{
    Operation define;
    Stack<Double> stack = new Stack<>();

    @Test
    public void DefineExec()
    {
        define = new Define("test", "3.5);
    }
}