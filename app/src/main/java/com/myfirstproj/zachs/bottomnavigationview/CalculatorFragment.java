package com.myfirstproj.zachs.bottomnavigationview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {


    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        //when this button is clicked calculate feet to meters
        Button calculatef2m = view.findViewById(R.id.calcBtnF2M);
        final DecimalFormat numberFormat = new DecimalFormat("#.00");
        calculatef2m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultTextViewf2m = view.findViewById(R.id.resultF2M);
                EditText edittextfeet = view.findViewById(R.id.editTextF2M);
                String feetNumCheck = edittextfeet.getText().toString();
                double feetNum;
                //default output
                if (feetNumCheck.equals("")) {
                    resultTextViewf2m.setText("Please input a number");
                    return;
                }
                //the feet to meters calculation
                feetNum = Double.parseDouble(feetNumCheck);
                feetNum = feetNum / 3.28084;
                //formats the number to 2 two decimal places, allows for color change
                resultTextViewf2m.setText(Html.fromHtml(numberFormat.format(feetNum) + " meters"));
            }
        });
        //when this button is clicked calculate meters to feet
        Button calculatem2f = view.findViewById(R.id.calcBtnM2F);
        calculatem2f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultTextViewm2f = view.findViewById(R.id.resultM2F);
                EditText edittextmeters = view.findViewById(R.id.editTextM2F);
                String meterNumCheck = edittextmeters.getText().toString();
                double metersNum;
                //default output
                if (meterNumCheck.equals("")) {
                    resultTextViewm2f.setText("Please input a number");
                    return;
                }
                //the meters to feet calculation
                metersNum = Double.parseDouble(meterNumCheck);
                metersNum = metersNum * 3.28084;
                //formats the number to 2 two decimal places, allows for color change
                resultTextViewm2f.setText(Html.fromHtml(numberFormat.format(metersNum) + " feet"));
            }
        });
        //when this button is clicked calculate meters to feet
        Button calculateh2s = view.findViewById(R.id.calcBtnH2S);
        calculateh2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultTextViewh2s = view.findViewById(R.id.resultH2S);
                EditText edittexth2s = view.findViewById(R.id.editTextH2S);
                String hoursNumCheck = edittexth2s.getText().toString();
                double numh2s;
                //default output
                if (hoursNumCheck.equals("")) {
                    resultTextViewh2s.setText("Please input a number");
                    return;
                }
                //the hours to seconds calculation
                numh2s = Double.parseDouble(hoursNumCheck);
                numh2s = numh2s * 3600;
                //Output stays as whole number
                resultTextViewh2s.setText((int) numh2s + " seconds");
            }
        });
        //when this button is clicked calculate mph to mps
        Button calculatetotal = view.findViewById(R.id.calcBtnFPS2MPS);
        calculatetotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultTextViewtotal = view.findViewById(R.id.resultFPS2MPS);
                EditText edittextTotal = view.findViewById(R.id.editTextFPS2MPS);
                String numCheckTotal = edittextTotal.getText().toString();
                double numTotal;
                //default output
                if (numCheckTotal.equals("")) {
                    resultTextViewtotal.setText("Please input a number");
                    return;
                }
                numTotal = Double.parseDouble(numCheckTotal);
                //mile per hour to meter per second
                numTotal = numTotal / 2.23694;
                //formats the number to 2 two decimal places, allows for color change
                resultTextViewtotal.setText(Html.fromHtml(numberFormat.format(numTotal) + " m/s"));
            }
        });
        return view;
    }
}
