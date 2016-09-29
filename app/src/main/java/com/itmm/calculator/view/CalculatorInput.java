package com.itmm.calculator.view;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

import com.itmm.calculator.R;

import java.util.ArrayList;

/**
 * Created by Dmitry on 9/29/2016.
 */

/**
 * Class for reading changes from TextViews from Activity
 */
public class CalculatorInput {

    private ArrayList<Button> OperandsButtons;
    private ArrayList<Button> OperatesButtons;
    private ArrayList<Button> MemoryButtons;

    private CalculatorInput.InputHappend Delagete;

    /**
     * Constructor for CalculatorInput class
     * @param activity The activity with views
     * @param delegate The Delegate interface which has an definition of methods
     */
    public CalculatorInput(Activity activity, CalculatorInput.InputHappend delegate) {
        Delagete = delegate;
        OperandsButtons = new ArrayList<Button>();
        OperatesButtons = new ArrayList<Button>();
        MemoryButtons = new ArrayList<Button>();

        setUIComponent(activity);
    }

    /**
     * Set UI Components (Buttons) for activity
     * @param activity The activity with views
     */
    private void setUIComponent(Activity activity) {
        Resources tmpRes = activity.getResources();

        for (int i = 0; i < 10; i++) {
            int tmpOperandId = tmpRes.getIdentifier("btn" + i, "id", activity.getPackageName());
            OperandsButtons.add((Button) activity.findViewById(tmpOperandId));
        }
        OperandsButtons.add((Button) activity.findViewById(R.id.btnDecimal));

        OperatesButtons.add((Button) activity.findViewById(R.id.btnClear));
        OperatesButtons.add((Button) activity.findViewById(R.id.btnEquals));
        OperatesButtons.add((Button) activity.findViewById(R.id.btnAdd));
        OperatesButtons.add((Button) activity.findViewById(R.id.btnSubtract));
        OperatesButtons.add((Button) activity.findViewById(R.id.btnMultiply));
        OperatesButtons.add((Button) activity.findViewById(R.id.btnDivide));

        MemoryButtons.add((Button) activity.findViewById(R.id.btnMplus));
        MemoryButtons.add((Button) activity.findViewById(R.id.btnMminus));
        MemoryButtons.add((Button) activity.findViewById(R.id.btnMR));

        for (Button btn : OperandsButtons) {
            btn.setOnClickListener(onClickOperand);
        }

        for (Button btn : OperatesButtons) {
            btn.setOnClickListener(onClickOperation);
        }

        for (Button btn : MemoryButtons) {
            btn.setOnClickListener(onClickMemory);
        }
    }

    /**
     * Listener for Operand Buttons in MainActivity
     */
    private Button.OnClickListener onClickOperand = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button tmpClickButton = (Button) v;
            String tmpText = tmpClickButton.getText().toString();
            Delagete.operandIn(tmpText);
        }
    };

    /**
     * Listener for Operation Buttons in MainActivity
     */
    private Button.OnClickListener onClickOperation = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button tmpClickButton = (Button) v;
            String tmpText = tmpClickButton.getText().toString();
            Delagete.operationIn(tmpText);
        }
    };

    /**
     * Listener for Memory Operation Buttons in MainActivity
     */
    private Button.OnClickListener onClickMemory = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button tmpClickButton = (Button) v;
            String tmpText = tmpClickButton.getText().toString();
            Delagete.memoryOperationIn(tmpText);
        }
    };

    /**
     * Interface with predefined methods as a actions for listener
     */
    public interface InputHappend {
        // When user input operand, notify which operand by input.
        void operandIn(String operand);
        // When user input operation, notify which operate by input.
        void operationIn(String operation);
        // When user input memory operation, notify which operate by input.
        void memoryOperationIn(String memoryOperation);
    }
}
