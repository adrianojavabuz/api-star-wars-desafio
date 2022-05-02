package br.com.desafio.api.filmsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("episode_id")
    private Integer episode_id;

    @JsonProperty("opening_crawl")
    private String opening_crawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private LocalDate release_date;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("starship")
    private List<String> starships;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("created")
    private LocalDateTime created;

    @JsonProperty("edited")
    private LocalDateTime edited;

    @JsonProperty("url")
    private String url;

    @JsonProperty("version")
    private Integer version;

}
