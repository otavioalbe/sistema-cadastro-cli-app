package com.t3es2.cadastramento_geral.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssinaturaRequest {
    private Long codApp;
    private Long codCli;
}
