package pl.burno.project1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>
{
    private List<Day> days;
    private OnClickedListener onClickedListner;

    public ScheduleAdapter(final MainActivity.OnDayClickListener dayClickListener)
    {
        onClickedListner = new OnClickedListener()
        {
            @Override
            public void onClickedListner(int position)
            {
                dayClickListener.onDayClickListener(days.get(position));
            }
        };
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new ScheduleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position)
    {
        Day day = days.get(position);
        holder.dayTextView.setText(day.name);
        holder.topicTextView.setText(day.topic);
    }

    @Override
    public int getItemCount()
    {
        return days == null ? 0 : days.size();
    }

    public void setList(final Days days)
    {
        this.days = days.days;
        notifyDataSetChanged();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView dayTextView;
        public TextView topicTextView;

        public ScheduleViewHolder(View itemView)
        {
            super(itemView);
            dayTextView = (TextView) itemView.findViewById(R.id.dayTextView);
            topicTextView = (TextView) itemView.findViewById(R.id.topicTextView);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    onClickedListner.onClickedListner(getAdapterPosition());
                }
            });
        }
    }

    interface OnClickedListener
    {
        public void onClickedListner(int position);
    }
}