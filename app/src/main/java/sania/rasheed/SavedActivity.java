package sania.rasheed;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SavedActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        setTitle("Saved");

        //menu
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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
                Intent managerIntent = new Intent(SavedActivity.this,MainActivity.class);
                startActivity(managerIntent);
                break;
            }
            case R.id.menuHistory:
            {
                Intent managerIntent = new Intent(SavedActivity.this,HistoryActivity.class);
                startActivity(managerIntent);
                break;
            }
            case R.id.menuSaved:
            {
                Intent managerIntent = new Intent(SavedActivity.this,SavedActivity.class);
                startActivity(managerIntent);
                break;
            }
        }
        return true;
    }
}
