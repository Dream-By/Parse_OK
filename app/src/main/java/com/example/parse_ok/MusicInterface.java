package com.example.parse_ok;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicInterface {

    @GET("/2.0/")
    Call <Artist> getArtist (@Query("method") String method, @Query("artist") String artist, @Query("api_key") String API_KEY, @Query("format") String format);

}
