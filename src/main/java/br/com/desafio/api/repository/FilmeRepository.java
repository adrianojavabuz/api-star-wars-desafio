package br.com.desafio.api.repository;

import br.com.desafio.api.config.MemoryService;
import br.com.desafio.api.filmsDTO.FilmesDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FilmeRepository implements FilmeCacheRepository {
    @Override
    public FilmesDTO save(FilmesDTO filme) {
        return null;
    }

    @Override
    public List<FilmesDTO> findAll() {
        return getFilms();
    }

    @Override
    public FilmesDTO findById(String id) {
        return null;
    }

    @Override
    public FilmesDTO updateFilm(String id,FilmesDTO dto) {

       MemoryService.putCache(id,dto);
       return dto;
    }

    private List<FilmesDTO> getFilms() {
        List<FilmesDTO> lsfilme = new ArrayList<>();
        Map<String, FilmesDTO> map = MemoryService.cache;

        for (var entry : map.entrySet()) {
            lsfilme.add(entry.getValue());

        }
        return lsfilme;
    }


    public FilmesDTO getFilmById(String id) {
        List<FilmesDTO> lsfilme = new ArrayList<>();
        Map<String, FilmesDTO> map = MemoryService.cache;

        Optional<FilmesDTO> dto = map.entrySet().stream().filter(x -> id.equals(x.getKey()))
                .map(x -> x.getValue()).findFirst();

        if(dto.isEmpty()){
            return null;
        }

        return dto.get();
    }
}
