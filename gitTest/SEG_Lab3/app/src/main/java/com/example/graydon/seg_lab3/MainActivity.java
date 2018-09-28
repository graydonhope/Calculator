package com.example.graydon.seg_lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private enum Operator  {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator operator = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Called everytime a button is pressed
    public void onClickNumericalButton(View view){
        int buttonID = view.getId();
        TextView text = (TextView)findViewById(R.id.resultEdit);
        switch(buttonID){
            case R.id.btn00:
                text.setText(text.getText() + "0");
                break;
            case R.id.btn01:
                text.setText(text.getText() + "1");
                break;
            case R.id.btn02:
                text.setText(text.getText() + "2");
                break;
            case R.id.btn03:
                text.setText(text.getText() + "3");
                break;
            case R.id.btn04:
                text.setText(text.getText() + "4");
                break;
            case R.id.btn05:
                text.setText(text.getText() + "5");
                break;
            case R.id.btn06:
                text.setText(text.getText() + "6");
                break;
            case R.id.btn07:
                text.setText(text.getText() + "7");
                break;
            case R.id.btn08:
                text.setText(text.getText() + "8");
                break;
            case R.id.btn09:
                text.setText(text.getText() + "9");
                break;
            default:
                text.setText("Error");
                Log.d(TAG, "onClickNumericalButton: Error, unknown button pressed");
        }
    }

    public void addClick(View view){
        operator = Operator.add;
        EditText text = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }

    public void minusClick(View view){
        operator = Operator.minus;
        EditText text = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }

    public void divideClick(View view){
        operator = Operator.divide;
        EditText text = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }

    public void multiplyClick(View view){
        operator = Operator.multiply;
        EditText text = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }

    public void clearText(View view){
        EditText text = (EditText)findViewById(R.id.resultEdit);
        text.setText("");
    }

    public void dotClick(View view){
        EditText text = (EditText)findViewById(R.id.resultEdit);
        text.setText(text.getText() + ".");
    }

    public void buttonResultClick(View view){
        if(operator != Operator.none){
            EditText text = (EditText)findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(text.getText().toString());
            double result = 0;
            if(operator == Operator.add){
                result = data1 + data2;
            }
            else if(operator == Operator.minus){
                result = data1 - data2;
            }
            else if(operator == Operator.divide){
                result = data1 / data2;
            }
            else if(operator == Operator.multiply){
                result = data1 * data2;
            }
            operator = Operator.none;
            data1 = result;
            if((result - (int) result) != 0){
                text.setText(String.valueOf(result));
            }
            else{
                text.setText(String.valueOf((int)result));
            }
        }
    }
}
