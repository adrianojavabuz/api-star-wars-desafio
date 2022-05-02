package br.com.desafio.api.config;

import br.com.desafio.api.filmsDTO.FilmesDTO;

import java.util.HashMap;
import java.util.Map;

public class MemoryService {

    public static Map< String, FilmesDTO > cache = new HashMap< >();

    public static Map < String, FilmesDTO> getCache() {
        return cache;
    }

    public static void putCache(String key, FilmesDTO value) {
        cache.put(key, value);
    }
}
