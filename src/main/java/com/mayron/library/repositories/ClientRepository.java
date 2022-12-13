package com.mayron.library.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mayron.library.entities.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{
    boolean existsByCpf(String cpf);
}  
