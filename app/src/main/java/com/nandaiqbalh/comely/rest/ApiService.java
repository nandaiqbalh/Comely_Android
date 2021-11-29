package com.nandaiqbalh.comely.rest;

import com.nandaiqbalh.comely.utils.RegisterRequest;
import com.nandaiqbalh.comely.utils.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("user/register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

}
