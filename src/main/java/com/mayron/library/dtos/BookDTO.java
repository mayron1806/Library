package com.mayron.library.dtos;

import com.mayron.library.entities.Lending;

public class BookDTO {

    private Long id;
    private String name;
    private String author;
    private Integer Pages;
    private Lending lending;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return this.Pages;
    }

    public void setPages(Integer Pages) {
        this.Pages = Pages;
    }

    public Lending getLending() {
        return this.lending;
    }

    public void setLending(Lending lending) {
        this.lending = lending;
    }

}
