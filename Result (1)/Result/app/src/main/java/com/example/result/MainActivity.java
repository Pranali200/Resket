package com.example.result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    //TextInputLayout nametext, contact, email;
    EditText edtTotal_Marks, edtMin_Marks,ed1,ed2,ed3;
    FloatingActionButton fb;
    Button sbmt, chk_Marks;
    Spinner sp1, sp2,sp3;
    String selectedClass, selectedDiv;
    String[] Sessional = { " First Sessional ", "Second Sessional"
             };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //nametext = (TextInputLayout) findViewById(R.id.nametext);
        //contact = (TextInputLayout) findViewById(R.id.contacttext);
        //email = (TextInputLayout) findViewById(R.id.emailtext);
        edtTotal_Marks = (EditText) findViewById(R.id.edtTotMarks);
        edtMin_Marks = (EditText) findViewById(R.id.edtMinMarks);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        fb = (FloatingActionButton) findViewById(R.id.fbtn);
        sbmt = (Button) findViewById(R.id.sbmt_add);
        chk_Marks = (Button) findViewById(R.id.chk_marks);
        sp1 = (Spinner) findViewById(R.id.sp1);
        sp2 = (Spinner) findViewById(R.id.sp2);
        sp3 = (Spinner) findViewById(R.id.sp3);
        sp3.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Sessional);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sp3.setAdapter(aa);


        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(
                        sp1.getSelectedItem().toString(),
                        sp2.getSelectedItem().toString(),
                        sp3.getSelectedItem().toString(),
                        edtTotal_Marks.getText().toString(),
                        edtMin_Marks.getText().toString(),
                        ed1.getText().toString(),
                        ed2.getText().toString(),
                        ed3.getText().toString()


                );
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), fetchdata.class));
            }
        });
        chk_Marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Check_Marks.class));
            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass) {
                    case "1st Sem":
                        // assigning div item list defined in XML to the div Spinner
                        sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.Sem1)));
                        break;

                    case "2nd Sem":
                        sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.Sem2)));
                        break;

                    case "3rd Sem":
                        // assigning div item list defined in XML to the div Spinner
                        sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.Sem3)));
                        break;

                    case "4th Sem":
                        sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.Sem4)));
                        break;

                    case "5th Sem":
                        // assigning div item list defined in XML to the div Spinner
                        sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.Sem5)));
                        break;

                    case "6th Sem":
                        sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this,
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
                Toast.makeText(MainActivity.this, "\n OPTION: \t " + selectedClass +
                        "\n Semester: \t" + selectedDiv, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });


    }

    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method



        private void processinsert(String se, String su, String s, String to, String mi, String n, String c, String e){
            String res = new dbmanager(this).addrecord(se,su,s,to,mi,n,c,e);
            sp1.getSelectedItem();
            sp2.getSelectedItem();
            sp3.getSelectedItem();
            edtTotal_Marks.setText("");
            edtMin_Marks.setText("");
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");


            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();


    }


    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



