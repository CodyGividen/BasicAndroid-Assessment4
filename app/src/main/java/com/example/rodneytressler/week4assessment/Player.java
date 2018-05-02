package com.example.rodneytressler.week4assessment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cody Gividen on 12/17/17.
 */

public class Player implements Parcelable{
    private String team;
    private String playerNumber;
    private String playerName;

    public Player(String team, String playerNumber, String playerName) {
        this.team = team;
        this.playerNumber = playerNumber;
        this.playerName = playerName;
    }

    protected Player(Parcel in) {
        team = in.readString();
        playerNumber = in.readString();
        playerName = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getTeam() {
        return team;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(team);
        dest.writeString(playerNumber);
        dest.writeString(playerName);
    }
}
