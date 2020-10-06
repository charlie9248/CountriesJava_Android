package com.example.countriesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CountryDetails extends AppCompatActivity {

    TextView tvName , tvLanguages , tvPopulation , tvCurrency,tvSubRegion , tvCapital , tvArea;
    ImageView imageFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);


        imageFlag = findViewById(R.id.imgCountry);
        tvName =  findViewById(R.id.tvName);
        tvCurrency =  findViewById(R.id.tvCurrencies);
        tvLanguages =  findViewById(R.id.tvLanguages);
        tvPopulation =  findViewById(R.id.tvPopulation);
        tvSubRegion =  findViewById(R.id.tvSubregion);
        tvCapital =  findViewById(R.id.tvCapital);
        tvArea =  findViewById(R.id.tvArea);


        Intent i = getIntent();
        List<Language>  languageList= (List<Language>) i.getSerializableExtra("language");
        List<Currency>  list= (List<Currency>) i.getSerializableExtra("currency");



        String name =  getIntent().getStringExtra("name");
        String flag =  getIntent().getStringExtra("flag");
        int population =  getIntent().getIntExtra("population"  , 0);
        String subRegion =  getIntent().getStringExtra("subRegion");
       String capital =  getIntent().getStringExtra("capital");
        String demonym =  getIntent().getStringExtra("demonym");



        Utils.fetchSvg(CountryDetails.this, flag, imageFlag);
        tvName.setText( "Country : "  + name);
        tvPopulation.setText("Population : "  + population);
        tvSubRegion.setText("SubREgion : "  +subRegion);
        tvCapital.setText("Capital City : "  +capital);
        tvArea.setText("demonym : "  + demonym);


        StringBuilder languages = new StringBuilder();

        for(int k = 0 ; k < languageList.size() ;  k++){

            languages.append(languageList.get(k).name + "\n");
        }

        StringBuilder currencies = new StringBuilder();

        for(int k = 0 ; k < list.size() ;  k++){

            currencies.append(list.get(k).name + "\n");
        }

        tvLanguages.setText(languages);

        tvCurrency.setText("Currencies : " + currencies);







    }
}