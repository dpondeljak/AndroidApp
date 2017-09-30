package com.tutorial.appdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tutorial.appdemo.BaseActivity;
import com.tutorial.appdemo.R;
import com.tutorial.appdemo.util.SessionManager;

public class MainActivity_old extends BaseActivity {

    private SessionManager iSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setToolbar();

        // Pozivamo sesiju
        iSession = new SessionManager(getApplicationContext());

        // Provjera prijave korisnika
        if (!iSession.isPrijavljen()) {
            odjaviKorisnika();
        }

        // rest

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_logout:
                // User chose the "Settings" item, show the app settings UI...
                odjaviKorisnika();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private void setToolbar() {
        Toolbar tBar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(tBar);
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

    }

    private void odjaviKorisnika() {
        iSession.setPrijava(false);

        //db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity_old.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
