package com.tp4.gradesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    AutoCompleteTextView autoSaisie;

    String[] allStudents = {"Sami", "Samira", "Sara"};
    String[] allTopics = {"Android", "Angular", "UX", "Databases", "C++", "Big Data"};

    //1st Version
    String[] NotesSara = {"12", "7", "3.5", "15", "8", "10.5"};
    String[] NotesSamira = {"2", "4", "18.5", "16", "18", "5.75"};
    String[] NotesSami = {"11", "17", "5.5", "10", "2", "10.25"};

    //2nd Version
    String[][] NotesAll = {
            {"12", "7", "3.5", "15", "8", "10.5"},
            {"2", "4", "18.5", "16", "18", "5.75"},
            {"11", "17", "5.5", "10", "2", "10.25"}
    };

    String selectedStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lst = this.findViewById(R.id.notesLst);
        this.autoSaisie = findViewById(R.id.saisieAuto);



        ArrayAdapter ar = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                this.allStudents);

        autoSaisie.setAdapter(ar);

        autoSaisie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {

                selectedStudent = ((TextView) v).getText().toString();


                ArrayAdapter adapter ;

                if (selectedStudent.equals("Sara")) {
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, NotesSara);


                } else if (selectedStudent.equals("Samira")) {
                    adapter = new ArrayAdapter<String>(MainActivity.this,  android.R.layout.simple_list_item_1, NotesSamira);

                } else {
                    adapter = new ArrayAdapter<String>(MainActivity.this,  android.R.layout.simple_list_item_1, NotesSami);

                }

                lst.setAdapter(adapter);

                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int i, long id) {
                        String selectedTopic = allTopics[i];
                        //TextView myNote = v.findViewById(R.id.note);
                        TextView myNote = (TextView) v;
                        Double note = Double.parseDouble(myNote.getText().toString());

                        if (note >= 10)
                            Toast.makeText(MainActivity.this, selectedTopic + " : Pass", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(), selectedTopic + " : Fail", Toast.LENGTH_LONG).show();

                    }
                });



            }
        });
    }
}
