package com.example.hitassignee2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
       CardView cardView;
       TextView textViewName;
       TextView textViewVersion;
       ImageView imageViewIcon;

       public MyViewHolder (View itemView )
       {
           super(itemView);
           cardView = (CardView) itemView.findViewById(R.id.card_view);
           textViewName = ( TextView) itemView.findViewById(R.id.card_textName);
           textViewVersion = ( TextView) itemView.findViewById(R.id.card_textDescription);
           imageViewIcon = (ImageView) itemView.findViewById(R.id.card_imageView);
       }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {
        TextView textViewName = viewHolder.textViewName;
        TextView textViewVersion = viewHolder.textViewVersion;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        // The dataset parameters:
        String name = dataSet.get(listPosition).getName();
        String desc = dataSet.get(listPosition).getDescription();
        int image = dataSet.get(listPosition).getImage();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("IMAGE", image);
                bundle.putString("NAME", name);
                bundle.putString("DESC", desc);
                Navigation.findNavController(view).navigate(R.id.action_listFragment_to_showFragment, bundle);
            }
        });
        textViewName.setText(name);
        textViewVersion.setText(ShortenDescription(desc));
        imageView.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private String ShortenDescription(String desctiption){
        int maxLength = 30;
        if (desctiption.length() > maxLength){
            return desctiption.substring(0, maxLength) + "...";
        }
        return desctiption;
    }
}


