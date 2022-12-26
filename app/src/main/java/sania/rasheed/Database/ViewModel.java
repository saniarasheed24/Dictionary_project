package sania.rasheed.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    // creating a new variable for course repository.
    private WordRepository repository;

    // below line is to create a variable for live
    // data where all the courses are present.
    private LiveData<List<Word>> allWords;

    // constructor for our view modal.
    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
        allWords = repository.getAllCourses();
    }

    // below method is use to insert the data to our repository.
    public void insert(Word model) {
        repository.insert(model);
    }

    // below line is to delete the data in our repository.
    public void delete(Word model) {
        repository.delete(model);
    }

    // below method is to delete all the courses in our list.
    public void deleteAllWords() {
        repository.deleteAllWords();
    }

    // below method is to get all the courses in our list.
    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

//    public boolean checkDuplicate(Word word){
//        if(repository.)
//        return false;
//    }
}
