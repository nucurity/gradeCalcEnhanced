package com.example.part2gradecalc;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    private static final String TAG = "Part3CalcE/Main";

    String[] places =
            {
                    "Humber Valley College",
                    "Hummingbird Academy",
                    "Harrington High",
                    "Georgian Bay College",
                    "Saracuse Academy",
                    "St-Vincent College",
                    "Humber College",
                    "Humber Lakeshore",
                    "Humber North",
            };
    int mark;
    String actionType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Dmitry Zuev n01112600");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, places);
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.place_str);
        acTextView.setThreshold(3);
        acTextView.setAdapter(adapter);

        View minButton = findViewById(R.id.btn_min);
        View avgButton = findViewById(R.id.btn_avg);
        View maxButton = findViewById(R.id.btn_max);

        minButton.setOnClickListener(this);
        avgButton.setOnClickListener(this);
        maxButton.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Calculate.class);

        AutoCompleteTextView placeEdit = (AutoCompleteTextView) findViewById(R.id.place_str);
        EditText grade1Edit = (EditText) findViewById(R.id.grade_1_mark);
        EditText grade2Edit = (EditText) findViewById(R.id.grade_2_mark);
        EditText grade3Edit = (EditText) findViewById(R.id.grade_3_mark);

        String placeText = placeEdit.getText().toString();
        String grade1Text = grade1Edit.getText().toString();
        String grade2Text = grade2Edit.getText().toString();
        String grade3Text = grade3Edit.getText().toString();

        if (!placeText.equals("") && !grade1Text.equals("") && !grade2Text.equals("") && !grade3Text.equals("")) {

            int grade1 = Integer.parseInt(grade1Text);
            int grade2 = Integer.parseInt(grade2Text);
            int grade3 = Integer.parseInt(grade3Text);


            if (v.getId() == R.id.btn_min) {
                mark = Math.min(Math.min(grade1, grade2), grade3);
                actionType = "Minimum is: ";
            } else if (v.getId() == R.id.btn_avg) {
                mark = (grade1 + grade2 + grade3)/3;
                actionType = "Average is: ";
            } else if (v.getId() == R.id.btn_max) {
                mark = Math.max(Math.max(grade1, grade2), grade3);
                actionType = "Maximum is: ";
            }

            intent.putExtra("grade1Text", grade1Text);
            intent.putExtra("grade2Text", grade2Text);
            intent.putExtra("grade3Text", grade3Text);
            intent.putExtra("place", placeText);
            intent.putExtra("actionType", actionType);
            intent.putExtra("mark",String.valueOf(mark));
            startActivity(intent);
        }


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
