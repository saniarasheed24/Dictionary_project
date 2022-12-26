package sania.rasheed.Database;
import androidx.room.PrimaryKey;

import androidx.room.Entity;

@Entity(tableName = "saved")
public class Word {
    @PrimaryKey(autoGenerate = true)
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
