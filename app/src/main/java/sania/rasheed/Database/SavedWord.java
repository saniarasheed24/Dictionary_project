package sania.rasheed.Database;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import sania.rasheed.Models.Meanings;

@Entity(tableName = "myWords")
public class SavedWord {
    @PrimaryKey(autoGenerate = true)
    // variable for our id.
    private int id;
    String word;
    @Embedded Meanings meanings;

//    public Word(String word) {
//        this.word = word;
//    }

    public int getId() {
        return id;
    }
}
