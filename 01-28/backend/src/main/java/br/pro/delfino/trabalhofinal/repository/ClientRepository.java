package br.pro.delfino.trabalhofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pro.delfino.trabalhofinal.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
