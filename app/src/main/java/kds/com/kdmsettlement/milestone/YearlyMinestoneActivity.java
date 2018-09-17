package kds.com.kdmsettlement.milestone;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kds.com.kdmsettlement.BaseApp;
import kds.com.kdmsettlement.R;
import kds.com.kdmsettlement.models.YearlyMilestone;

public class YearlyMinestoneActivity extends BaseApp {
    @BindView(R.id.yearly_list)
    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestones);
        ButterKnife.bind(this);
        List<YearlyMilestone> milestones = new ArrayList<YearlyMilestone>() {{
            add(new YearlyMilestone(1, "Returning Survivors"));
            add(new YearlyMilestone(2, "Acid Rain"));
            add(new YearlyMilestone(3, "Toast breads"));
        }};
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MilestoneAdapter adapter = new MilestoneAdapter(milestones);
        recyclerView.setAdapter(adapter);
    }
}
