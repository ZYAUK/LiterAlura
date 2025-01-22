package com.alura.literalura.integrations;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.alura.literalura.models.Livro;
import com.alura.literalura.models.ResponseLivro;

@Service
public class BooksService {

    private final RestClient http;

    private final String baseUrl = "https://gutendex.com/books";

    public BooksService(RestClient.Builder restClient){
        http = restClient.build();
    }

    public List<Livro> listarLivros(){
        var responseType = new ParameterizedTypeReference<ResponseLivro>(){};
        var response = http.get().uri(baseUrl).retrieve().body(responseType);
        return response.getLivros();
    }
    
    public List<Livro> listarLivrosPeloTitulo(String titulo){
        var parameters = "search=" + titulo;
        var responseType = new ParameterizedTypeReference<ResponseLivro>(){};
        var response = http.get().uri(baseUrl+"?"+parameters).retrieve().body(responseType);
        return response.getLivros();
    }
    public List<Livro> listarLivrosPelaLinguagem(String linguagem){
        var parameters = "languages=" + linguagem;
        var responseType = new ParameterizedTypeReference<ResponseLivro>(){};
        var response = http.get().uri(baseUrl+"?"+parameters).retrieve().body(responseType);
        return response.getLivros();
    }

}