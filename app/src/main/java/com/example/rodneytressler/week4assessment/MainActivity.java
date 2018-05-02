package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    private List<Player> playerList;


    public static final String TAG = "PLAYER_LIST_TAG";
   // Bundle bundle;

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {
        if(teamInput.getText().toString().isEmpty() || numberInput.getText().toString().isEmpty() || nameInput.getText().toString().isEmpty()){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        }else{
            String teamName = teamInput.getText().toString();
            String playerNumber = numberInput.getText().toString();
            String playerName = nameInput.getText().toString();
            Player player = new Player(teamName,playerNumber,playerName);
            Toast.makeText(this, "player added", Toast.LENGTH_LONG).show();



        }
    }



    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {
//        if(playerList.isEmpty()){
//            Toast.makeText(this, "There are no players in list", Toast.LENGTH_LONG).show();
//        }else{
            Intent intent = new Intent(MainActivity.this, PlayersActivity.class);
            intent.putParcelableArrayListExtra(TAG, (ArrayList<? extends Parcelable>) playerList);
            startActivity(intent);

//        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



    
}
