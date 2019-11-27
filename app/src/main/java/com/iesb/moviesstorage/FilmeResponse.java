package com.iesb.moviesstorage;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "original_title")
    private final String tituloOriginal;

    @Json(name = "overview")
    private final String overview;



    public FilmeResponse(String caminhoPoster, String tituloOriginal,String overview) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
        this.overview = overview;

    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getOverview() {
        return overview;
    }
}
