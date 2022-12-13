package com.mayron.library.services;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.mayron.library.dtos.ClientDTO;
import com.mayron.library.dtos.CreateClientDTO;
import com.mayron.library.entities.Client;
import com.mayron.library.repositories.ClientRepository;
import com.mayron.library.utils.CPFUtils;

import jakarta.transaction.Transactional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper mapper;

    public ClientService(ClientRepository clientRepository, ModelMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Transactional
    public Object createClient(CreateClientDTO createClientDTO){
        // remove caracteres especiais do cpf e verifica se está em uso
        var cpf = CPFUtils.removeSpecialChars(createClientDTO.getCpf());
        var exists = this.clientRepository.existsByCpf(cpf);
        if(exists) throw new DuplicateKeyException("O cpf já está em uso"); 

        // adiciona cpf formatado ao objeto
        createClientDTO.setCpf(cpf);

        // cria um client para ser adicionado ao banco e copia as propriedades do DTO para ele
        Client client = mapper.map(createClientDTO, Client.class);

        // salva no banco
        clientRepository.save(client);
        
        // converte objeto para DTO e retorna
        return mapper.map(client, ClientDTO.class);
    }
}
