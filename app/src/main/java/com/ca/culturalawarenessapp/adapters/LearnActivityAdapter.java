package com.ca.culturalawarenessapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ca.culturalawarenessapp.R;
import com.ca.culturalawarenessapp.datamodels.LearnDataModel;

import java.util.ArrayList;

/*
    Author : Rushabh Picha
 */
public class LearnActivityAdapter extends RecyclerView.Adapter<LearnActivityAdapter.ListViewHolder> {

    ArrayList<LearnDataModel> learnDataModels;
    Context context;
    public LearnActivityAdapter(ArrayList<LearnDataModel> learnDataModels, Context context){
        this.context = context;
        this.learnDataModels = learnDataModels;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_learn, null,true);
//        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
//        view.startAnimation(animation);
        return new ListViewHolder(view, context, learnDataModels);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        LearnDataModel learnDataModel = learnDataModels.get(position);
        System.out.println("Culture Info" +learnDataModel.getInfo());
        holder.info.setText("• " +learnDataModel.getInfo());
    }

    @Override
    public int getItemCount() {
        return learnDataModels.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView info;
        Context context;
        ArrayList<LearnDataModel> learnDataModels;
        public ListViewHolder(@NonNull View itemView, Context context, ArrayList<LearnDataModel> learnDataModels) {
            super(itemView);
            this.context = context;
            this.learnDataModels = learnDataModels;
            info = itemView.findViewById(R.id.info_textview);
        }
    }
}
