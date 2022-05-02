package br.com.desafio.api.filmsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestFilmeDTO {

    @JsonProperty("descricao")
    private String descricao;

}
