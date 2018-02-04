package com.example.momenali.fitnesscoash.body;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.momenali.fitnesscoash.R;
import com.example.momenali.fitnesscoash.ui.MusclesFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Momen Ali on 2/1/2018.
 */

public class MusclesRecycleView extends RecyclerView.Adapter<MusclesRecycleView.ViewHolder> {
    private static final String TAG = "MusclesRecycleView";
    OnMusclesRecyclerViewClickedListener mClickListner;
    ArrayList<Muscle> mMuscle = new ArrayList<Muscle>();

    private LayoutInflater mInflater;
    private Context mContext;

    public MusclesRecycleView(Context context, ArrayList<Muscle> muscles) {
        mContext = context;
        mMuscle = muscles;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.muscle_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int resID = mContext.getResources().getIdentifier(mMuscle.get(position).getImageUrl(), "drawable", mContext.getPackageName());
        holder.MuscleImage.setImageResource(resID);
        holder.MuscleTitle.setText(mMuscle.get(position).getName());
        holder.exerciseNumber.setText(String.valueOf(mMuscle.get(position).getExerciseNumber()));
    }
    @Override
    public int getItemCount() {
        return mMuscle.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.ivListItem)
        ImageView MuscleImage;
        @BindView(R.id.tvListItem)
        TextView MuscleTitle;
        @BindView(R.id.exercise_number)
        TextView exerciseNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
                mClickListner.onRecyclerViewClicked(getAdapterPosition());
        }
    }

    public void setmClickListner(OnMusclesRecyclerViewClickedListener mClickListner) {
        this.mClickListner = mClickListner;
    }

    public interface OnMusclesRecyclerViewClickedListener {
        // TODO: Update argument type and name
        void onRecyclerViewClicked(int position);
    }
}
