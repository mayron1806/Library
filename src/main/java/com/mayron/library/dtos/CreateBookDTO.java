package com.mayron.library.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public class CreateBookDTO {

    @NotBlank(message = "Você precisa preencher o campo name")
    @Length(min = 1, max = 100, message = "O campo name deve ter entre {min} e {max} caracteres")
    private String name;
    
    @NotBlank(message = "Você precisa preencher o campo author")
    @Length(min = 1, max = 100, message = "O campo author deve ter entre {min} e {max} caracteres")
    private String author;
    
    @Nullable
    private Integer pages;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

}
