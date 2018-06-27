package com.zcmx.bit.data.network.api;

import com.zcmx.bit.data.network.api.response.CarResponse;
import com.zcmx.bit.data.network.api.response.UserResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("mobileAPI.php")
    Flowable<CarResponse> getCars(@Query("action") String action);


    @GET("mobileAPI.php")
    Flowable<UserResponse> getUsers(@Query("action") String action);

}
