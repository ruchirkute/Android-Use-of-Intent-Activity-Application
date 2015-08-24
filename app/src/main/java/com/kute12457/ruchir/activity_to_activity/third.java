package com.kute12457.ruchir.activity_to_activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class third extends ActionBarActivity {

    Button button4;
    EditText editText3, activity_msg_main;
    String data, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //To receive data displayed in Main Activity
        activity_msg_main = (EditText)findViewById(R.id.editText3);
        Intent intentObj3 = getIntent();
        text = (String)intentObj3.getSerializableExtra("UserText");
        if (text == null) {
            activity_msg_main.setText("Welcome!");
        }
        else {
            activity_msg_main.setText(text);
        }

        //For sending the data entered in EditText field to Main Activity when the button is clicked
        editText3 = (EditText)findViewById(R.id.editText3);
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText3 != null && editText3.getText().length() != 0) {
                    data = editText3.getText().toString();
                }
                else {
                    data = "No Data in Third Activity!";
                }
                Intent intentObj1 = new Intent(v.getContext(), MainActivity.class);
                intentObj1.putExtra("UserText",data);
                startActivity(intentObj1);
            }
        });
    }
}
