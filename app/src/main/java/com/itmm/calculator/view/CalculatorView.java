package com.itmm.calculator.view;

import android.app.Activity;
import com.itmm.calculator.view.CalculatorInput.InputHappend;


/**
 * Created by Dmitry on 9/29/2016.
 */

/**
 * Class that contains both objects
 */
public class CalculatorView {

    public CalculatorInput InputView;
    public CalculatorOutput OutputView;

    /**
     * Constructor for CalculatorView Class
     * @param activity
     * @param delegate
     */
    public CalculatorView(Activity activity, InputHappend delegate) {
        InputView = new CalculatorInput(activity, delegate);
        OutputView = new CalculatorOutput(activity);
    }

}
