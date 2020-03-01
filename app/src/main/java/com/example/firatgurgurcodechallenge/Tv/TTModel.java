package com.example.firatgurgurcodechallenge.Tv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "credit_id",
        "name",
        "gender",
        "profile_path"
})
 class CreatedBy {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("credit_id")
    private String creditId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("profile_path")
    private String profilePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("credit_id")
    public String getCreditId() {
        return creditId;
    }

    @JsonProperty("credit_id")
    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("gender")
    public Integer getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty("profile_path")
    public String getProfilePath() {
        return profilePath;
    }

    @JsonProperty("profile_path")
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}






@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "air_date",
        "episode_number",
        "id",
        "name",
        "overview",
        "production_code",
        "season_number",
        "show_id",
        "still_path",
        "vote_average",
        "vote_count"
})
 class LastEpisodeToAir {

    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("episode_number")
    private Integer episodeNumber;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("production_code")
    private String productionCode;
    @JsonProperty("season_number")
    private Integer seasonNumber;
    @JsonProperty("show_id")
    private Integer showId;
    @JsonProperty("still_path")
    private Object stillPath;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("air_date")
    public String getAirDate() {
        return airDate;
    }

    @JsonProperty("air_date")
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    @JsonProperty("episode_number")
    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    @JsonProperty("episode_number")
    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("production_code")
    public String getProductionCode() {
        return productionCode;
    }

    @JsonProperty("production_code")
    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    @JsonProperty("season_number")
    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    @JsonProperty("season_number")
    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @JsonProperty("show_id")
    public Integer getShowId() {
        return showId;
    }

    @JsonProperty("show_id")
    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    @JsonProperty("still_path")
    public Object getStillPath() {
        return stillPath;
    }

    @JsonProperty("still_path")
    public void setStillPath(Object stillPath) {
        this.stillPath = stillPath;
    }

    @JsonProperty("vote_average")
    public Double getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @JsonProperty("vote_count")
    public Integer getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "id",
        "logo_path",
        "origin_country"
})
 class Network {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("logo_path")
    private String logoPath;
    @JsonProperty("origin_country")
    private String originCountry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("logo_path")
    public String getLogoPath() {
        return logoPath;
    }

    @JsonProperty("logo_path")
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @JsonProperty("origin_country")
    public String getOriginCountry() {
        return originCountry;
    }

    @JsonProperty("origin_country")
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "air_date",
        "episode_number",
        "id",
        "name",
        "overview",
        "production_code",
        "season_number",
        "show_id",
        "still_path",
        "vote_average",
        "vote_count"
})
 class NextEpisodeToAir {

    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("episode_number")
    private Integer episodeNumber;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("production_code")
    private String productionCode;
    @JsonProperty("season_number")
    private Integer seasonNumber;
    @JsonProperty("show_id")
    private Integer showId;
    @JsonProperty("still_path")
    private Object stillPath;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("air_date")
    public String getAirDate() {
        return airDate;
    }

    @JsonProperty("air_date")
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    @JsonProperty("episode_number")
    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    @JsonProperty("episode_number")
    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("production_code")
    public String getProductionCode() {
        return productionCode;
    }

    @JsonProperty("production_code")
    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    @JsonProperty("season_number")
    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    @JsonProperty("season_number")
    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @JsonProperty("show_id")
    public Integer getShowId() {
        return showId;
    }

    @JsonProperty("show_id")
    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    @JsonProperty("still_path")
    public Object getStillPath() {
        return stillPath;
    }

    @JsonProperty("still_path")
    public void setStillPath(Object stillPath) {
        this.stillPath = stillPath;
    }

    @JsonProperty("vote_average")
    public Double getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @JsonProperty("vote_count")
    public Integer getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "logo_path",
        "name",
        "origin_country"
})
 class ProductionCompany {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("logo_path")
    private String logoPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("origin_country")
    private String originCountry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("logo_path")
    public String getLogoPath() {
        return logoPath;
    }

    @JsonProperty("logo_path")
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("origin_country")
    public String getOriginCountry() {
        return originCountry;
    }

    @JsonProperty("origin_country")
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "air_date",
        "episode_count",
        "id",
        "name",
        "overview",
        "poster_path",
        "season_number"
})
class Season {

    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("episode_count")
    private Integer episodeCount;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("season_number")
    private Integer seasonNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("air_date")
    public String getAirDate() {
        return airDate;
    }

