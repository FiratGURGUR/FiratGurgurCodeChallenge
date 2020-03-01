package com.example.firatgurgurcodechallenge.Detail.CastAndCrew;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrewModel implements Parcelable {



    private String profile_path;
    private String name;
    private String job;
    private int id;
    private int gender;
    private String department;
    private String credit_id;

    public CrewModel(
            @JsonProperty("profile_path") String profile_path,
            @JsonProperty("name") String name,
            @JsonProperty("job")String job,
            @JsonProperty("id") int id,
            @JsonProperty("gender") int gender,
            @JsonProperty("department") String department,
            @JsonProperty("credit_id")  String credit_id) {
        this.profile_path = profile_path;
        this.name = name;
        this.job = job;
        this.id = id;
        this.gender = gender;
        this.department = department;
        this.credit_id = credit_id;
    }

    protected CrewModel(Parcel in) {
        profile_path = in.readString();
        name = in.readString();
        job = in.readString();
        id = in.readInt();
        gender = in.readInt();
        department = in.readString();
        credit_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(profile_path);
        dest.writeString(name);
        dest.writeString(job);
        dest.writeInt(id);
        dest.writeInt(gender);
        dest.writeString(department);
        dest.writeString(credit_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CrewModel> CREATOR = new Creator<CrewModel>() {
        @Override
        public CrewModel createFromParcel(Parcel in) {
            return new CrewModel(in);
        }

        @Override
        public CrewModel[] newArray(int size) {
            return new CrewModel[size];
        }
    };

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }
}
