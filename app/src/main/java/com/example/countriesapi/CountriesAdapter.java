package com.example.countriesapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {


    private Context context;
    private  ArrayList<Countries> countryList;
    private  SelectedCountry activity;




    public interface SelectedCountry {
        void countrySelected(int index);
    }


    public CountriesAdapter(Context context , ArrayList<Countries> countryList) {
        this.context = context;
        activity = (SelectedCountry) context;
        this.countryList = countryList;

    }


    public    class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageCountry;
        TextView countryName ,   population;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageCountry  = itemView.findViewById(R.id.imageCountry);
            countryName  = itemView.findViewById(R.id.countryName);
            population  = itemView.findViewById(R.id.countryPopulation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Toast.makeText(context, countryList.indexOf(view.getTag())., Toast.LENGTH_SHORT).show();
                   activity.countrySelected(countryList.indexOf(view.getTag()));
                }
            });
        }
    }


    @NonNull
    @Override
    public CountriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_list,  parent ,  false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.ViewHolder holder, int position) {
        Utils.fetchSvg(context, countryList.get(position).getFlag(), holder.imageCountry);
        holder.countryName.setText(countryList.get(position).getName());
        holder.population.setText(countryList.get(position).getSubregion());
        holder.itemView.setTag(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
