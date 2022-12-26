package sania.rasheed;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import sania.rasheed.Adapters.HistoryAdapter;
import sania.rasheed.Database.ViewModel;
import sania.rasheed.Database.Word;
import sania.rasheed.Database.WordRepository;

public class HistoryActivity extends AppCompatActivity {

    FloatingActionButton btnDeleteAll;
    RecyclerView historyRecyclerView;
    ViewModel viewModel;
    HistoryAdapter historyAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");

        btnDeleteAll = findViewById(R.id.btn_delete);

        //menu
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //recycler view
        historyRecyclerView = findViewById(R.id.historyRecyclerView);
        historyAdapter = new HistoryAdapter(this);

        historyRecyclerView.setAdapter(historyAdapter);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                historyAdapter.setWords(words);
            }
        });
        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteAllWords();

            }
        });

    }



    //Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent managerIntent = new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(managerIntent);
                break;
            }
            case R.id.menuHistory:
            {
                Intent managerIntent = new Intent(HistoryActivity.this,HistoryActivity.class);
                startActivity(managerIntent);
                break;
            }
            case R.id.menuSaved:
            {
                Intent managerIntent = new Intent(HistoryActivity.this,SavedActivity.class);
                startActivity(managerIntent);
                break;
            }
        }
        return true;
    }
}
