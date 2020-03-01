package com.example.firatgurgurcodechallenge.Movies;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public  class MModel {


    @JsonProperty("vote_count")
    private int vote_count;
    @JsonProperty("vote_average")
    private double vote_average;
    @JsonProperty("video")
    private boolean video;
    @JsonProperty("title")
    private String title;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("status")
    private String status;
    @JsonProperty("spoken_languages")
    private List<Spoken_languages> spoken_languages;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("revenue")
    private int revenue;
    @JsonProperty("release_date")
    private String release_date;
    @JsonProperty("production_countries")
    private List<Production_countries> production_countries;
    @JsonProperty("production_companies")
    private List<Production_companies> production_companies;
    @JsonProperty("poster_path")
    private String poster_path;
    @JsonProperty("popularity")
    private double popularity;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("original_title")
    private String original_title;
    @JsonProperty("original_language")
    private String original_language;
    @JsonProperty("imdb_id")
    private String imdb_id;
    @JsonProperty("id")
    private int id;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("genres")
    private List<Genres> genres;
    @JsonProperty("budget")
    private int budget;
    @JsonProperty("belongs_to_collection")
    private Belongs_to_collection belongs_to_collection;
    @JsonProperty("backdrop_path")
    private String backdrop_path;
    @JsonProperty("adult")
    private boolean adult;

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Spoken_languages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<Spoken_languages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Production_countries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<Production_countries> production_countries) {
        this.production_countries = production_countries;
    }

    public List<Production_companies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Production_companies> production_companies) {
        this.production_companies = production_companies;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Belongs_to_collection getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Belongs_to_collection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public static class Spoken_languages {
        @JsonProperty("name")
        private String name;
        @JsonProperty("iso_639_1")
        private String iso_639_1;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }
    }

    public static class Production_countries {
        @JsonProperty("name")
        private String name;
        @JsonProperty("iso_3166_1")
        private String iso_3166_1;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }
    }

    public static class Production_companies {
        @JsonProperty("origin_country")
        private String origin_country;
        @JsonProperty("name")
        private String name;
        @JsonProperty("logo_path")
        private String logo_path;
        @JsonProperty("id")
        private int id;

        public String getOrigin_country() {
            return origin_country;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class Genres {
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private int id;

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
    }

    public static class Belongs_to_collection {
        @JsonProperty("backdrop_path")
        private String backdrop_path;
        @JsonProperty("poster_path")
        private String poster_path;
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private int id;

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
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
    }


    @Override
    public String toString() {
        return "MModel{" +
                "vote_count=" + vote_count +
                ", vote_average=" + vote_average +
                ", video=" + video +
                ", title='" + title + '\'' +
                ", tagline='" + tagline + '\'' +
                ", status='" + status + '\'' +
                ", spoken_languages=" + spoken_languages +
                ", runtime=" + runtime +
                ", revenue=" + revenue +
                ", release_date='" + release_date + '\'' +
                ", production_countries=" + production_countries +
                ", production_companies=" + production_companies +
                ", poster_path='" + poster_path + '\'' +
                ", popularity=" + popularity +
                ", overview='" + overview + '\'' +
                ", original_title='" + original_title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", id=" + id +
                ", homepage='" + homepage + '\'' +
                ", genres=" + genres +
                ", budget=" + budget +
                ", belongs_to_collection=" + belongs_to_collection +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", adult=" + adult +
                '}';
    }
}
