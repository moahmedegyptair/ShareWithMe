package com.dandara.nourishlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtInputUser;
    private Button btnMake;
    private Button btnCook;
    private Button btnEat;
    private Button btnShop;
    private Button btnGrow;
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInputUser = findViewById(R.id.txtInputUser);
        btnMake = findViewById(R.id.btnMake);
        btnCook = findViewById(R.id.btnCook);
        btnEat = findViewById(R.id.btnEat);
        btnShop = findViewById(R.id.btnShop);
        btnGrow = findViewById(R.id.btnGrow);

        btnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(btnMake.getText().toString());
            }
        });
        btnCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, txtInputUser.getText().toString());
                getIntent(btnCook.getText().toString());
            }
        });
        btnEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(btnEat.getText().toString());
            }
        });
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(btnShop.getText().toString());
            }
        });
        btnGrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(btnGrow.getText().toString());
            }
        });

    }

    private void getIntent(String type) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(getString(R.string.user_name_key), txtInputUser.getText().toString());
        intent.putExtra(getString(R.string.type_key), type);
        startActivity(intent);

    }
}
