package user.manager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class will represent the user class
 */
public class User implements Serializable {
    private String characterName;
    private int totalScore;
    private int totalGamesPlayed;
    private int highestScore;
    private int lastGameScore;
    private ArrayList<Long> seedsPlayed; //Seeds are all the generated map

    /**
     * @param characterName The class can only be initiated if the user has a character name
     */
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
