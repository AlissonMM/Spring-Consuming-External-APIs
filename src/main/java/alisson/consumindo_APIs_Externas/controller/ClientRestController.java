package alisson.consumindo_APIs_Externas.controller;

import alisson.consumindo_APIs_Externas.model.Client;
import alisson.consumindo_APIs_Externas.service.ClientService;
import alisson.consumindo_APIs_Externas.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clients")
public class ClientRestController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientService.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
