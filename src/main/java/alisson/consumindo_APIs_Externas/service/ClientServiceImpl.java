package alisson.consumindo_APIs_Externas.service;

import alisson.consumindo_APIs_Externas.model.Address;
import alisson.consumindo_APIs_Externas.model.AddressRepository;
import alisson.consumindo_APIs_Externas.model.Client;
import alisson.consumindo_APIs_Externas.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        savingClientWithCep(client);
    }

    private void savingClientWithCep(Client client) {
        //if the address doest exist in AddressRepository
        Address address = addressRepository.findById(client.getAddress().getCep()).orElseGet(() -> {
            Address newAddress = viaCepService.consultarCep(client.getAddress().getCep());
            addressRepository.save(newAddress);
            return newAddress;
         });

        client.setAddress(address);

        clientRepository.save(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDb = clientRepository.findById(id);
        if (clientDb.isPresent()){
            savingClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
