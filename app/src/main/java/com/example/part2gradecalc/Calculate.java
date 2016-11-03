package com.example.part2gradecalc;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Calculate extends Activity {

    private static final String TAG = "Part3CalcE/Calc";

    TextView grade1Text;
    TextView grade2Text;
    TextView grade3Text;
    TextView placeText;
    TextView markText;
    TextView actionTypeText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Dmitry Zuev n01112600");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate);

        String grade1 = getIntent().getStringExtra("grade1Text");
        String grade2 = getIntent().getStringExtra("grade2Text");
        String grade3 = getIntent().getStringExtra("grade3Text");
        String place = getIntent().getStringExtra("place");
        String actionType = getIntent().getStringExtra("actionType");
        String mark = getIntent().getStringExtra("mark");

        grade1Text = (TextView) findViewById(R.id.grade_1_mark);
        grade2Text = (TextView) findViewById(R.id.grade_2_mark);
        grade3Text = (TextView) findViewById(R.id.grade_3_mark);
        placeText = (TextView) findViewById(R.id.place_str);
        markText = (TextView) findViewById(R.id.actionType_mark);
        actionTypeText = (TextView) findViewById(R.id.actionType_text);

        grade1Text.setText(String.valueOf(grade1));
        grade2Text.setText(String.valueOf(grade2));
        grade3Text.setText(String.valueOf(grade3));
        placeText.setText(String.valueOf(place));
        markText.setText(String.valueOf(mark));
        actionTypeText.setText(String.valueOf(actionType));
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
