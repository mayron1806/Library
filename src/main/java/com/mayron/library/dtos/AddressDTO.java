package com.mayron.library.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {
    @NotBlank(message = "Você precisa preencher o campo cep")
    @Length(max = 8, message = "O campo cep deve ter no maximo {max} caracteres")
    private String cep;
    
    @NotBlank(message = "Você precisa preencher o campo city")
    @Length(min = 2, max = 30, message = "O campo city deve ter entre {min} e {max} caracteres")
    private String city;
    
    @NotBlank(message = "Você precisa preencher o campo district")
    @Length(min = 2, max = 30, message = "O campo district deve ter entre {min} e {max} caracteres")
    private String district;
    
    @NotBlank(message = "Você precisa preencher o campo street")
    @Length(min = 3, max = 50, message = "O campo street deve ter entre {min} e {max} caracteres")
    private String street;

    @NotBlank(message = "Você precisa preencher o campo number")
    @Length(min = 1, max = 10, message = "O campo number deve ter entre {min} e {max} caracteres")
    private String number;

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
