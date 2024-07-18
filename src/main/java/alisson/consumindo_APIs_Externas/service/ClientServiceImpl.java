package alisson.consumindo_APIs_Externas.service;

import alisson.consumindo_APIs_Externas.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientServiceImpl extends JpaRepository<Client, Integer> {
    List<Client> findAll();
    Optional<Client> findById(Long id);

    void deleteById(Long id);
}
