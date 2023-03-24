package com.example.notion_ex.repository;

import com.example.notion_ex.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
    Client findClientByName(String name);
}
