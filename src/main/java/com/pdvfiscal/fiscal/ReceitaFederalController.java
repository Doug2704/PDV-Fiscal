package com.pdvfiscal.fiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receita")
public class ReceitaFederalController {
    @Autowired
    private ReceitaFederalService receitaService;

    @GetMapping("/consultar-cnpj/{cnpj}")
    public ResponseEntity<String> consultarCNPJ(@PathVariable String cnpj) {
        String resultado = receitaService.consultarCNPJ(cnpj);
        return ResponseEntity.ok(resultado);
    }
}
