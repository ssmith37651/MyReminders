package com.example.myreminders;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ViewReminder extends AppCompatActivity {

    Intent intent;

    DBHandler dbHandler;

    long id;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reminder);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bundle = this.getIntent().getExtras();
        id = bundle.getLong("_id");

        dbHandler = new DBHandler(this, null);

        String shoppingListName = dbHandler.getMyReminderName((int)id);

        this.setTitle(shoppingListName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_reminder, menu);
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
    }
}
