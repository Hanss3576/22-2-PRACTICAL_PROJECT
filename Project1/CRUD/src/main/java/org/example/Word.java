package org.example;

public class Word {
    int level;
    String word;
    String mean;
    private int id;

    public Word(int id, int level, String word, String mean) {
        this.id = id;
        this.level = level;
        this.word = word;
        this.mean = mean;
    }

    public Word() {
    }

    @Override
    public String toString() {
        String slevel = "";
        for (int i = 0; i < level; i++) slevel += "*";
        String str = String.format("%-3s", slevel)
                + String.format("%15s", word) + " " + mean;
        return str;
    }

    public String toFileString(){
        return this.level + "|" + this.word + "|" + this.mean;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
