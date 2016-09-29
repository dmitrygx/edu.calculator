package com.itmm.calculator.view;

import com.itmm.calculator.R;
import android.app.Activity;
import android.widget.TextView;

/**
 * Created by Dmitry on 9/29/2016.
 */

public class CalculatorOutput {

    private TextView OutputTextView;

    public CalculatorOutput(Activity activity) {
        OutputTextView = (TextView) activity.findViewById(R.id.txtSolution);
    }

    public void setOutputString(String str) {
        OutputTextView.setText(str);
    }
}
