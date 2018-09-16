package kds.com.kdmsettlement.home;

import kds.com.kdmsettlement.models.CityListResponse;
import kds.com.kdmsettlement.networking.NetworkError;
import kds.com.kdmsettlement.networking.NetworkFacade;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ryan on 8/3/2018.
 */

public class HomePresenter {
    private final NetworkFacade networkFacade;
    private final HomeView view;
    private CompositeSubscription subscriptions;

    public HomePresenter(NetworkFacade networkFacade, HomeView view) {
        this.networkFacade = networkFacade;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCityList() {
        view.showWait();

        Subscription subscription = networkFacade.getCityList(new NetworkFacade.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                view.removeWait();
                view.getCityListSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}