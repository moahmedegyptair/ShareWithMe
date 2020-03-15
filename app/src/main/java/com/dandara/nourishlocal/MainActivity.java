package com.dandara.nourishlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.dandara.nourishlocal.adapter.CommunityListAdapter;
import com.dandara.nourishlocal.adapter.CommunityRecyclerAdapter;
import com.dandara.nourishlocal.model.Community;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtInputUser;
    private CommunityRecyclerAdapter communityRecyclerAdapter;
    private ArrayList<Community> list = new ArrayList<>();

    private RecyclerView typeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInputUser = findViewById(R.id.txtInputUser);
        typeListView = findViewById(R.id.typesListView);
        typeListView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        typeListView.setLayoutManager(linearLayoutManager);

        Community community1 = new Community(getString(R.string.eat), getString(R.string.eat_description), R.drawable.eat);
        Community community2 = new Community(getString(R.string.eat), getString(R.string.eat_description), R.drawable.eat);
        Community community3 = new Community(getString(R.string.eat), getString(R.string.eat_description), R.drawable.eat);
        Community community4 = new Community(getString(R.string.eat), getString(R.string.eat_description), R.drawable.eat);
        Community community5 = new Community(getString(R.string.eat), getString(R.string.eat_description), R.drawable.eat);
        list.add(community1);
        list.add(community2);
        list.add(community3);
        list.add(community4);
        list.add(community5);
        communityRecyclerAdapter = new CommunityRecyclerAdapter(list, this);
        typeListView.setAdapter(communityRecyclerAdapter);

    }

    public void getIntent(Community community) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(getString(R.string.user_name_key), txtInputUser.getText().toString());
        intent.putExtra(getString(R.string.community_key), community);
        startActivity(intent);

    }
}