    @JsonProperty("air_date")
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    @JsonProperty("episode_count")
    public Integer getEpisodeCount() {
        return episodeCount;
    }

    @JsonProperty("episode_count")
    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @JsonProperty("season_number")
    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    @JsonProperty("season_number")
    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "backdrop_path",
        "created_by",
        "episode_run_time",
        "first_air_date",
        "genres",
        "homepage",
        "id",
        "in_production",
        "languages",
        "last_air_date",
        "last_episode_to_air",
        "name",
        "next_episode_to_air",
        "networks",
        "number_of_episodes",
        "number_of_seasons",
        "origin_country",
        "original_language",
        "original_name",
        "overview",
        "popularity",
        "poster_path",
        "production_companies",
        "seasons",
        "status",
        "type",
        "vote_average",
        "vote_count"
})
public class TTModel {

    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("created_by")
    private List<CreatedBy> createdBy = null;
    @JsonProperty("episode_run_time")
    private List<Integer> episodeRunTime = null;
    @JsonProperty("first_air_date")
    private String firstAirDate;
    @JsonProperty("genres")
    private List<Genre> genres = null;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("in_production")
    private Boolean inProduction;
    @JsonProperty("languages")
    private List<String> languages = null;
    @JsonProperty("last_air_date")
    private String lastAirDate;
    @JsonProperty("last_episode_to_air")
    private LastEpisodeToAir lastEpisodeToAir;
    @JsonProperty("name")
    private String name;
    @JsonProperty("next_episode_to_air")
    private NextEpisodeToAir nextEpisodeToAir;
    @JsonProperty("networks")
    private List<Network> networks = null;
    @JsonProperty("number_of_episodes")
    private Integer numberOfEpisodes;
    @JsonProperty("number_of_seasons")
    private Integer numberOfSeasons;
    @JsonProperty("origin_country")
    private List<String> originCountry = null;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_name")
    private String originalName;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("production_companies")
    private List<ProductionCompany> productionCompanies = null;
    @JsonProperty("seasons")
    private List<Season> seasons = null;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("backdrop_path")
    public String getBackdropPath() {
        return backdropPath;
    }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    @JsonProperty("created_by")
    public List<CreatedBy> getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(List<CreatedBy> createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("episode_run_time")
    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    @JsonProperty("episode_run_time")
    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    @JsonProperty("first_air_date")
    public String getFirstAirDate() {
        return firstAirDate;
    }

    @JsonProperty("first_air_date")
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    @JsonProperty("genres")
    public List<Genre> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @JsonProperty("homepage")
    public String getHomepage() {
        return homepage;
    }

    @JsonProperty("homepage")
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("in_production")
    public Boolean getInProduction() {
        return inProduction;
    }

    @JsonProperty("in_production")
    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @JsonProperty("last_air_date")
    public String getLastAirDate() {
        return lastAirDate;
    }

    @JsonProperty("last_air_date")
    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    @JsonProperty("last_episode_to_air")
    public LastEpisodeToAir getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    @JsonProperty("last_episode_to_air")
    public void setLastEpisodeToAir(LastEpisodeToAir lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("next_episode_to_air")
    public NextEpisodeToAir getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }

    @JsonProperty("next_episode_to_air")
    public void setNextEpisodeToAir(NextEpisodeToAir nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }

    @JsonProperty("networks")
    public List<Network> getNetworks() {
        return networks;
    }

    @JsonProperty("networks")
    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    @JsonProperty("number_of_episodes")
    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    @JsonProperty("number_of_episodes")
    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @JsonProperty("number_of_seasons")
    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    @JsonProperty("number_of_seasons")
    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    @JsonProperty("origin_country")
    public List<String> getOriginCountry() {
        return originCountry;
    }

    @JsonProperty("origin_country")
    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    @JsonProperty("original_language")
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @JsonProperty("original_language")
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    @JsonProperty("original_name")
    public String getOriginalName() {
        return originalName;
    }

    @JsonProperty("original_name")
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("popularity")
    public Double getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @JsonProperty("production_companies")
    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    @JsonProperty("production_companies")
    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    @JsonProperty("seasons")
    public List<Season> getSeasons() {
        return seasons;
    }

    @JsonProperty("seasons")
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("vote_average")
    public Double getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @JsonProperty("vote_count")
    public Integer getVoteCount() {
        return voteCount;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name"
    })
    public static class Genre {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
