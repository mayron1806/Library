package com.mayron.library.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayron.library.entities.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{
    
}
