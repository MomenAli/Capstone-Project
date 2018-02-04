package com.example.momenali.fitnesscoash.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momenali.fitnesscoash.utils.JSONUtils;
import com.example.momenali.fitnesscoash.R;
import com.example.momenali.fitnesscoash.body.Muscle;
import com.example.momenali.fitnesscoash.body.MusclesRecycleView;

import org.json.JSONException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MusclesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusclesFragment extends Fragment implements MusclesRecycleView.OnMusclesRecyclerViewClickedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public static final String EXTRA_KEY_MUSCLE_ID  = "muscleID";
    ArrayList<Muscle> muscles = new ArrayList<Muscle>();
    MusclesRecycleView mMusclesAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
/*
    private OnFragmentInteractionListener mListener;*/

    public MusclesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusclesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusclesFragment newInstance(String param1, String param2) {
        MusclesFragment fragment = new MusclesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_muscles, container, false);

        // get the muscles from the jsonFile
        try {
            muscles = JSONUtils.getMuscles(inflater.getContext());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // set up the Muscles RecyclerView
        RecyclerView musclesRecycleView = (RecyclerView) rootView.findViewById(R.id.rvMuscles);
        musclesRecycleView.setLayoutManager(new GridLayoutManager(container.getContext(),2));
        mMusclesAdapter = new MusclesRecycleView(container.getContext(), muscles);
        musclesRecycleView.setAdapter(mMusclesAdapter);
        mMusclesAdapter.setmClickListner(this);
        return rootView;
    }

    @Override
    public void onRecyclerViewClicked(int position) {

        Intent intent = new Intent(getActivity(),ExerciseActivity.class);

        Bundle extra = new Bundle();
        extra.putInt(EXTRA_KEY_MUSCLE_ID,muscles.get(position).getId());
        intent.putExtras(extra);
        getActivity().startActivity(intent);
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

   /*
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.*/


}
