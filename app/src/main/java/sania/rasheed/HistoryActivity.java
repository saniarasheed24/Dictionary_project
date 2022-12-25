package sania.rasheed;

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

import java.util.List;

import sania.rasheed.Adapters.HistoryAdapter;
import sania.rasheed.Database.ViewModel;
import sania.rasheed.Database.Word;

public class HistoryActivity extends AppCompatActivity {


    RecyclerView historyRecyclerView;
    ViewModel viewModel;
    HistoryAdapter historyAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");
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

        //viewModel = ViewModelProviders.of(this).ge
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                historyAdapter.setWords(words);
            }
        });

        //delete
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                // on recycler view item swiped then we are deleting the item of our recycler view.
//                viewModel.delete(historyAdapter.getWordAt(viewHolder.getBindingAdapterPosition()-1));
//                Toast.makeText(HistoryActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).
//                // below line is use to attach this to recycler view.
//                        attachToRecyclerView(historyRecyclerView);

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
