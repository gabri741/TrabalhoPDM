package com.iesb.moviesstorage;

import java.util.ArrayList;
import java.util.List;



public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse) {
        List<Filme> listaFilmes = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmeResponse) {
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster(),filmeResponse.getOverview());
            listaFilmes.add(filme);
        }

        return listaFilmes;
    }
}