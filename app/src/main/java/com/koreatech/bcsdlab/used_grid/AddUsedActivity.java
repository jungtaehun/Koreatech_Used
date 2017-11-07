package com.koreatech.bcsdlab.used_grid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddUsedActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mPrice;
    private EditText mContent;
    private Button mSave;

    private ArrayList<UsedItem> usedList;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_used);

        mName = (EditText)findViewById(R.id.input_name);
        mPrice = (EditText)findViewById(R.id.input_price);
        mContent = (EditText)findViewById(R.id.input_content);

        mSave = (Button)findViewById(R.id.save_btn);
        mSave.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", mName.getText().toString());
                intent.putExtra("price", Integer.parseInt(mPrice.getText().toString()));
                intent.putExtra("content", mContent.getText().toString());
                setResult(1, intent);
                finish();
            }
        });
    }
}
