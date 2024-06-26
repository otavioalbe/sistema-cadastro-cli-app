package com.t3es2.servico_assinaturas_validas.service;

import com.t3es2.servico_assinaturas_validas.entity.Assinatura;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicoAssinaturasValidas {
    private List<Assinatura> assinaturasValidas = new LinkedList<>();

    public boolean isAssinaturaValida(Assinatura assinatura) {
        if(Objects.equals(assinatura.getStatus(), "ATIVA")){
            assinaturasValidas.add(assinatura);
            return true;
        }
        return false;
    }

//    // Método para observar o evento de pagamento
//    public void observarPagamento(PagamentoServicoAssinaturaValida pagamento) {
//        // Aqui você pode implementar a lógica para atualizar a assinatura válida com base no pagamento
//        // Exemplo simples: Atualizar a data de expiração da assinatura
//        Assinatura assinatura = assinaturasValidas.get(pagamento.getCodAssinatura());
//        if (assinatura != null) {
//            // Atualizar a data de expiração para um mês após a data do pagamento
//            assinatura.setDataExpiracao(pagamento.getDataPagamento().plusMonths(1));
//        }
//    }
}
