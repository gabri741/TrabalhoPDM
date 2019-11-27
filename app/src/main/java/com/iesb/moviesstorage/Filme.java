package com.iesb.moviesstorage;

import java.io.Serializable;

public class Filme implements Serializable {

    private final String titulo;
    private final String caminhoPoster;
    private final String overview;


    public Filme(String titulo, String caminhoPoster,String overview) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
        this.overview = overview;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getOverview() {
        return overview;
    }
}
