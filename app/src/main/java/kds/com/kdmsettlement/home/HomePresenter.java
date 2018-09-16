package kds.com.kdmsettlement.home;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kds.com.kdmsettlement.networking.NetworkFacade;


/**
 * Created by Ryan on 8/3/2018.
 */

public class HomePresenter {
    private final NetworkFacade networkFacade;
    private final HomeView view;
    private CompositeDisposable disposable;

    public HomePresenter(NetworkFacade networkFacade, HomeView view) {
        this.networkFacade = networkFacade;
        this.view = view;
        this.disposable = new CompositeDisposable();
    }

    public void initPresenter() {
        this.disposable.add(
                networkFacade.getCityList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(cityListResponse -> {
                                view.hideWait();
                                view.getCityListSuccess(cityListResponse);
                            },
                            throwable -> Log.e("Error", throwable.getMessage())));
    }

    public void onStop() {
        disposable.dispose();
    }
}