package com.example.firatgurgurcodechallenge.Movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieModel implements Parcelable {

    private double popularity;
    private int vote_count;
    private boolean video;
    private String poster_path;
    private int id;
    private boolean adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private int[] genre_ids;
    private String title;
    private double vote_average;
    private String overview;
    private String release_date;

    public MovieModel(@JsonProperty("popularity")double popularity,@JsonProperty("vote_count") int vote_count,
                      @JsonProperty("video")boolean video,@JsonProperty("poster_path") String poster_path,@JsonProperty("id") int id,
                      @JsonProperty("adult") boolean adult,@JsonProperty("backdrop_path") String backdrop_path,
                      @JsonProperty("original_language")String original_language,@JsonProperty("original_title") String original_title,
                      @JsonProperty("genre_ids") int[] genre_ids,@JsonProperty("title") String title,
                      @JsonProperty("vote_average")double vote_average,@JsonProperty("overview") String overview,
                      @JsonProperty("release_date")String release_date) {
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.video = video;
        this.poster_path = poster_path;
        this.id = id;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
    }

    protected MovieModel(Parcel in) {
        popularity = in.readDouble();
        vote_count = in.readInt();
        video = in.readByte() != 0;
        poster_path = in.readString();
        id = in.readInt();
        adult = in.readByte() != 0;
        backdrop_path = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        genre_ids = in.createIntArray();
        title = in.readString();
        vote_average = in.readDouble();
        overview = in.readString();
        release_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(popularity);
        dest.writeInt(vote_count);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeString(poster_path);
        dest.writeInt(id);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(backdrop_path);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeIntArray(genre_ids);
        dest.writeString(title);
        dest.writeDouble(vote_average);
        dest.writeString(overview);
        dest.writeString(release_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
