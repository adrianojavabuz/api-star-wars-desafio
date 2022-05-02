package br.com.desafio.api.config;

import br.com.desafio.api.client.FilmeClient;
import br.com.desafio.api.filmsDTO.FilmesDTO;
import br.com.desafio.api.filmsDTO.ResponseClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class InitMemory implements CommandLineRunner {

    @Autowired
    FilmeClient starWarsClient;


    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<ResponseClientDTO> resposta = starWarsClient.responseClientDTO();

        initMemoryCache(resposta);
        System.out.println("CommandLineRunner");
        System.out.println(starWarsClient);
    }


    private void initMemoryCache(ResponseEntity<ResponseClientDTO> response) {

        if (mountDataMemory(response) != null) {
            mountDataMemory(response).stream().forEach(filmesDTO -> {

                MemoryService.putCache(filmesDTO.getId(), filmesDTO);
            });
        }

    }

    private List<FilmesDTO> mountDataMemory(ResponseEntity<ResponseClientDTO> response) {

        List<FilmesDTO> lsfilmes = new ArrayList<>();
        if (response.getBody() != null) {

            for (int x = 0; x < response.getBody().getResults().size(); x++) {
                FilmesDTO filmesDTO = new FilmesDTO();
                UUID uuid = UUID.randomUUID();
                filmesDTO = response.getBody().getResults().get(x);
                filmesDTO.setVersion(1);
                filmesDTO.setId(uuid.toString());
                lsfilmes.add(filmesDTO);

            }

        }
        return  lsfilmes;
    }
}
