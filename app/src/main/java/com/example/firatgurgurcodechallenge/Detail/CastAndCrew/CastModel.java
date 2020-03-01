package com.example.firatgurgurcodechallenge.Detail.CastAndCrew;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class CastModel implements Parcelable {

    private String profile_path;
    private int order;
    private String name;
    private int id;
    private int gender;
    private String credit_id;
    private String character;
    private int cast_id;

    public CastModel( @JsonProperty("profile_path")String profile_path,
                      @JsonProperty("order") int order,
                      @JsonProperty("name") String name,
                      @JsonProperty("id") int id,
                      @JsonProperty("gender") int gender,
                      @JsonProperty("credit_id") String credit_id,
                      @JsonProperty("character")  String character,
                      @JsonProperty("cast_id")  int cast_id) {
        this.profile_path = profile_path;
        this.order = order;
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.credit_id = credit_id;
        this.character = character;
        this.cast_id = cast_id;
    }

    protected CastModel(Parcel in) {
        profile_path = in.readString();
        order = in.readInt();
        name = in.readString();
        id = in.readInt();
        gender = in.readInt();
        credit_id = in.readString();
        character = in.readString();
        cast_id = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(profile_path);
        dest.writeInt(order);
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeInt(gender);
        dest.writeString(credit_id);
        dest.writeString(character);
        dest.writeInt(cast_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CastModel> CREATOR = new Creator<CastModel>() {
        @Override
        public CastModel createFromParcel(Parcel in) {
            return new CastModel(in);
        }

        @Override
        public CastModel[] newArray(int size) {
            return new CastModel[size];
        }
    };

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getCast_id() {
        return cast_id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }
}
