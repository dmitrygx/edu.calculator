package com.itmm.calculator.model;

import java.util.Stack;

/**
 * Created by Dmitry on 9/29/2016.
 */

public class CalculatorModel implements ICalculatorBasic, ICalculatorMemory {

    protected static Stack<String> CompStack;

    protected double MemoryValue;

    public CalculatorModel() {
        CompStack = new Stack<>();
        MemoryValue = 0;
    }

    /**
     * It adds value to current value in Memory
     * @param value
     */
    public void addToMemoryValue(double value) {
        MemoryValue += value;
    }

    /**
     * It subtracts value from current value in Memory
     * @param value
     */
    public void subFromMemoryValue(double value) {
        MemoryValue -= value;
    }

    /**
     * It current value from Memory in a String representation
     * @return the String representation of Memory value
     */
    public double getMemoryValue() {
        return MemoryValue;
    }

    /**
     * Adds to value to another value and returns the result
     * @return the result of addition
     */
    public double operationAddition(double operand1, double operand2) {
        return operand1 + operand2;
    }

    /**
     * Subtract one value from another values and return sthe result
     * @return the result of subtraction
     */
    public double operationSubtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    /**
     * Multiply one value to another value and returns the result
     * @return the result of multiplication
     */
    public double operationMultiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    /**
     * Division one value from another value and returns the result
     * @return the result of division
     */
    public double operationDivision(double operand1, double operand2) {
        return operand1 / operand2;
    }

    /**
     * Calculates result of mathematical expression that has been
     * stored in Current Stack or just retrieves and returns Operand
     * @return the result of calculation or value from Current Stack
     */
    public static double calculate() {
        double tmpResult = 0;
        double tmpOperand = Double.valueOf(CompStack.pop());

        if(CompStack.isEmpty()) {
            return tmpOperand;
        }

        String tmpOperation = CompStack.pop();

        if (tmpOperation.equals("+")) {
            tmpResult = calculate() + tmpOperand;
        } else if( tmpOperation.equals("-")) {
            tmpResult = calculate() - tmpOperand;
        } else if (tmpOperation.equals("X")) {
            tmpResult = calculate() * tmpOperand;
        } else if (tmpOperation.equals("/")) {
            tmpResult = calculate() / tmpOperand;
        }
        return tmpResult;
    }

    /**
     * Calculates result of mathematical expression that has been
     * stored in Stack or just retrieves and returns Operand
     * @param stack The Stack
     * @return the result of calculation or value from Stack
     */
    public static double calculate(Stack<String> stack) {
        double tmpResult = 0;
        double tmpOperand = Double.valueOf(stack.pop());

        if(stack.isEmpty()) {
            return tmpOperand;
        }

        String tmpOperation = stack.pop();

        if (tmpOperation.equals("+")) {
            tmpResult = calculate() + tmpOperand;
        } else if( tmpOperation.equals("-")) {
            tmpResult = calculate() - tmpOperand;
        } else if (tmpOperation.equals("X")) {
            tmpResult = calculate() * tmpOperand;
        } else if (tmpOperation.equals("/")) {
            tmpResult = calculate() / tmpOperand;
        }

        return tmpResult;
    }

    /**
     * Pushes String value (operand or operation) to CompStack
     * @param item the String value (operand or operation)
     */
    public void pushToStack(String item) {
        CompStack.push(item);
    }

    /**
     * Pops String value (operand or operation) from CompStack
     * @return the String value ()
     */
    public String popFromStack() {
        return CompStack.pop();
    }

    /**
     * Removes all elements (operands and operations) from CompStack
     */
    public void removeAllElementsFromStack() {
        CompStack.removeAllElements();
    }

    /**
     * Clone all elements (operands and operations) from CompStack
     * to new Stack and return new Stack
     * @retun new Stack
     */
    public Stack<String> cloneStack() {
        return (Stack<String>) CompStack.clone();
    }
}
