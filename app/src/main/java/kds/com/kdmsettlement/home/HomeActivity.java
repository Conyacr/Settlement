package kds.com.kdmsettlement.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import kds.com.kdmsettlement.BaseApp;
import kds.com.kdmsettlement.R;
import kds.com.kdmsettlement.models.CityListData;
import kds.com.kdmsettlement.models.CityListResponse;
import kds.com.kdmsettlement.networking.NetworkFacade;

/**
 * Created by Ryan on 8/3/2018.
 */

public class HomeActivity extends BaseApp implements HomeView {

    private RecyclerView list;
    @Inject
    public NetworkFacade networkFacade;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies().inject(this);

        renderView();
        init();

        HomePresenter presenter = new HomePresenter(networkFacade, this);
        presenter.getCityList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_home);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
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
}
