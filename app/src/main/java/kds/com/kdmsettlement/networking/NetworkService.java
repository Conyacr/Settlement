package kds.com.kdmsettlement.networking;

import kds.com.kdmsettlement.models.CityListResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ryan on 8/3/2018.
 */

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();

}
