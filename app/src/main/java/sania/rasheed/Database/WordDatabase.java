package sania.rasheed.Database;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 2)
public abstract class WordDatabase extends RoomDatabase{

    private static WordDatabase instance;
    public abstract Dao Dao();

    // on below line we are getting instance for our database.
    public static synchronized WordDatabase getInstance(Context context) {
        if (instance == null) {
            // if the instance is null create a new instance
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                                    WordDatabase.class, "saved")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
        }
        // after creating an instance returning our instance
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    //creating an async task class to perform task in background.
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(WordDatabase instance) {
            Dao dao = instance.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }



}
