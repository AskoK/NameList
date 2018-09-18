package com.example.admin.namelist;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText firstName, lastName;
    private ListView listView;
    private Button btn;
    private Button clr;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.txt_firstN);
        lastName = findViewById(R.id.txt_lastN);
        listView = findViewById(R.id.listView);
        btn = findViewById(R.id.btn_add);
        clr = findViewById(R.id.btn_clr);
        arrayList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        listView.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String added = firstName.getText().toString() + " " + lastName.getText().toString();

                arrayList.add(added);
                adapter.notifyDataSetChanged();
            }

        });

        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return false;
            }
        });

    }



    public void clear(View view) {
        firstName.setText("");
        lastName.setText("");
    }

    public void add(View view) {
    }
}
