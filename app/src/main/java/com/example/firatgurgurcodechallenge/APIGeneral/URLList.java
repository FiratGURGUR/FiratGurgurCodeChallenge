package com.example.firatgurgurcodechallenge.APIGeneral;


import static com.example.firatgurgurcodechallenge.Detail.MovieDetail.movieId;

public class URLList {

    public static String API_KEY = "YOUR_API_KEY";
    public static String BASE_URL = "https://api.themoviedb.org/3/";
    public static String LOW_IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185/";
    public static String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original/";


    public static String MOVIE_POPULAR_URL = BASE_URL + "movie/popular?api_key="+API_KEY+"&page=";
    public static String MOVIE_TOP_RATED_URL = BASE_URL + "movie/top_rated?api_key="+API_KEY+"&page=";
    public static String MOVIE_NOW_PLAYING_URL = BASE_URL + "movie/now_playing?api_key="+API_KEY+"&page=";

    public static String TV_TOP_RATED_URL = BASE_URL + "tv/top_rated?api_key="+API_KEY+"&page=";
    public static String TV_POPULAR = BASE_URL + "tv/popular?api_key="+API_KEY+"&page=";


    public static String CREW_CAST_URL_FIRST = BASE_URL +  "movie/"; //(buraya Id eklenecek sonra aşağıdaki kısım eklenecek url oluşacak)
    public static String CREW_CAST_TV_URL_FIRST = BASE_URL +  "tv/"; //(buraya Id eklenecek sonra aşağıdaki kısım eklenecek url oluşacak)
    public static String CREW_CAST_URL_END =   "/credits?api_key=" + API_KEY ;

 }
