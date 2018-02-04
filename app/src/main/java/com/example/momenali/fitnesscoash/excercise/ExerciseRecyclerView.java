package com.example.momenali.fitnesscoash.excercise;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.momenali.fitnesscoash.R;
import com.example.momenali.fitnesscoash.body.Muscle;
import com.example.momenali.fitnesscoash.body.MusclesRecycleView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Momen Ali on 2/3/2018.
 */

public class ExerciseRecyclerView extends RecyclerView.Adapter<ExerciseRecyclerView.ViewHolder> {
    private static final String TAG = "ExerciseRecyclerView";
    ArrayList<Exercise> mExercise = new ArrayList<Exercise>();

    private LayoutInflater mInflater;
    private Context mContext;

    public ExerciseRecyclerView(Context context, ArrayList<Exercise> exercises) {
        mContext = context;
        mExercise = exercises;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ExerciseRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + mExercise.get(position).getName());
        Glide.with(mContext)
                .load(mExercise.get(position).getThumbnailURL())
                .into(holder.MuscleImage);
        Log.d(TAG, "onBindViewHolder: https://image.ibb.co/bL2Pg6/abs_Decline_Crunch.jpg");
        holder.MuscleTitle.setText(mExercise.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mExercise.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.ivListItem)
        ImageView MuscleImage;
        @BindView(R.id.tvListItem)
        TextView MuscleTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
