package com.itmm.calculator.model;

/**
 * Created by Dmitry on 9/29/2016.
 */

/**
 * ICalculatorBasic interface
 */
public interface ICalculatorMemory {

    public void addToMemoryValue(double value);

    public void subFromMemoryValue(double value);

    public double getMemoryValue();

}
