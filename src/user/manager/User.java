package user.manager;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String characterName;
    private int totalScore;
    private ArrayList<Long> seedsPlayed;

    public User(String characterName){
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public ArrayList<Long> getSeedsPlayed() {
        return seedsPlayed;
    }

    public void setSeedsPlayed(ArrayList<Long> seedsPlayed) {
        this.seedsPlayed = seedsPlayed;
    }
}
