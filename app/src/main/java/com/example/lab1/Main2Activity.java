package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    Button lab1button;
    EditText editText;
    Integer firstValue;
    Integer secondValue;
    String operation;
    final String TAG = "States";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lab1button = (Button) findViewById(R.id.GoToLab1b);
        editText = (EditText) findViewById(R.id.editText1);

        Log.d(TAG, "Main2Activity: onCreate()");

    }

    public void GoToLab3(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        if(!editText.getText().toString().equals("")){
            intent.putExtra("name",editText.getText().toString());
        }else{
            intent.putExtra("name","Зачение калькулятора пусто");
        }
        startActivity(intent);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Main2Activity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Main2Activity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Main2Activity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Main2Activity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Main2Activity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Main2Activity: onDestroy()");
    }

    public void buttonClick(View view) {
        Button button = (Button) view;
        switch (button.getText().toString()) {
            case "C":
                firstValue = null;
                secondValue = null;
                operation = null;
                editText.setText("");
                break;
            case "<-":
                if (editText.getText().toString().length() > 0) {
                    if (this.secondValue == null) {
                        if (editText.getText().toString().length() == 1) {
                            firstValue = null;
                            editText.setText("");
                        } else {
                            firstValue = Integer.valueOf(editText.getText().toString().substring(0, editText.getText().toString().length() - 1));
                            editText.setText(editText.getText().toString().substring(0, editText.getText().toString().length() - 1));
                        }
                    } else {
                        if (secondValue.toString().length() == 1) {
                            secondValue = null;
                            editText.setText(editText.getText().toString().substring(0, editText.getText().toString().length() - 1));
                        } else {
                            secondValue = Integer.valueOf(secondValue.toString().substring(0, secondValue.toString().length() - 1));
                            editText.setText(editText.getText().toString().substring(0, editText.getText().toString().length() - 1));
                        }
                    }
                }
                break;
            case "+":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "+";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "-":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "-";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "*":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "*";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "/":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "/";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "=":
                switch (operation) {
                    case "+":
                        editText.setText(String.valueOf((firstValue + secondValue)));
                        break;
                    case "-":
                        editText.setText(String.valueOf((firstValue - secondValue)));
                        break;
                    case "*":
                        editText.setText(String.valueOf((firstValue * secondValue)));
                        break;
                    case "/":
                        editText.setText(String.valueOf(((double) firstValue / (double) secondValue)));
                        break;
                    default:
                        break;
                }
                firstValue = null;
                secondValue = null;
                operation = null;
                break;
            default:
                if (operation != null) {
                    if (secondValue != null)
                        secondValue = Integer.valueOf((String.valueOf(secondValue) + button.getText().toString()));
                    else
                        secondValue = Integer.valueOf(button.getText().toString());
                }
                editText.setText(editText.getText().toString() + button.getText());
                break;
        }
    }
}
