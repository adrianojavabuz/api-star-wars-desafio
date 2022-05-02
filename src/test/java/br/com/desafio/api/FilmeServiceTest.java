package br.com.desafio.api;

import br.com.desafio.api.client.FilmeClient;
import br.com.desafio.api.filmsDTO.FilmesDTO;
import br.com.desafio.api.filmsDTO.RequestFilmeDTO;
import br.com.desafio.api.repository.FilmeRepository;
import br.com.desafio.api.service.FilmeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {FilmeService.class})
public class FilmeServiceTest {

    @Autowired
    private FilmeService filmeService;

    @MockBean
    private FilmeClient filmeClient;

    @MockBean
    private FilmeRepository filmeRepository;

    private String descricao;
    private String title;
    private String id;
    private FilmesDTO filmesDTO;
    private RequestFilmeDTO requestFilmeDTO;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.openMocks(this);

        descricao = "War! The Republic is crumbling...";
        title = "Revenge of the Sith";
        id = "17fe99d6-65e6-4e22-9330-4816891283bc";


        filmesDTO = FilmesDTO.builder()
                .id("17fe99d6-65e6-4e22-9330-4816891283bc")
                .title("Revenge of the Sith")
                .director("teste")
                .version(1)
                .build();

        requestFilmeDTO = RequestFilmeDTO.builder()
                .descricao("New Description")
                .build();
    }

    @Test
    public void shouldGetbuscarFilme() {

        Mockito.when(filmeRepository.findAll())
                .thenReturn(Arrays.asList(filmesDTO));

        assertFalse(filmeService.buscarFilme().isEmpty());
    }

    @Test
    public void shouldGetbuscarFilmePorId() {

        Mockito.when(filmeRepository.getFilmById(id))
                .thenReturn(filmesDTO);

        assertNotNull(filmeService.buscarFilmePorId(id));
    }

    @Test
    public void shouldGetatualizarFilmes() {

        Mockito.when(filmeRepository.getFilmById(id))
                .thenReturn(filmesDTO);

        Mockito.when(filmeRepository.updateFilm(id,filmesDTO))
                .thenReturn(filmesDTO);

        assertNotNull(filmeService.atualizarFilmes(id,requestFilmeDTO));
    }



}
