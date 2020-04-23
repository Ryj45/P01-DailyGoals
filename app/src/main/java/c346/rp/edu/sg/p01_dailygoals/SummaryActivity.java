package c346.rp.edu.sg.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText("Read up on materials before class: " + info[0]
        + "\nArrive on time so as not to miss important part of the lesson: "
        + info[1] + "\nAttempt the problem myself: " + info[2] + "\nReflection: "
        + info[3]);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
