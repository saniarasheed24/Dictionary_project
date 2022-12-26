package sania.rasheed.Database;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Word word);

    @Delete
    void delete(Word word);

    @Query("SELECT * FROM saved")
    LiveData<List<Word>> getAllWords();

}
