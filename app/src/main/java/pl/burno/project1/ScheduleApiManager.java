package pl.burno.project1;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ScheduleApiManager
{
    private ScheduleService service;

    public ScheduleApiManager()
    {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://burno.ga/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        service = retrofit.create(ScheduleService.class);
    }

    public void getSchedule(final Callback<Days> callback)
    {
        service.getSchedule().enqueue(callback);
    }
}
