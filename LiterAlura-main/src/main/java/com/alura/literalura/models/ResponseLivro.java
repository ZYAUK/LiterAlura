package com.alura.literalura.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseLivro {
    
    @JsonProperty("count") 
    private String count;

    @JsonProperty("next") 
    private String next;
    
    @JsonProperty("previous") 
    private String previous;

    @JsonProperty("results") 
    private List<Livro> livros;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    

}
