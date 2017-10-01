package com.tutorial.appdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tutorial.appdemo.BaseActivity;
import com.tutorial.appdemo.util.Logger;
import com.tutorial.appdemo.util.NetworkUtility;


public class SplashActivity extends BaseActivity {

    TextView txtAppTitle;
    NetworkUtility nu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash_activity);
//        txtAppTitle = (TextView) findViewById(R.id.txtAppTitle);

        //setSplashScreen();
        //setContentView(R.layout.splash_activity);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


        /*
        if(isConnected() && !nu.getNetworkStatus(this).equals(NONE_STATE)) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            noConnectionDialog();
        }


        startActivity(new Intent(this, MainActivity.class));
        finish(); */
    }


    private boolean isConnected() {
        return NetworkUtility.isConnected(getApplicationContext());
    }

    public void noConnectionDialog(){
        Logger.T(this, "No internet connection");
    }

    private void setSplashScreen(){



    }

}
