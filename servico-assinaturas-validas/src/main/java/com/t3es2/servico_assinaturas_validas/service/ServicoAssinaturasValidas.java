package com.t3es2.servico_assinaturas_validas.service;

import com.t3es2.servico_assinaturas_validas.entity.Assinatura;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ServicoAssinaturasValidas {
    private List<Assinatura> assinaturasValidas = new LinkedList<>();

    public boolean isAssinaturaValida(Long codAss, List<Assinatura> todasAssinaturas) {
        for(Assinatura a : assinaturasValidas){
            if(a.getId().equals(codAss))
                return true;
        }
        for(Assinatura a : todasAssinaturas){
            if(a.getId().equals(codAss)){
                assinaturasValidas.add(a);
                return true;
            }
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
