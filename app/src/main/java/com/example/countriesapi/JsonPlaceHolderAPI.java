package com.example.countriesapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    @GET("africa")
    Call<List<Countries>> getCountries();
}
