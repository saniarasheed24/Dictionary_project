package sania.rasheed.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import sania.rasheed.Models.APIResponse;

@Database(entities = {APIResponse.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DAO dao();
    private static AppDatabase INSTANCE;
    public static AppDatabase getDbInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                    "Dictionary").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }


}
