package com.t3es2.cadastramento_geral.repository;

import com.t3es2.cadastramento_geral.entity.Assinatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends CrudRepository<Assinatura, Long> {
}
