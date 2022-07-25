package com.example.quickstart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nifcloud.mbaas.core.NCMB;
import com.nifcloud.mbaas.core.NCMB;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBObject;
import com.nifcloud.mbaas.core.DoneCallback;

public class MainActivity extends AppCompatActivity {
final String APP_KEY = "2bfb444423219ff54256bbe41ff270c5d8c3e81eaa3121c18603363e99b0b673";
final String CLIENT_KEY = "2e0167555ae06b73a73a8b2ef1ea9614d566b17cb7c0d191da80797221088bf2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //define TextView component
        final TextView greetTextView = (TextView) findViewById(R.id.greet_Text);

        //init the android SDK
        NCMB.initialize(this.getApplicationContext(),APP_KEY,CLIENT_KEY);

        //creat "TestClass" as NCMB object
        NCMBObject obj = new NCMBObject("TestClass");
       final String message = "Hello, NCMB!";
        // Set the value of the object
        try {
            obj.put("message", message);
        } catch (NCMBException e) {
            e.printStackTrace();
        }
        // Register with data store
        obj.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if(e != null){
                    //What to do if saving fails
                    greetTextView.setText("Saving failed");

                }else {
                    //Processing when saving is successful
                    greetTextView.setText(message);

                }
            }
        });
    }
}