package com.guessinggame;

public class GameData {
    private static GameData gameData = new GameData();
    private int randomDigits , times;

    public static GameData getInstance() {
        return gameData;
    }

    public void setRandomDigits(int randomDigits) {
        this.randomDigits = randomDigits;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getRandomDigits() {
        return randomDigits;
    }

    public int getTimes() {
        return times;
    }
}
