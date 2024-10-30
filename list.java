package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    ListView listViewItems;
    Button buttonAddMore;

    ArrayList<String> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Remove if not using EdgeToEdge library
        setContentView(R.layout.activity_list);

        listViewItems = findViewById(R.id.listViewItems);
        buttonAddMore = findViewById(R.id.buttonAddMore);

        itemsList = getIntent().getStringArrayListExtra("itemsList");

        // Corrected ArrayAdapter instantiation
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsList);
        listViewItems.setAdapter(adapter);

        // Corrected setOnClickListener and View import
        buttonAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send the current list back to MainActivity
                Intent intent = new Intent(list.this, MainActivity.class);
                intent.putStringArrayListExtra("itemsList", itemsList);  // Pass the updated list back
                startActivity(intent);
            }
        });
    }
}