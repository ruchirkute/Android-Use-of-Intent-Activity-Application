package com.kute12457.ruchir.activity_to_activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class secondary extends ActionBarActivity {

    EditText editText2, activity_msg_main;
    Button button3;
    String data, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        //To receive data displayed in Main Activity
        activity_msg_main = (EditText)findViewById(R.id.editText2);
        Intent intentObj2 = getIntent();
        text = (String)intentObj2.getSerializableExtra("UserText");
        if (text == null) {
            activity_msg_main.setText("Welcome!");
        }
        else {
            activity_msg_main.setText(text);
        }

        //For sending the data entered in EditText field to Main Activity when the button is clicked
        editText2 = (EditText)findViewById(R.id.editText2);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText2 != null && editText2.getText().length() != 0) {
                    data = editText2.getText().toString();
                }
                else {
                    data = "No Data in Secondary Activity!";
                }
                Intent intentObj1 = new Intent(v.getContext(), MainActivity.class);
                intentObj1.putExtra("UserText",data);
                startActivity(intentObj1);
            }
        });
    }
}
