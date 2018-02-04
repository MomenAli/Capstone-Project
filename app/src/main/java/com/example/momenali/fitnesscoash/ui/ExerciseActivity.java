package com.example.momenali.fitnesscoash.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.momenali.fitnesscoash.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExerciseActivity extends AppCompatActivity {
    private static final String TAG = "ExerciseActivity";
    @BindView(R.id.exercise_container)
    FrameLayout exerciseContainer;

    ExerciseFragment exerciseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);


        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Log.d(TAG, "onCreate: " + extras.getInt(MusclesFragment.EXTRA_KEY_MUSCLE_ID));
        exerciseFragment = ExerciseFragment.newInstance(extras.getInt(MusclesFragment.EXTRA_KEY_MUSCLE_ID));


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.exercise_container, exerciseFragment)
                .commit();

    }
}
