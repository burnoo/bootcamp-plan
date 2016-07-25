package pl.burno.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DayActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        if (getIntent().getSerializableExtra(EXTRA.DAY) == null)
            finish();
        else
        {
            Day day = (Day) getIntent().getSerializableExtra(EXTRA.DAY);
            TextView dayTextView = (TextView) findViewById(R.id.dayTextView);
            TextView titleTextView = (TextView) findViewById(R.id.topicTextView);
            TextView planTextView = (TextView) findViewById(R.id.planTextView);
            TextView appTextView = (TextView) findViewById(R.id.appTextView);

            dayTextView.setText(day.name);
            titleTextView.setText(day.topic);
            planTextView.setText(day.plan);
            appTextView.setText(day.app);
        }
    }
}
