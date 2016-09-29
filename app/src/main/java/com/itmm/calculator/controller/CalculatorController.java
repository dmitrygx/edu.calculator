package com.itmm.calculator.controller;

import java.util.Stack;
import com.itmm.calculator.model.CalculatorModel;

/**
 * Created by Dmitry on 9/29/2016.
 */

public class CalculatorController {

    protected boolean performOperation;
    private CalculatorModel Model;

    public CalculatorController(){
        Model = new CalculatorModel();
    }

    public void pushOperand(String operand) {
        Model.pushToStack(operand);
        performOperation = false;
    }

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

    public void reset() {
        Model.removeAllElementsFromStack();
        performOperation = false;
    }

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
