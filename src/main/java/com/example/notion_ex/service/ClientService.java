package com.example.notion_ex.service;

import com.example.notion_ex.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientService {
    List<Client> getClients();

    Client findByName(String name);

    Client updateClient(Client client1);
    String deleteById(Long id);
}
