package br.com.desafio.api.service;

import br.com.desafio.api.client.FilmeClient;
import br.com.desafio.api.filmsDTO.TituloDTO;
import br.com.desafio.api.filmsDTO.FilmesDTO;
import br.com.desafio.api.filmsDTO.RequestFilmeDTO;
import br.com.desafio.api.filmsDTO.ResponseClientDTO;
import br.com.desafio.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    FilmeClient starWarsClient;

    @Autowired
    FilmeRepository filmeRepository;

    public String teste() {
        ResponseEntity<ResponseClientDTO> teste = starWarsClient.responseClientDTO();
        return "Teste";
    }


    public List<TituloDTO> buscarFilme(){
        List<FilmesDTO> lsfilme = filmeRepository.findAll();
        List<TituloDTO> lsfilm = new ArrayList<>();
        lsfilme.stream().forEach(filmesDTO -> {
            TituloDTO tituloDTO = new TituloDTO();
            tituloDTO.setTitle(filmesDTO.getTitle());
            tituloDTO.setId((filmesDTO.getId()));
            tituloDTO.setVersion(filmesDTO.getVersion());
            lsfilm.add(tituloDTO);
        });
        return lsfilm;
    }


    public FilmesDTO buscarFilmePorId(String id){

        return filmeRepository.getFilmById(id);

    }

    public FilmesDTO atualizarFilmes(String id , RequestFilmeDTO requestFilmeDTO){

        FilmesDTO dto = buscarFilmePorId(id);

        if(dto != null){
            dto.setVersion(dto.getVersion() + 1);
            dto.setOpening_crawl(requestFilmeDTO.getDescricao());
        } else {
            return null;
        }

        return filmeRepository.updateFilm(id,dto);
    }

}
