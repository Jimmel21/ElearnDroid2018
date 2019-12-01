package com.jimmel.elearndroid2018;

import android.app.Application;
import android.content.Context;
import java.io.*;

public class User extends Application implements Serializable {
    public String username;
    public int highScore;

    public User(String username){
        this.username = username;
        this.highScore = 0;
    }

    public void updateScore(int score){
        this.highScore = score;
    }
    public String getUsername(){
        return this.username;
    }
    public int getHighScore() {
        return this.highScore;
    }
}
