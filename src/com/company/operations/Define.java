package com.company.operations;

import com.company.Main;

import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;

public class Define implements Operation
{
    String word;
    Double digit;

    public Define(String word, String a)
    {
        if
        this.word = word;
        digit = Double.valueOf(a);
        logger.log(Level.INFO, word + " = " + digit + " defined");
    }

    @Override
    public void exec(Stack<Double> stack, HashMap<String, Double> map) {
        map.put(word, digit);
    }

    public static boolean isNumeric(String str)
    {
        if (str == null)
        {
            return false;
        }
        try
        {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}