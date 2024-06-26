package com.t3es2.servico_pagamentos.repository;

import com.t3es2.servico_pagamentos.entity.Pagamento;
import org.springframework.data.repository.CrudRepository;

public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
}
