package com.example.intentdemo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ConstraintLayout constraintLayout;
    private Spinner spinner;

    private int REQUEST_CODE = 1;
    public static int RESPONSE_CODE = 1;

    private ArrayList<String> strArray;
    private ArrayAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        constraintLayout = findViewById(R.id.layoutId);
        spinner = findViewById(R.id.spinner);
        strArray = new ArrayList<>();
        Adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strArray) {
        };

        final Intent i = new Intent(this, Activity2.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(i,1);
            }
        });

        strArray.add("one");
        strArray.add("Blue");
        strArray.add("C");

        spinner.setAdapter(Adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESPONSE_CODE){
                int imgId = data.getExtras().getInt("imgId");

                constraintLayout.setBackground(getDrawable(imgId));
            }
        }
    }
}
