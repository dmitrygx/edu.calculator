package com.itmm.calculator.view;

import com.itmm.calculator.R;
import android.app.Activity;
import android.widget.TextView;

/**
 * Created by Dmitry on 9/29/2016.
 */

/**
 * Class for writing changes to TextViews in Activity
 */
public class CalculatorOutput {

    private TextView OutputTextView;

    /**
     * Constructor for CalculatorOutput Class
     * Initializes TextView by TextView from activity
     * @param activity The Activity
     */
    public CalculatorOutput(Activity activity) {
        OutputTextView = (TextView) activity.findViewById(R.id.txtSolution);
    }

    /**
     * Write text 'str' to TextView from Activity that has been specified
     * through Constructor
     * @param activity The Activity
     */
    public void setOutputString(String str) {
        OutputTextView.setText(str);
    }
}
