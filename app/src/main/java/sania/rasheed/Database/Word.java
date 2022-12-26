package sania.rasheed.Database;
import androidx.room.PrimaryKey;

import androidx.room.Entity;

@Entity(tableName = "saved")
public class Word {
    @PrimaryKey(autoGenerate = true)
    // variable for our id.
    private int id;
    String word;

    public Word(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
    //String noun;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    String verb;
//    String adjectives;
//
//    public Word(String word, String noun, String verb, String adjectives) {
//        this.word = word;
//        this.noun = noun;
//        this.verb = verb;
//        this.adjectives = adjectives;
//    }
//
//    public String getWord() {
//        return word;
//    }
//
//    public void setWord(String word) {
//        this.word = word;
//    }
//
//    public String getNoun() {
//        return noun;
//    }
//
//    public void setNoun(String noun) {
//        this.noun = noun;
//    }
//
//    public String getVerb() {
//        return verb;
//    }
//
//    public void setVerb(String verb) {
//        this.verb = verb;
//    }
//
//    public String getAdjectives() {
//        return adjectives;
//    }
//
//    public void setAdjectives(String adjectives) {
//        this.adjectives = adjectives;
//    }
//}
