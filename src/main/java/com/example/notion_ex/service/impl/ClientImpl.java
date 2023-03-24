package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.Client;
import com.example.notion_ex.repository.ClientRepo;
import com.example.notion_ex.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientImpl implements ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public ClientImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    //READ
    @Override
    public List<Client> getClients(){
        return (List<Client>) clientRepo.findAll();
    }

    @Override
    public Client findByName(String name) { return clientRepo.findClientByName(name); }
    //UPDATE
    @Override
    public Client updateClient(Client client1) {
        Client existingClient = clientRepo.findById(client1.getId()).orElse(null);
        existingClient.setName(client1.getName());

        //existingAdmin.;

        return clientRepo.save(existingClient);
    }

    //DELETE
    @Override
    public String deleteById(Long id) {
        clientRepo.deleteById(id);
        return "Adminul cu id:ul " + id + " a fost sters din baza de date";
    }
}
