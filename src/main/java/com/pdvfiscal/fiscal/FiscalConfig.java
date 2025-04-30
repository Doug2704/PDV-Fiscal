package com.pdvfiscal.fiscal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiscalConfig {
    @Value("${fiscal.certificado.caminho}")
    private String caminhoCertificado;

    @Value("${fiscal.certificado.senha}")
    private String senhaCertificado;

    @Value("${fiscal.ambiente}")
    private String ambiente; // 1=Produção, 2=Homologação

    public String getCaminhoCertificado() {
        return caminhoCertificado;
    }

    public String getSenhaCertificado() {
        return senhaCertificado;
    }

    public String getAmbiente() {
        return ambiente;
    }
}
