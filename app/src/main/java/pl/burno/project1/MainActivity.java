package pl.burno.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private ScheduleAdapter scheduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduleAdapter = new ScheduleAdapter(new OnDayClickListener()
        {
            @Override
            public void onDayClickListener(Day day)
            {
                Intent intent = new Intent(MainActivity.this, DayActivity.class);
                intent.putExtra(EXTRA.DAY, day);
                startActivity(intent);
            }
        });
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(scheduleAdapter);

        final View progressBar = findViewById(R.id.progressBar);

        ScheduleApiManager apiManager = new ScheduleApiManager();
        apiManager.getSchedule(new Callback<Days>()
        {
            @Override
            public void onResponse(Call<Days> call, Response<Days> response)
            {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful())
                    scheduleAdapter.setList(response.body());
                else
                    Toast.makeText(MainActivity.this, R.string.connection, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Days> call, Throwable t)
            {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, R.string.connection, Toast.LENGTH_SHORT).show();
            }
        });
    }

    interface OnDayClickListener
    {
        public void onDayClickListener(Day day);
    }
}
