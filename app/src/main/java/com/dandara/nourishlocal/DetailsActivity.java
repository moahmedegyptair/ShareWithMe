package com.dandara.nourishlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = DetailsActivity.class.getSimpleName();
    private TextView txtDetails;
    private TextView txtDescription;
    private String txtUser;
    private String txtButton;
    private ImageView typeImageView;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Log.d(TAG, getIntent().getStringExtra(getString(R.string.user_name_key)));
        //Log.d(TAG, getIntent().getStringExtra(getString(R.string.type_key)));
        txtDetails = findViewById(R.id.txtDetails);
        txtDescription = findViewById(R.id.txtDescription);
        typeImageView = findViewById(R.id.typeImageView);
        btnShare = findViewById(R.id.btnShare);
        txtUser = getIntent().getStringExtra(getString(R.string.user_name_key));
        txtButton = getIntent().getStringExtra(getString(R.string.type_key));

        txtDetails.setText(txtButton);
        typeImageView.setImageResource(getTypeDrawable(txtButton));
        txtDescription.setText(getDescription(txtButton));
        btnShare.setText(String.format("%s مع %s", getString(R.string.share), txtUser));

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String msg = String.format("%s: %s", txtUser, getDescription(txtButton));
                shareIntent.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name)));
            }
        });
        /*if(txtButton.equals(getString(R.string.make))){
            typeImageView.setImageResource(R.drawable.make);
        }
        if(txtButton.equals(getString(R.string.cook))){
            typeImageView.setImageResource(R.drawable.cook);
        }
        if(txtButton.equals(getString(R.string.eat))){
            typeImageView.setImageResource(R.drawable.eat);
        }
        if(txtButton.equals(getString(R.string.shop))){
            typeImageView.setImageResource(R.drawable.shop);
        }
        if(txtButton.equals(getString(R.string.grow))){
            typeImageView.setImageResource(R.drawable.grow);
        }*/

    }

    private int getTypeDrawable(String type) {
        if (type.equals(getString(R.string.make))) {
            return R.drawable.make;
        } else if (type.equals(getString(R.string.cook))) {
            return R.drawable.cook;
        } else if (type.equals(getString(R.string.eat))) {
            return R.drawable.eat;
        } else if (type.equals(getString(R.string.shop))) {
            return R.drawable.shop;
        } else {
            return R.drawable.grow;
        }
    }

    private String getDescription(String type) {
        if (type.equals(getString(R.string.make))) {
            return getString(R.string.make_description);
        } else if (type.equals(getString(R.string.cook))) {
            return getString(R.string.cook_description);
        } else if (type.equals(getString(R.string.eat))) {
            return getString(R.string.eat_description);
        } else if (type.equals(getString(R.string.shop))) {
            return getString(R.string.shop_description);
        } else {
            return getString(R.string.grow_description);
        }
    }
}
