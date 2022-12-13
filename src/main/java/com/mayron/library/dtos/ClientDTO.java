package com.mayron.library.dtos;

import java.util.UUID;

import com.mayron.library.utils.CPFUtils;

public class ClientDTO {
    private UUID id;

    private String name;

    private String cpf;

    private AddressDTO address; 

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
        this.cpf = CPFUtils.AddSpecialChars(cpf);
    }

    public AddressDTO getAddress() {
        return this.address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

}
