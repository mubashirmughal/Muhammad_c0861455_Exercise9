package com.example.exercise9;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> itemlist;
    ArrayAdapter<String> adapter;
    EditText editText;
    Button button;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        editText = findViewById(R.id.Edittext);
        button = findViewById(R.id.Button);
        itemlist = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, itemlist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
                } else {
                    int getnumber = Integer.parseInt(editText.getText().toString().trim());
                    itemlist.clear();
                    printtable(getnumber);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View convert, int position, long l) {
                removeitem(position);
            }
        });
    }

    private void removeitem(int remove) {
        itemlist.remove(remove);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "remove item" + remove, Toast.LENGTH_SHORT).show();
    }

    private void printtable(int number) {
        for (int i = 1; i <= 10; i++) {
            String result = " " + number * i;
            itemlist.add(result);
            list.setAdapter(adapter);
        }
    }
}
