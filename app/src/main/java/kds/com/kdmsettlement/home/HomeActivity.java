package kds.com.kdmsettlement.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kds.com.kdmsettlement.BaseApp;
import kds.com.kdmsettlement.R;
import kds.com.kdmsettlement.milestone.YearlyMinestoneActivity;
import kds.com.kdmsettlement.models.CityListData;
import kds.com.kdmsettlement.models.CityListResponse;
import kds.com.kdmsettlement.networking.NetworkFacade;

/**
 * Created by Ryan on 8/3/2018.
 */

public class HomeActivity extends BaseApp implements HomeView {
    @Inject
    public NetworkFacade networkFacade;
    @BindView(R.id.list) RecyclerView list;
    @BindView(R.id.progress) ProgressBar progressBar;
    @BindView(R.id.button)
    Button button;

    @OnClick(R.id.button)
    public void newActivity(View view) {
        startActivity(new Intent(this, YearlyMinestoneActivity.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies().inject(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();

        HomePresenter presenter = new HomePresenter(networkFacade, this);
        presenter.initPresenter();
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getCityListSuccess(CityListResponse cityListResponse) {

        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), cityListResponse.getData(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(CityListData Item) {
                        Toast.makeText(getApplicationContext(), Item.getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });

        list.setAdapter(adapter);

    }

    @Override
    public void hideWait() {
        progressBar.setVisibility(View.GONE);
    }
}
