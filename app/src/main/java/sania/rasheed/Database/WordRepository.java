package sania.rasheed.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    // below line is the create a variable
    // for dao and list for all words.
    private Dao dao;
    private LiveData<List<Word>> allWords;

    // creating a constructor for our variables
    // and passing the variables to it.
    public WordRepository(Application application) {
        WordDatabase database = WordDatabase.getInstance(application);
        dao = database.Dao();
        allWords = dao.getAllWords();
    }

    // creating a method to insert the data to our database.
    public void insert(Word model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(Word model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the history items.
    public void deleteAllWords() {
        new DeleteAllWordsAsyncTask(dao).execute();
    }

    // below method is to read all the history items.
    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }


    //creating a async task method to insert new word.
    private static class InsertCourseAsyncTask extends AsyncTask<Word, Void, Void> {
        private Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Word... model) {
            // below line is use to insert our modal in dao.

            dao.insert(model[0]);
            return null;
        }
    }


    // creating a async task method to delete course.
    private static class DeleteCourseAsyncTask extends AsyncTask<Word, Void, Void> {
        private Dao dao;

        private DeleteCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Word... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    // creating a async task method to delete all words.
    private static class DeleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllWordsAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllWords();
            return null;
        }
    }
}
