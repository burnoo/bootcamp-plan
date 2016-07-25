package pl.burno.project1;

import java.io.Serializable;

public class Day implements Serializable
{
    public final String app;
    public final String name;
    public final String plan;
    public final String topic;

    public Day(String app, String name, String plan, String topic)
    {
        this.app = app;
        this.name = name;
        this.plan = plan;
        this.topic = topic;
    }
}