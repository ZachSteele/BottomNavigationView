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
public class KinematicsFragment extends Fragment {

    public KinematicsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_kinematics, container, false);
        Button calculateBtn = view.findViewById(R.id.calculateBtn);
        //Button explainBtn = view.findViewById(R.id.explainBtn);
        final DecimalFormat numberFormat = new DecimalFormat("#.00");
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creates text box variables
                TextView resultTextView = view.findViewById(R.id.resultTextView);
                EditText finalVEditText = view.findViewById(R.id.finalVEditText);
                EditText initialVEditText = view.findViewById(R.id.initialVEditText2);
                EditText accelerationNumEditText = view.findViewById(R.id.accelerationEditText);
                EditText timeNumEditText = view.findViewById(R.id.timeEditText);
                EditText deltaDistanceNumEditText = view.findViewById(R.id.deltaDistanceEditText);
                //gets the value from the text box
                String finalVNumCheck = finalVEditText.getText().toString();
                String initialVCheck = initialVEditText.getText().toString();
                String accNumCheck = accelerationNumEditText.getText().toString();
                String timeNumCheck = timeNumEditText.getText().toString();
                String deltaNumCheck = deltaDistanceNumEditText.getText().toString();
                //Variables in Integer form
                double finalVNum;
                double initialVNum = 0;
                double accNum;
                double timeNum;
                double deltaNum;
                boolean b = true;

                String vfColor = "<font color='#000000'>Final Velocity = </font>";
                String viColor = "<font color='#000000'>Initial Velocity = </font>";
                String accColor = "<font color='#000000'>Acceleration = </font>";
                String timeColor = "<font color='#000000'>Time = </font>";
                String deltaDColor = "<font color='#000000'>Delta Distance = </font>";
                //d=??, Vf=??

                if (finalVNumCheck.isEmpty() && deltaNumCheck.isEmpty() && !timeNumCheck.isEmpty() && !initialVCheck.isEmpty() && !accNumCheck.isEmpty()) {
                    initialVNum = Double.parseDouble(initialVCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    //vf=vi+aT
                    //X=viT + .5a(t^2)
                    finalVNum = (initialVNum + (accNum * Math.abs(timeNum)));
                    deltaNum = (initialVNum * Math.abs(timeNum)) + ((.5 * accNum) * (Math.abs(timeNum) * Math.abs(timeNum)));
                    resultTextView.setText(Html.fromHtml(vfColor + numberFormat.format(finalVNum) + "<br>" + deltaDColor + numberFormat.format(deltaNum)));
                    return;
                }
                //d=??, a=??
                if (deltaNumCheck.isEmpty() && accNumCheck.equals("") && !timeNumCheck.isEmpty() && !initialVCheck.isEmpty() && !finalVNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    initialVNum = Double.parseDouble(initialVCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    //x=.5(vi + vf)t
                    //a=(vf^2 - vi^2)/(2*deltaX)
                    deltaNum = .5 * (initialVNum + finalVNum) * Math.abs(timeNum);
                    accNum = ((finalVNum * finalVNum) - (initialVNum * initialVNum)) / (2 * deltaNum);
                    resultTextView.setText(Html.fromHtml(deltaDColor + numberFormat.format(deltaNum) + "<br>" + accColor + numberFormat.format(accNum)));
                    return;
                }
                //d=??, vi=??
                if (deltaNumCheck.isEmpty() && initialVCheck.equals("") && !timeNumCheck.isEmpty() && !finalVNumCheck.isEmpty() && !accNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    //d = vi*t + (.5*a*t^2)
                    deltaNum = (initialVNum * Math.abs(timeNum)) + ((.5 * Math.abs(accNum)) * (Math.abs(timeNum) * Math.abs(timeNum)));
                    //vi=sqrt(2aX)-Vf
                    initialVNum = Math.sqrt((2.0 * Math.abs(accNum) * deltaNum)) - finalVNum;
                    resultTextView.setText(Html.fromHtml(deltaDColor + numberFormat.format(deltaNum) + "<br>" + viColor + numberFormat.format(initialVNum)));
                    return;
                }
                //vf=??, a=??
                if (finalVNumCheck.equals("") && accNumCheck.equals("") && !timeNumCheck.isEmpty() && !initialVCheck.isEmpty() && !deltaNumCheck.isEmpty()) {
                    initialVNum = Double.parseDouble(initialVCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    deltaNum = Double.parseDouble(deltaNumCheck);
                    //vf = (2d/t) - vi
                    //a=(vf^2 - vi^2)/(2*deltaX)
                    finalVNum = ((2 * deltaNum) / Math.abs(timeNum)) - initialVNum;
                    accNum = ((finalVNum * finalVNum) - (initialVNum * initialVNum)) / (2 * deltaNum);
                    resultTextView.setText(Html.fromHtml(vfColor + numberFormat.format(finalVNum) + "<br>" + accColor + numberFormat.format(accNum)));
                    return;
                }
                //vf=??, t=??
                if (finalVNumCheck.equals("") && timeNumCheck.equals("") && !deltaNumCheck.isEmpty() && !initialVCheck.isEmpty() && !accNumCheck.isEmpty()) {

                    initialVNum = Double.parseDouble(initialVCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    deltaNum = Double.parseDouble(deltaNumCheck);
                    //vf = sqrt(vi^2 + 2 * acc * delta x)
                    finalVNum = Math.sqrt((initialVNum * initialVNum) + (2 * accNum * deltaNum));
                    //t=(vf-vi)/a
                    timeNum = (finalVNum - initialVNum) / accNum;
                    resultTextView.setText(Html.fromHtml(vfColor + numberFormat.format(finalVNum) + "<br>" + timeColor + numberFormat.format(Math.abs(timeNum))));

                    // resultTextView.setText("final v = " + numberFormat.format(finalVNum) + "\ntime = " + numberFormat.format(Math.abs(timeNum)));
                    return;
                }
                //d=??
                if (deltaNumCheck.isEmpty() && !timeNumCheck.isEmpty() && !initialVCheck.isEmpty() && !accNumCheck.isEmpty() && !finalVNumCheck.isEmpty()) {
                    initialVNum = Double.parseDouble(initialVCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    //d = vi*t + (.5*a*t^2)
                    deltaNum = (initialVNum * Math.abs(timeNum)) + ((.5 * accNum) * (Math.abs(timeNum) * Math.abs(timeNum)));
                    resultTextView.setText(Html.fromHtml(deltaDColor + numberFormat.format(deltaNum)));
                    return;
                }
                //t=??, d=??
                if (deltaNumCheck.isEmpty() && timeNumCheck.equals("") && !finalVNumCheck.isEmpty() && !initialVCheck.isEmpty() && !accNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    initialVNum = Double.parseDouble(initialVCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    //t=(vf-vi)/a
                    timeNum = (finalVNum - initialVNum) / accNum;
                    //d = vi*t + (.5*a*t^2)
                    deltaNum = (initialVNum * Math.abs(timeNum)) + ((.5 * accNum) * (Math.abs(timeNum) * Math.abs(timeNum)));
                    resultTextView.setText(Html.fromHtml(timeColor + numberFormat.format(Math.abs(timeNum)) + "<br>" + deltaDColor + numberFormat.format(deltaNum)));
                    return;
                }
                //vi=??, t=??
                if (initialVCheck.equals("") && timeNumCheck.equals("") && !finalVNumCheck.isEmpty() && !deltaNumCheck.isEmpty() && !accNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    deltaNum = Double.parseDouble(deltaNumCheck);
                    //vi=sqrt(2aX)-Vf
                    //t=(vf-vi)/a
                    initialVNum = Math.sqrt((2.0 * Math.abs(accNum) * deltaNum)) - finalVNum;
                    timeNum = (finalVNum - initialVNum) / accNum;
                    resultTextView.setText(Html.fromHtml(viColor + numberFormat.format(initialVNum) + "<br>" + timeColor + numberFormat.format(Math.abs(timeNum))));
                    return;
                }
                //a=??, t=??
                if (accNumCheck.equals("") && timeNumCheck.equals("") && !deltaNumCheck.isEmpty() && !initialVCheck.isEmpty() && !finalVNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    initialVNum = Double.parseDouble(initialVCheck);
                    deltaNum = Double.parseDouble(deltaNumCheck);
                    //a=(vf^2 - vi^2)/(2*deltaX)
                    //t=(vf-vi)/a
                    accNum = ((finalVNum * finalVNum) - (initialVNum * initialVNum)) / (2 * deltaNum);
                    timeNum = (finalVNum - initialVNum) / accNum;
                    resultTextView.setText(Html.fromHtml(accColor + numberFormat.format(accNum) + "<br>" + timeColor +numberFormat.format(Math.abs(timeNum))));
                    return;
                }

                //a=??
                if (accNumCheck.isEmpty() && !timeNumCheck.isEmpty() && !initialVCheck.isEmpty() && !deltaNumCheck.isEmpty() && !finalVNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    initialVNum = Double.parseDouble(initialVCheck);
                    deltaNum = Double.parseDouble(deltaNumCheck);
                    //a=(vf^2 - vi^2)/(2*deltaX)
                    accNum = ((finalVNum * finalVNum) - (initialVNum * initialVNum)) / (2 * deltaNum);
                    resultTextView.setText(Html.fromHtml(accColor + numberFormat.format(accNum)));
                    return;
                }
                //t=??
                if (timeNumCheck.isEmpty() && !deltaNumCheck.isEmpty() && !initialVCheck.isEmpty() && !accNumCheck.isEmpty() && !finalVNumCheck.isEmpty()) {
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    initialVNum = Double.parseDouble(initialVCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    timeNum = (finalVNum - initialVNum) / accNum;
                    resultTextView.setText(Html.fromHtml(timeColor + numberFormat.format(Math.abs(timeNum))));
                    return;
                }
                //Vi=??
                if (initialVCheck.isEmpty() && !timeNumCheck.isEmpty() && !deltaNumCheck.isEmpty() && !accNumCheck.isEmpty() && !finalVNumCheck.isEmpty()) {
                    //given values are put into decimal form
                    finalVNum = Double.parseDouble(finalVNumCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    deltaNum = Double.parseDouble(deltaNumCheck);
                    initialVNum = Math.sqrt((2.0 * Math.abs(accNum) * deltaNum)) - finalVNum;
                    //sets color and formats output
                    resultTextView.setText(Html.fromHtml(viColor + numberFormat.format(initialVNum)));
                    return;
                }
                //vf=??
                if (finalVNumCheck.isEmpty() && !timeNumCheck.isEmpty() && !initialVCheck.isEmpty() && !accNumCheck.isEmpty() && !deltaNumCheck.isEmpty()) {
                    //given values are put into decimal form
                    initialVNum = Double.parseDouble(initialVCheck);
                    accNum = Double.parseDouble(accNumCheck);
                    timeNum = Double.parseDouble(timeNumCheck);
                    finalVNum = (initialVNum + (accNum * Math.abs(timeNum)));
                    //sets color and formats output
                    resultTextView.setText(Html.fromHtml(vfColor + numberFormat.format(finalVNum)));
                    return;
                }
                //if all other options fail(default output)
                if (b) {
                    resultTextView.setText("This problem is not solvable.");
                }
            }
        });
        //explain option will be added to the calculator in the future
        /*
        explainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //Intent intent = new Intent(KinematicsFragment.this.getActivity(),explainActivity.class);
                    //KinematicsFragment.this.startActivity(intent);
                TextView resultExplainTextView2 = (TextView) view.findViewById(R.id.resultExplainTextView2);
                //resultExplainTextView2.setText("This problem is not solvable.");
            explainFragment explainFragment = new explainFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", "webtestin");
            explainFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.main_frame, explainFragment).commit();
            //explainFragment.getView().findViewById();
            }
        });
        */
        return view;
    }
}
