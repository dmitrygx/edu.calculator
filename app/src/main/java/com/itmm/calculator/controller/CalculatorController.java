package com.itmm.calculator.controller;

import java.util.Stack;
import com.itmm.calculator.model.CalculatorModel;

/**
 * Created by Dmitry on 9/29/2016.
 */

/**
 * CalculatorController Class
 */
public class CalculatorController {

    protected boolean performOperation;
    private CalculatorModel Model;

    /**
     * Constructor for CalculatorController Class
     */
    public CalculatorController() {
        Model = new CalculatorModel();
    }

    /**
     * Pushes operand's value to stack
     * @param operand The operand of expression
     */
    public void pushOperand(String operand) {
        Model.pushToStack(operand);
        performOperation = false;
    }

    /**
     * Pushes operation's value to stack
     * if '=' is specified, the expression's result is computed
     * @param operation The operation of expression
     */
    public double pushOperation(String operation) {
        double tmpResult = 0;

        if (performOperation) {
            Model.popFromStack();
        }

        if (operation.equals("=")) {
            tmpResult = Model.calculate();
            Model.pushToStack(String.valueOf(tmpResult));
        }
        else {
            Stack<String> tmpStack = Model.cloneStack();
            tmpResult = Model.calculate(tmpStack);
            Model.pushToStack(operation);
            performOperation = true;
        }

        return tmpResult;
    }

    /**
     * Removes all elements from stack
     */
    public void reset() {
        Model.removeAllElementsFromStack();
        performOperation = false;
    }

    /**
     * Pushes memory operation's value to stack
     * if 'MR' is specified, the stored value in Memory will be retrieved
     * @param memoryOperation
     * @param number
     * @return
     */
    public double pushMemoryOperation(String memoryOperation, double number) {
        double result = 0;

        if (memoryOperation.equalsIgnoreCase("MR")) {
            result = Model.getMemoryValue();
        }
        else if (memoryOperation.equalsIgnoreCase("M+")) {
            Model.addToMemoryValue(number);
        }
        else if (memoryOperation.equalsIgnoreCase("M-")) {
            Model.subFromMemoryValue(number);
        }

        return result;
    }
}
