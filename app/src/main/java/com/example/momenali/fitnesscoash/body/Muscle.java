package com.example.momenali.fitnesscoash.body;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Momen Ali on 2/1/2018.
 */

public class Muscle{
    int id;
    String name;
    int ExerciseNumber;
    String imageUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExerciseNumber() {
        return ExerciseNumber;
    }

    public void setExerciseNumber(int exerciseNumber) {
        ExerciseNumber = exerciseNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}
