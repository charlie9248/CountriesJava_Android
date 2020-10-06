package com.example.countriesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CountriesAdapter.SelectedCountry {

    JsonPlaceHolderAPI placeHolderAPI;
    RecyclerView recyclerView;CountriesAdapter countriesAdapter;
    ArrayList<Countries> countries;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.countries);
        progressBar =  findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/region/")
                .addConverterFactory(GsonConverterFactory.create())//Use Gson
                .build();

        placeHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);


        getCountries();
    }

    public void getCountries(){
        //Execute the Network request
        Call<List<Countries>> call = placeHolderAPI.getCountries();
        //Execute the request in a background thread
        call.enqueue(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code: " + response.code() , Toast.LENGTH_SHORT).show();
                    return;
                }
                if (response.body() != null){
                    //Get the
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new  LinearLayoutManager(MainActivity.this));
                    countries = new ArrayList<>(response.body());
                    countriesAdapter = new CountriesAdapter(MainActivity.this , countries);
                    recyclerView.setAdapter(countriesAdapter);
                    Toast.makeText(MainActivity.this, "Success: " , Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure: " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void countrySelected(int index) {

        List<Currency> currencies =  new ArrayList<>(countries.get(index).getCurrencies());
        List<Language> languages = new ArrayList<>(countries.get(index).getLanguages());




        Intent intent  = new Intent(MainActivity.this , CountryDetails.class);
        intent.putExtra("name" , countries.get(index).getName());
        intent.putExtra("flag" , countries.get(index).getFlag());
       intent.putExtra("population" , countries.get(index).getPopulation());
       intent.putExtra("language" ,  (Serializable) languages);



       intent.putExtra("currency" , (Serializable) currencies );
       intent.putExtra("subRegion" , countries.get(index).getSubregion());
       intent.putExtra("capital" , countries.get(index).getCapital());
       intent.putExtra("demonym" , countries.get(index).getDemonym());

        startActivity(intent);
    }
}