package kds.com.kdmsettlement.home;

import kds.com.kdmsettlement.models.CityListResponse;

/**
 * Created by Ryan on 8/3/2018.
 */

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCityListSuccess(CityListResponse cityListResponse);

}
