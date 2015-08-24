package com.kute12457.ruchir.activity_to_activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    EditText activity_msg, editText;
        String text, data;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        //To receive data from Secondary and Third Activity
        activity_msg = (EditText)findViewById(R.id.editText);
            Intent intentObj1 = getIntent();
            text = (String)intentObj1.getSerializableExtra("UserText");
        if (text == null) {
            activity_msg.setText("Welcome!");
        }
        else {
            activity_msg.setText(text);
        }

        //For sending the data from Main Activity to Secondary Activity when the first button is clicked
        editText = (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText != null && editText.getText().length() != 0) {
                    data = editText.getText().toString();
                }
                else {
                    data = "No Data in Main Activity!";
                }
                Intent intentObj2 = new Intent(v.getContext(), secondary.class);
                intentObj2.putExtra("UserText",data);
                startActivity(intentObj2);
            }
        });

        //For sending the data from Main Activity to Third Activity when the second button is clicked
        Button button2 = (Button)findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editText != null && editText.getText().length() != 0) {
                        data = editText.getText().toString();
                    }
                    else {
                        data = "No Data in Main Activity!";
                    }
                    Intent intentObj3 = new Intent(v.getContext(), third.class);
                    intentObj3.putExtra("UserText",data);
                    startActivity(intentObj3);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
