package br.com.desafio.api.repository;

import br.com.desafio.api.filmsDTO.FilmesDTO;

import java.util.List;

public interface FilmeCacheRepository {

    FilmesDTO save(FilmesDTO filme);

    List<FilmesDTO> findAll();

    FilmesDTO findById(String id);

    FilmesDTO updateFilm(String id , FilmesDTO dto);
}
