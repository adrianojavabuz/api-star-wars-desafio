package br.com.desafio.api.controller;

import br.com.desafio.api.filmsDTO.TituloDTO;
import br.com.desafio.api.filmsDTO.FilmesDTO;
import br.com.desafio.api.filmsDTO.RequestFilmeDTO;
import br.com.desafio.api.service.FilmeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@Log4j2
@RequestMapping("/filme")
@Api(tags = {"Filme"})
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    @PutMapping(value = "/{id}")
    @ApiOperation("Api responsável por atualizar a descrição de um filme")
    public ResponseEntity<FilmesDTO> atualizarFilmes(@PathVariable String id, @RequestBody RequestFilmeDTO requestFilmeDTO) {
        log.info("Atualizando a descrição de um filme.");
        FilmesDTO newObj = filmeService.atualizarFilmes(id, requestFilmeDTO);
        if(newObj == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(newObj, HttpStatus.OK);
    }

    @GetMapping("/saga")
    @ApiOperation("Api responsável por buscar todos os titulos da saga")
    public ResponseEntity<List<TituloDTO>> listarFilme(){
        log.info("Listando todos os filmes.");
        List<TituloDTO> dtos = filmeService.buscarFilme();
        if(dtos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filmeService.buscarFilme());
    }

    @GetMapping("/{id}")
    @ApiOperation("Api responsável por buscar um filme pelo id")
    public ResponseEntity<FilmesDTO> buscarFilmePorId(@PathVariable(name = "id") String id) {
        log.info("Listando filme por id: {}", id);
        FilmesDTO obj = filmeService.buscarFilmePorId(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }


}
