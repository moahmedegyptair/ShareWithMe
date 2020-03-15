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

import com.dandara.nourishlocal.model.Community;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = DetailsActivity.class.getSimpleName();
    private TextView txtDetails;
    private TextView txtDescription;
    private String txtUser;
    private Community community;
    private ImageView typeImageView;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtDetails = findViewById(R.id.txtDetails);
        txtDescription = findViewById(R.id.txtDescription);
        typeImageView = findViewById(R.id.typeImageView);
        btnShare = findViewById(R.id.btnShare);
        txtUser = getIntent().getStringExtra(getString(R.string.user_name_key));
        community = (Community) getIntent().getSerializableExtra(getString(R.string.community_key));

        txtDetails.setText(community.getName());
        typeImageView.setImageResource(community.getImageReference());
        txtDescription.setText(community.getDescription());
        btnShare.setText(String.format("%s مع %s", getString(R.string.share), txtUser));

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String msg = String.format("%s: %s", txtUser, community.getDescription());
                shareIntent.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name)));
            }
        });

    }

}
