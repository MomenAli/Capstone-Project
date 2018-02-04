package com.example.momenali.fitnesscoash.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momenali.fitnesscoash.R;
import com.example.momenali.fitnesscoash.excercise.Exercise;
import com.example.momenali.fitnesscoash.excercise.ExerciseRecyclerView;
import com.example.momenali.fitnesscoash.utils.JSONUtils;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Momen Ali on 2/3/2018.
 */

public class ExerciseFragment extends Fragment {
    private static final String TAG  = "ExerciseFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    ExerciseRecyclerView mExerciseAdapter;

    // TODO: Rename and change types of parameters
    private int muscleID;
    private String mParam2;
/*
    private OnFragmentInteractionListener mListener;*/

    public ExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment MusclesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExerciseFragment newInstance(int muscleID) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, muscleID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            muscleID = getArguments().getInt(ARG_PARAM1);
        }
        Log.d(TAG, "onCreate: " + muscleID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_exercises, container, false);

        // get the exercises from the jsonFile
        try {
            exercises = JSONUtils.getExercises(inflater.getContext(),muscleID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreateView: "+exercises.size());

        // set up the Muscles RecyclerView
        RecyclerView ExercisesRecycleView = (RecyclerView) rootView.findViewById(R.id.rvExercise);
        ExercisesRecycleView.setLayoutManager(new GridLayoutManager(container.getContext(),2));
        mExerciseAdapter = new ExerciseRecyclerView(container.getContext(), exercises);
        ExercisesRecycleView.setAdapter(mExerciseAdapter);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
/*    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

/*    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

 /*   @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     /*    *//*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}

