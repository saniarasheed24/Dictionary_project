package sania.rasheed.Database;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import sania.rasheed.Models.Meanings;


//this class is incomplete
//this is for saved words


@Entity(tableName = "myWords")
public class SavedWord {
    @PrimaryKey(autoGenerate = true)

    private int id;
    String word;
    @Embedded Meanings meanings;


    public int getId() {
        return id;
    }
}
