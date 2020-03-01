package com.example.firatgurgurcodechallenge.APIGeneral;

import android.os.Handler;

import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CastCrewModel;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CastModel;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CrewModel;
import com.example.firatgurgurcodechallenge.Movies.MModel;
import com.example.firatgurgurcodechallenge.Movies.MovieModel;
import com.example.firatgurgurcodechallenge.Tv.TTModel;
import com.example.firatgurgurcodechallenge.Tv.TvModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class APIClass {

    //Popüler Filmleri Getiren metod
    public void getPopularMovies(final Handler hnd, final int page){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.MOVIE_POPULAR_URL+String.valueOf(page));

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        if(jg.has("results")){
                            ObjectMapper mapper = new ObjectMapper();
                            List<MovieModel> model = mapper.readValue(jg.getString("results"), new TypeReference<List<MovieModel>>(){});
                            hnd.obtainMessage(1,model).sendToTarget();
                        }else{
                            hnd.obtainMessage(0,"Server Fail").sendToTarget();
                        }
                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }

    //TopRated filmleri getiren metod
    public void getTopRatedMovies(final Handler hnd, final int page){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.MOVIE_TOP_RATED_URL+String.valueOf(page));

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        if(jg.has("results")){
                            ObjectMapper mapper = new ObjectMapper();
                            List<MovieModel> model = mapper.readValue(jg.getString("results"), new TypeReference<List<MovieModel>>(){});
                            hnd.obtainMessage(2,model).sendToTarget();
                        }else{
                            hnd.obtainMessage(0,"Server Fail").sendToTarget();
                        }
                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }
    //now playing filmleri geitren metod
    public void getNowPlayingMovies(final Handler hnd, final int page){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.MOVIE_NOW_PLAYING_URL+String.valueOf(page));

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        if(jg.has("results")){
                            ObjectMapper mapper = new ObjectMapper();
                            List<MovieModel> model = mapper.readValue(jg.getString("results"), new TypeReference<List<MovieModel>>(){});
                            hnd.obtainMessage(3,model).sendToTarget();
                        }else{
                            hnd.obtainMessage(0,"Server Fail").sendToTarget();
                        }
                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }

    //top rated tv leri getiren metod
    public void getTopRatedTv(final Handler hnd, final int page){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.TV_TOP_RATED_URL+String.valueOf(page));

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        if(jg.has("results")){
                            ObjectMapper mapper = new ObjectMapper();
                            List<TvModel> model = mapper.readValue(jg.getString("results"), new TypeReference<List<TvModel>>(){});
                            hnd.obtainMessage(1,model).sendToTarget();
                        }else{
                            hnd.obtainMessage(0,"Server Fail").sendToTarget();
                        }
                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }
    //Populer tv leri getiren metod
    public void getPopularTv(final Handler hnd, final int page){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.TV_POPULAR+String.valueOf(page));

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        if(jg.has("results")){
                            ObjectMapper mapper = new ObjectMapper();
                            List<TvModel> model = mapper.readValue(jg.getString("results"), new TypeReference<List<TvModel>>(){});
                            hnd.obtainMessage(2,model).sendToTarget();
                        }else{
                            hnd.obtainMessage(0,"Server Fail").sendToTarget();
                        }
                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }

    //film detayı getiren metod
    public void getMovieDetail(final Handler hnd, final int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.BASE_URL + "movie/"+ id +"?api_key=" + URLList.API_KEY);

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);

                            ObjectMapper mapper = new ObjectMapper();
                            MModel model = mapper.readValue(sonuc, MModel.class);
                            hnd.obtainMessage(1,model).sendToTarget();

                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }

    //film Cast ve crew getiren metod
    public void getCastAndCrew(final Handler hnd, final int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.CREW_CAST_URL_FIRST+ id + URLList.CREW_CAST_URL_END );

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        int id = jg.getInt("id");
                        ObjectMapper mapper = new ObjectMapper();
                        List<CastModel> castModel = mapper.readValue(jg.getString("cast"), new TypeReference<List<CastModel>>(){});
                        List<CrewModel> crewModel = mapper.readValue(jg.getString("crew"), new TypeReference<List<CrewModel>>(){});
                        CastCrewModel sumModel = new CastCrewModel(id,castModel,crewModel);


                        hnd.obtainMessage(3,sumModel).sendToTarget();

                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }

    //tv cast ve crew getiren metod
    public void getTVCastAndCrew(final Handler hnd, final int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.CREW_CAST_TV_URL_FIRST+ id + URLList.CREW_CAST_URL_END );

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);
                        int id = jg.getInt("id");
                        ObjectMapper mapper = new ObjectMapper();
                        List<CastModel> castModel = mapper.readValue(jg.getString("cast"), new TypeReference<List<CastModel>>(){});
                        List<CrewModel> crewModel = mapper.readValue(jg.getString("crew"), new TypeReference<List<CrewModel>>(){});
                        CastCrewModel sumModel = new CastCrewModel(id,castModel,crewModel);


                        hnd.obtainMessage(3,sumModel).sendToTarget();

                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }

    //tv detay getiren metod
    public void getTvDetail(final Handler hnd, final int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sonuc=HttpPostJson.GetHttp(URLList.BASE_URL + "tv/"+ id +"?api_key=" + URLList.API_KEY);

                if(sonuc!=null && !sonuc.isEmpty()){
                    try {
                        JSONObject jg = new JSONObject(sonuc);

                        ObjectMapper mapper = new ObjectMapper();
                        TTModel model = mapper.readValue(sonuc, TTModel.class);
                        hnd.obtainMessage(1,model).sendToTarget();

                    } catch (JSONException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonParseException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (JsonMappingException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    } catch (IOException e) {
                        hnd.obtainMessage(0,"Json Parse Hatası").sendToTarget();
                    }
                }else{
                    hnd.obtainMessage(0,"Server Hatası").sendToTarget();
                }
            }
        }).start();
    }


}
