package c346.rp.edu.sg.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOK = (Button)findViewById(R.id.btnOk);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg1);
                int select1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(select1);
                String choice1 = rb1.getText().toString();

                RadioGroup rg2 = (RadioGroup)findViewById(R.id.rg2);
                int select2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton)findViewById(select2);
                String choice2 = rb2.getText().toString();

                RadioGroup rg3 = (RadioGroup)findViewById(R.id.rg3);
                int select3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton)findViewById(select3);
                String choice3 = rb3.getText().toString();

                EditText etReflection = findViewById(R.id.etReflection);
                String reflection = etReflection.getText().toString();

                String[] info = {choice1, choice2, choice3, reflection};

                Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                i.putExtra("info", info);
                startActivity(i);
            }
        });
    }
}
