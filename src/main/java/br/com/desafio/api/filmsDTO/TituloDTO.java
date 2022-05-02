package br.com.desafio.api.filmsDTO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TituloDTO {

    private String id;
    private String title;
    private Integer version;

}
