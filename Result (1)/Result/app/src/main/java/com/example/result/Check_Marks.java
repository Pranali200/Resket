package com.example.result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Check_Marks extends AppCompatActivity {
    FloatingActionButton fb;
    Button button;
    Spinner sp1, sp2;
    String selectedClass, selectedDiv;
    private dbmanager databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__marks);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            //nametext = (TextInputLayout) findViewById(R.id.nametext);
            //contact = (TextInputLayout) findViewById(R.id.contacttext);
            //email = (TextInputLayout) findViewById(R.id.emailtext);
            fb = (FloatingActionButton) findViewById(R.id.fbtn);
            button = (Button) findViewById(R.id.button);
            sp1 = (Spinner) findViewById(R.id.sp1);
            sp2 = (Spinner) findViewById(R.id.sp2);


        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    startActivity(new Intent(getApplicationContext(),fetchdata.class));

                }
            });

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedClass = parent.getItemAtPosition(position).toString();
                    switch (selectedClass) {
                        case "1st Sem":
                            // assigning div item list defined in XML to the div Spinner
                            sp2.setAdapter(new ArrayAdapter<String>(Check_Marks.this,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    getResources().getStringArray(R.array.Sem1)));
                            break;

                        case "2nd Sem":
                            sp2.setAdapter(new ArrayAdapter<String>(Check_Marks.this,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    getResources().getStringArray(R.array.Sem2)));
                            break;

                        case "3rd Sem":
                            // assigning div item list defined in XML to the div Spinner
                            sp2.setAdapter(new ArrayAdapter<String>(Check_Marks.this,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    getResources().getStringArray(R.array.Sem3)));
                            break;

                        case "4th Sem":
                            sp2.setAdapter(new ArrayAdapter<String>(Check_Marks.this,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    getResources().getStringArray(R.array.Sem4)));
                            break;

                        case "5th Sem":
                            // assigning div item list defined in XML to the div Spinner
                            sp2.setAdapter(new ArrayAdapter<String>(Check_Marks.this,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    getResources().getStringArray(R.array.Sem5)));
                            break;

                        case "6th Sem":
                            sp2.setAdapter(new ArrayAdapter<String>(Check_Marks.this,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    getResources().getStringArray(R.array.Sem6)));
                            break;

                    }

                    //set divSpinner Visibility to Visible
                    sp2.setVisibility(View.VISIBLE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // can leave this empty
                }
            });

            // Div Spinner implementing onItemSelectedListener
            sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedDiv = parent.getItemAtPosition(position).toString();

                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                    Toast.makeText(Check_Marks.this, "\n OPTION: \t " + selectedClass +
                            "\n Semester: \t" + selectedDiv, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // can leave this empty
                }

            });
        }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */

    }
