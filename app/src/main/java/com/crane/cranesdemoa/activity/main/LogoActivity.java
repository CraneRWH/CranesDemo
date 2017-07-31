package com.crane.cranesdemoa.activity.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crane.cranesdemoa.R;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        new TimeTask().execute();
    }

    class TimeTask extends AsyncTask<Void,Integer,Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
                startActivity(new Intent(LogoActivity.this, MainActivity.class));
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
