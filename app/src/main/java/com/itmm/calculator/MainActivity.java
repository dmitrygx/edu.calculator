package com.itmm.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itmm.calculator.controller.CalculatorController;
import com.itmm.calculator.view.CalculatorInput.InputHappend;
import com.itmm.calculator.view.CalculatorView;

public class MainActivity extends AppCompatActivity implements InputHappend {

    CalculatorView View;
    CalculatorController Controller;
    private String Number = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        Controller = new CalculatorController();
        View = new CalculatorView(this, this);
    }

    @Override
    public void operandIn(String operand) {
        Number = Number.equals("0") ? operand : Number + operand;
        View.OutputView.setOutputString(Number);
    }

    @Override
    public void operationIn(String operation) {
        if (operation.equalsIgnoreCase("C")) {
            Controller.reset();
            Number = "0";
            View.OutputView.setOutputString(Number);
            return;
        }
        if (!Number.equals("0")) {
            Controller.pushOperand(Number);
        }

        double tmpResult = Controller.pushOperation(operation);

        if (tmpResult % 1d == 0d) {
            int tmp = Double.valueOf(tmpResult).intValue();
            View.OutputView.setOutputString(String.valueOf(tmp));
        }
        else {
            View.OutputView.setOutputString(String.valueOf(tmpResult));
        }
        Number = "0";
    }

    @Override
    public void memoryOperationIn(String memoryOperation) {
        double tmpResult = Controller.pushMemoryOperation(memoryOperation, Double.valueOf(Number));

        if (memoryOperation.equalsIgnoreCase("MR"))
        {
            if (tmpResult % 1d == 0d) {
                int tmp = Double.valueOf(tmpResult).intValue();
                View.OutputView.setOutputString(String.valueOf(tmp));
            }
            else {
                View.OutputView.setOutputString(String.valueOf(tmpResult));
            }
            Number = String.valueOf(tmpResult);
        }
    }
}
