package com.example.momenali.fitnesscoash.excercise;

/**
 * Created by Momen Ali on 2/3/2018.
 */

public class Exercise {

    int id;
    String name;
    int avrage;
    String videoURL;
    String thumbnailURL;
    String information;
    String moreURL;
    int muscleID;

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

    public int getAvrage() {
        return avrage;
    }

    public void setAvrage(int avrage) {
        this.avrage = avrage;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getMoreURL() {
        return moreURL;
    }

    public void setMoreURL(String moreURL) {
        this.moreURL = moreURL;
    }

    public int getMuscleID() {
        return muscleID;
    }

    public void setMuscleID(int muscleID) {
        this.muscleID = muscleID;
    }
}
