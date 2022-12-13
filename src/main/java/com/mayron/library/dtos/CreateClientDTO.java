package com.mayron.library.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class CreateClientDTO {
    
    @NotBlank(message = "Você precisa preencher o campo name")
    @Length(min = 2, max = 50, message = "O campo name deve ter entre {min} e {max} caracteres")
    private String name;

    @NotBlank(message = "Você precisa preencher o campo cpf")
    @CPF( message = "CPF invalido")
    private String cpf;

    @Valid
    private AddressDTO address; 

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressDTO getAddress() {
        return this.address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
