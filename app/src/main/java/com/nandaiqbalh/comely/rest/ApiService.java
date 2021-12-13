package com.nandaiqbalh.comely.rest;

import com.nandaiqbalh.comely.model.register.RegisterRequest;
import com.nandaiqbalh.comely.model.register.RegisterResponse;
import com.nandaiqbalh.comely.model.userlogin.LoginRequest;
import com.nandaiqbalh.comely.model.userlogin.LoginResponse;
import com.nandaiqbalh.comely.model.userupdate.UpdateUserRequest;
import com.nandaiqbalh.comely.model.userupdate.UpdateUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("user/register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @POST("user/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("user/update")
    Call<UpdateUserResponse> updateUser(@Body UpdateUserRequest updateUserRequest);

}
