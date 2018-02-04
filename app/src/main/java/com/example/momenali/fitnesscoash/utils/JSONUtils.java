package com.example.momenali.fitnesscoash.utils;

import android.content.Context;
import android.util.Log;

import com.example.momenali.fitnesscoash.body.Muscle;
import com.example.momenali.fitnesscoash.excercise.Exercise;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Momen Ali on 2/1/2018.
 */

public class JSONUtils {
    private static final String exerciseFile = "ExerciseJSONFile.json";

    private static final String TAG = "JSONUtils";
    /* exercise json Object names */
    final static String OWN_NAME = "name";
    final static String OWN_ID = "id";
    final static String OWN_EXERCISE = "Exercise";
    final static String OWN_IMAGE = "image";
    final static String OWN_EXERCISE_ARRAY = "Exercises";

    final static String OWN_AVG = "Avg";
    final static String OWN_VIDEO = "video";
    final static String OWN_THUMBNAIL = "thumbnail";
    final static String OWN_INFORMATION = "information";
    final static String OWN_MOREURL = "moreURL";
    final static String OWN_EXERCISE_NAME = "Name";

    public static ArrayList getMuscles(Context context) throws JSONException {
        ArrayList<Muscle> mMuscleList = new ArrayList<Muscle>();
        String JSONStr = loadJSONFromAsset(context, exerciseFile);
        JSONArray musclesArray = new JSONArray(JSONStr);

        JSONObject muscleObject;
        for (int i = 0; i < musclesArray.length(); i++) {
            Muscle muscle = new Muscle();
            muscleObject = musclesArray.getJSONObject(i);
            muscle.setId(muscleObject.getInt(OWN_ID));
            muscle.setName(muscleObject.getString(OWN_NAME));
            muscle.setExerciseNumber(muscleObject.getInt(OWN_EXERCISE));
            muscle.setImageUrl(muscleObject.getString(OWN_IMAGE));
            mMuscleList.add(muscle);
        }
        return mMuscleList;
    }

/*
* this function returns all the exercises available
* */
    public static ArrayList getExercises(Context context) throws JSONException {
        ArrayList<Exercise> mExerciseList = new ArrayList<Exercise>();
        String JSONStr = loadJSONFromAsset(context, exerciseFile);
        JSONArray musclesArray = new JSONArray(JSONStr);

        Exercise exercise = new Exercise();
        JSONObject muscleObject;

        for (int i = 0; i < musclesArray.length(); i++) {
            muscleObject = musclesArray.getJSONObject(i);
            JSONArray exerciseArray = muscleObject.getJSONArray(OWN_EXERCISE_ARRAY);
            JSONObject exerciseObject = new JSONObject();
            for (int j = 0;j<exerciseArray.length();j++){
                exerciseObject = exerciseArray.getJSONObject(j);

                exercise.setId(exerciseObject.getInt(OWN_ID));
                exercise.setAvrage(exerciseObject.getInt(OWN_AVG));
                exercise.setInformation(exerciseObject.getString(OWN_INFORMATION));
                exercise.setMoreURL(exerciseObject.getString(OWN_MOREURL));
                exercise.setName(exerciseObject.getString(OWN_NAME));
                exercise.setMuscleID(i);
                exercise.setVideoURL(exerciseObject.getString(OWN_VIDEO));
                exercise.setThumbnailURL(exerciseObject.getString(OWN_THUMBNAIL));
                mExerciseList.add(exercise);
            }

        }
        return mExerciseList;
    }

    /*
 * this function returns all the exercises available for the muscle have the id passed
 * */
    public static ArrayList getExercises(Context context, int muscleID) throws JSONException {
        ArrayList<Exercise> mExerciseList = new ArrayList<Exercise>();
        String JSONStr = loadJSONFromAsset(context, exerciseFile);
        JSONArray musclesArray = new JSONArray(JSONStr);

        JSONObject muscleObject;

        for (int i = 0; i < musclesArray.length(); i++) {

            muscleObject = musclesArray.getJSONObject(i);
            Log.d(TAG, "getExercises: r "+muscleID);
            Log.d(TAG, "getExercises: "+muscleObject.getInt(OWN_ID));
            if (muscleObject.getInt(OWN_ID) == muscleID) {
                Log.d(TAG, "getExercises: in");
                JSONArray exerciseArray = muscleObject.getJSONArray(OWN_EXERCISE_ARRAY);
                Log.d(TAG, "getExercises: len " + exerciseArray.length());
                JSONObject exerciseObject = new JSONObject();
                for (int j = 0; j < exerciseArray.length(); j++) {
                    Log.d(TAG, "getExercises: "+j);
                    exerciseObject = exerciseArray.getJSONObject(j);
                    Log.d(TAG, "getExercises: "+j);
                    Exercise exercise = new Exercise();
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setId(exerciseObject.getInt(OWN_ID));
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setAvrage(exerciseObject.getInt(OWN_AVG));
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setInformation(exerciseObject.getString(OWN_INFORMATION));
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setMoreURL(exerciseObject.getString(OWN_MOREURL));
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setName(exerciseObject.getString(OWN_EXERCISE_NAME));
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setMuscleID(i);
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setVideoURL(exerciseObject.getString(OWN_VIDEO));
                    Log.d(TAG, "getExercises: "+j);
                    exercise.setThumbnailURL(exerciseObject.getString(OWN_THUMBNAIL));
                    Log.d(TAG, "getExercises: "+j);
                    mExerciseList.add(exercise);
                    Log.d(TAG, "getExercises: "+j);
                }
            }
        }
        Log.d(TAG, "getExercises: out");
        return mExerciseList;
    }

    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
