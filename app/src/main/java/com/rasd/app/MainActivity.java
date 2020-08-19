package com.rasd.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.rasd.bsjson.BSJson;
import com.rasd.bsjson.BSObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BSJson.initializing()
                .withSecret("6d1fa25b-d168-489f-96cf-d657d8fd207c")
                .enableLogging(true);
        load();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
    }

    private void load(){
        BSObject bsObject = new BSObject();
        bsObject.addProperty("method_name", "settings");
        new BSJson.Builder(this)
                .setObject(bsObject.getProperty())
                .setServer("http://192.168.1.50/codeigniter2/api")
                .setMethod(BSJson.METHOD_POST)
                .load();
    }
}
