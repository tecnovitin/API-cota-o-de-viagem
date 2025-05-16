package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Destino;





@Repository
public interface IDestinoRepository extends JpaRepository<Destino, Long> {

    Optional<Destino> findByNome(String nome);

    Optional<Destino> findByLocalizacao(String localizacao);
    
    Optional<Destino> findByPrecoPorPessoa(BigDecimal precoPorPessoa);
}
