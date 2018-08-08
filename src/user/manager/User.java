package user.manager;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String characterName;
    private int totalScore;
    private int totalGamesPlayed;
    private int highestScore;
    private int lastGameScore;
    private ArrayList<Long> seedsPlayed;

    public User(String characterName) {
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

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void incrementTotalPlayedGamed() {
        this.totalGamesPlayed++;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getLastGameScore() {
        return lastGameScore;
    }

    public void setLastGameScore(int lastGameScore) {
        this.lastGameScore = lastGameScore;
    }

    public ArrayList<Long> getSeedsPlayed() {
        if (seedsPlayed == null) this.seedsPlayed = new ArrayList<>();
        return seedsPlayed;
    }
}
