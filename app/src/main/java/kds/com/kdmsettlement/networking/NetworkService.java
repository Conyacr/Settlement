package kds.com.kdmsettlement.networking;

import io.reactivex.Single;
import kds.com.kdmsettlement.models.CityListResponse;
import retrofit2.http.GET;

/**
 * Created by Ryan on 8/3/2018.
 */

public interface NetworkService {

    @GET("v1/city")
    Single<CityListResponse> getCityListSingle();

}
