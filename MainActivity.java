package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import kotlin.collections.list;

public class MainActivity extends AppCompatActivity {

    EditText editTextItem;
    Button addButton;
    ListView listViewItems;

    ArrayList<String> itemsList; // Corrected variable name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextItem = findViewById(R.id.editTextItem);
        addButton = findViewById(R.id.addButton);


        // Retrieve the existing items list if it exists
        itemsList = getIntent().getStringArrayListExtra("itemsList");
        if (itemsList == null) {
            itemsList = new ArrayList<>();
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editTextItem.getText().toString();
                if (!item.isEmpty()) {
                    itemsList.add(item);  // Add the new item to the list
                    editTextItem.setText("");

                    // Go to ListActivity and pass the updated items list
                    Intent intent = new Intent(MainActivity.this, list.class);
                    intent.putStringArrayListExtra("itemsList", itemsList);
                    startActivity(intent);
                }
            }
        });
    }
}
