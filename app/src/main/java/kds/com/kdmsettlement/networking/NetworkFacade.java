package kds.com.kdmsettlement.networking;

import io.reactivex.Single;
import kds.com.kdmsettlement.models.CityListResponse;

/**
 * Created by Ryan on 8/3/2018.
 */

public class NetworkFacade {
    private final NetworkService networkService;

    public NetworkFacade(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Single<CityListResponse> getCityList() {
        return networkService.getCityListSingle();
    }

    public interface GetCityListCallback {
        void onSuccess(CityListResponse cityListResponse);

        void onError(NetworkError networkError);
    }
}
