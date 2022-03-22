package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.inputNum);

        convert = (Button) findViewById(R.id.button);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.button:
                        RadioButton btnC = (RadioButton) findViewById(R.id.radioButton);
                        RadioButton btnF = (RadioButton) findViewById(R.id.radioButton2);

                        if (text.getText().length() == 0){
                            Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                            return;
                        }

                        float input = Float.parseFloat(text.getText().toString());

                        if (btnC.isChecked()){
                            text.setText(String.valueOf(FtoC(input)));
                            btnC.setChecked(false);
                            btnF.setChecked(true);
                        }
                        else{
                            text.setText(String.valueOf(CtoF(input)));
                            btnC.setChecked(true);
                            btnF.setChecked(false);
                        }
                        break;
                }
            }
        });
    }

    public static float FtoC(float f){
        return ((f - 32) * 5 / 9);
    }

    public static float CtoF(float c){
        return ((c * 9) / 5) + 32;
    }
}