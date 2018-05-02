package com.example.rodneytressler.week4assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private List<Player> playerList;

    private PlayerAdapter adapter;

    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);
       playerList = getIntent().getParcelableArrayListExtra(String.valueOf(playerList));
       populateRecyclerView();

    }

    private void populateRecyclerView() {
        adapter.onCreateViewHolder(recyclerView,0);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
