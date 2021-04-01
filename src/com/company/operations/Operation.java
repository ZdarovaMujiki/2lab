package com.company.operations;

import com.company.Main;

import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Logger;

public interface Operation
{
    Logger logger = Logger.getLogger(Main.class.getName());
    void exec(Stack<Double> stack, HashMap<String, Double> map);
}

