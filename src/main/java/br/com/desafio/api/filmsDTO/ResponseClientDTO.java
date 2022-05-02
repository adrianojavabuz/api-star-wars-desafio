package br.com.desafio.api.filmsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("next")
    private Integer next;

    @JsonProperty("previous")
    private Integer previous;

    @JsonProperty("results")
    private List<FilmesDTO>  results;
}
