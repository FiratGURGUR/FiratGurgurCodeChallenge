package com.example.firatgurgurcodechallenge.Detail.CastAndCrew;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CastCrewModel implements Parcelable {

    private int id;
    private List<CastModel> castModels;
    private List<CrewModel> crewModels;

    public CastCrewModel(
            @JsonProperty("id")int id,
            @JsonProperty("cast")List<CastModel> castModels,
            @JsonProperty("crew")List<CrewModel> crewModels) {
        this.id = id;
        this.castModels = castModels;
        this.crewModels = crewModels;
    }

    protected CastCrewModel(Parcel in) {
        id = in.readInt();
        castModels = in.createTypedArrayList(CastModel.CREATOR);
        crewModels = in.createTypedArrayList(CrewModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeTypedList(castModels);
        dest.writeTypedList(crewModels);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CastCrewModel> CREATOR = new Creator<CastCrewModel>() {
        @Override
        public CastCrewModel createFromParcel(Parcel in) {
            return new CastCrewModel(in);
        }

        @Override
        public CastCrewModel[] newArray(int size) {
            return new CastCrewModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CastModel> getCastModels() {
        return castModels;
    }

    public void setCastModels(List<CastModel> castModels) {
        this.castModels = castModels;
    }

    public List<CrewModel> getCrewModels() {
        return crewModels;
    }

    public void setCrewModels(List<CrewModel> crewModels) {
        this.crewModels = crewModels;
    }



}
