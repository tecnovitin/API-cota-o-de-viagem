package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.Desconto;

@Repository
public interface IDescontoRepository extends JpaRepository<Desconto, Long> {

    Optional<Desconto> findByDescricao(String descricao);

    Optional<Desconto> findByValorDesconto(java.math.BigDecimal valorDesconto);

    List<Desconto> findAllByCotacaoId(Long cotacao_id);
}
