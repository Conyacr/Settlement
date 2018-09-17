package kds.com.kdmsettlement.milestone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kds.com.kdmsettlement.R;
import kds.com.kdmsettlement.models.YearlyMilestone;

public class MilestoneAdapter extends RecyclerView.Adapter<MilestoneAdapter.MilestoneViewHolder> {
    private List<YearlyMilestone> milestones;

    public static class MilestoneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.year_text)
        public TextView yearText;
        @BindView(R.id.current_events)
        public TextView yearEvents;
        @BindView(R.id.add_event)
        public ImageButton addEvent;
        public Context context;

        @OnClick(R.id.add_event)
        public void addEvent(View view) {
            Toast.makeText(context, "Add event flow", Toast.LENGTH_SHORT).show();
        }

        public MilestoneViewHolder(View itemView,  Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;
        }
    }

    public MilestoneAdapter(List<YearlyMilestone> milestones) {
        this.milestones = milestones;
    }

    @NonNull
    @Override
    public MilestoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MilestoneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.milestone_item, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull MilestoneViewHolder holder, int position) {
        holder.yearText.setText(String.valueOf(milestones.get(position).getYear()));
        holder.yearEvents.setText(milestones.get(position).getEventString());
    }

    @Override
    public int getItemCount() {
        return milestones.size();
    }
}
