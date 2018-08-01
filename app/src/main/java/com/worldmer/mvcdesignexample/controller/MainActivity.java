package com.worldmer.mvcdesignexample.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.worldmer.mvcdesignexample.R;
import com.worldmer.mvcdesignexample.model.MathUtil;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    TextView tvAnswer;
    MathUtil mathUtil;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        mathUtil = new MathUtil();
    }

    public void bindView() {
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tvAnswer = (TextView) findViewById(R.id.tvanswer);
    }

    public void getAnswer(View view) {
        Button button = (Button) view;
        if (isValid(edt1) && isValid(edt2)) {
            num1 = Integer.parseInt(edt1.getText().toString());
            num2 = Integer.parseInt(edt2.getText().toString());
            switch (button.getTag().toString()) {
                case "add":
                    tvAnswer.setText(String.valueOf(mathUtil.add(num1, num2)));
                    break;
                case "sub":
                    tvAnswer.setText(String.valueOf(mathUtil.sub(num1, num2)));
                    break;
                case "mul":
                    tvAnswer.setText(String.valueOf(mathUtil.mul(num1, num2)));
                    break;
                case "div":
                    tvAnswer.setText(String.valueOf(mathUtil.div(num1, num2)));
                    break;
                case "mod":
                    tvAnswer.setText(String.valueOf(mathUtil.mod(num1, num2)));
                    break;

            }
        } else {
            tvAnswer.setText("Error");
        }
    }

    public boolean isValid(EditText view) {
        boolean status = false;
        try {
            if (null != view) {
                if (view.getText().toString().trim().length() > 0) {
                    status = true;
                }
            }
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
}