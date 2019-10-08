package com.example.myreminders;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    DBHandler dbHandler;

    Reminders remindersAdapter;

    ListView reminderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new DBHandler(this, null);

        reminderView = (ListView) findViewById(R.id.reminderListView);

        remindersAdapter = new Reminders(this, dbHandler.getMyReminders(), 0);

        reminderView.setAdapter(remindersAdapter);

        reminderView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                intent.putExtra("_id", id);
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_home :
                // initializing an intent for the Create List activity, starting it
                // and returning home
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_Add_Reminder:
                // initializing an intent for the Main activity, starting it
                // and returning home
                intent = new Intent(this, AddReminder.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void openAddReminder(View view) {
        intent = new Intent(this, AddReminder.class);
        startActivity(intent);
    }
}
