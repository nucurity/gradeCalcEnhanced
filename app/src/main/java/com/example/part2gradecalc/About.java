package com.example.part2gradecalc;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class About extends Activity {

    private static final String TAG = "Part3CalcE/About";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i (TAG, "Dmitry Zuev n01112600");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.calc_menu) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        } else if (item.getItemId() == R.id.about_menu) {
            Intent intent = new Intent(this, About.class);
            this.startActivity(intent);
        }
        return true;
    }
}

