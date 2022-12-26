package sania.rasheed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import sania.rasheed.Adapters.MeaningsAdapter;
import sania.rasheed.Adapters.PhoneticsAdapter;
import sania.rasheed.Database.Word;
import sania.rasheed.Database.WordRepository;
import sania.rasheed.Models.APIResponse;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    TextView textView_word;
    RecyclerView recyclerView_phonetics, recyclerView_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningsAdapter meaningsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recyclerView_phonetics = findViewById(R.id.recycler_phonetics);
        recyclerView_meanings = findViewById(R.id.recycler_meanings);
        progressDialog = new ProgressDialog(this);

//        progressDialog.setTitle("Loading...");
//        progressDialog.show();

        //API call
        RequestManager manager = new RequestManager(MainActivity.this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Please wait");
                progressDialog.show();

                //API call
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener, query);

                //saving history
                saveHistory(query);
                progressDialog.dismiss();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    //listener
    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse == null){
                Toast.makeText(MainActivity.this, "Nothing found" +
                        "", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIResponse apiResponse){
        textView_word.setText(apiResponse.getWord());
        recyclerView_phonetics.setHasFixedSize(true);
        recyclerView_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this, apiResponse.getPhonetics());
        recyclerView_phonetics.setAdapter(phoneticsAdapter);

        recyclerView_meanings.setHasFixedSize(true);
        recyclerView_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningsAdapter = new MeaningsAdapter(this,apiResponse.getMeanings());
        recyclerView_meanings.setAdapter(meaningsAdapter);
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemID = item.getItemId();
        switch (itemID){
            case R.id.menuHistory:
            {
                Intent managerIntent = new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(managerIntent);
                break;
            }
            case R.id.menuSaved:
            {
                Intent managerIntent = new Intent(MainActivity.this,SavedActivity.class);
                startActivity(managerIntent);
                break;
            }
        }
        return true;
    }

    //Database
    private void saveHistory(String word) {
        Word userWord = new Word(word);
        WordRepository w=new WordRepository(getApplication());
        w.insert(userWord);
    }
}