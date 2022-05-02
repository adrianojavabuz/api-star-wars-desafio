package br.com.desafio.api.client;

import br.com.desafio.api.filmsDTO.ResponseClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://swapi.dev/api", value = "films")
public interface FilmeClient {
    @GetMapping("/films/")
    ResponseEntity<ResponseClientDTO> responseClientDTO ();
}
