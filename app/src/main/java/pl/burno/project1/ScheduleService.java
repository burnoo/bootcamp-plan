package pl.burno.project1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScheduleService
{
    @GET("schedule.json")
    Call<Days> getSchedule();
}
