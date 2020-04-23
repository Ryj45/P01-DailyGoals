package c346.rp.edu.sg.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1, rg2, rg3;
    EditText etReflection;

    SharedPreferences prefs = getApplicationContext().getSharedPreferences("Mypref", 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOK = (Button)findViewById(R.id.btnOk);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        etReflection = findViewById(R.id.etReflection);

        int re1 = prefs.getInt("re1", -1);
        int re2 = prefs.getInt("re2", -1);
        int re3 = prefs.getInt("re3", -1);
        String reString = prefs.getString("reString", null);

        rg1.check(re1);
        rg2.check(re2);
        rg3.check(re3);
        etReflection.setText(reString);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int select1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(select1);
                String choice1 = rb1.getText().toString();

                int select2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton)findViewById(select2);
                String choice2 = rb2.getText().toString();

                int select3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton)findViewById(select3);
                String choice3 = rb3.getText().toString();

                String reflection = etReflection.getText().toString();

                String[] info = {choice1, choice2, choice3, reflection};

                Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                i.putExtra("info", info);
                startActivity(i);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("re1", select1);
                editor.putInt("re2", select2);
                editor.putInt("re3", select3);
                editor.putString("reString", reflection);
                editor.commit();
            }

        });
    }
}
