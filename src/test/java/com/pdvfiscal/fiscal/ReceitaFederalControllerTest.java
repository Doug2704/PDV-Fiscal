package com.pdvfiscal.fiscal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ReceitaFederalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConsultarCNPJValido() throws Exception {
        // Exemplo de CNPJ válido (pode ser alterado para um CNPJ real)
        String cnpj = "27865757000102"; // Magazine Luiza
        mockMvc.perform(get("/api/receita/consultar-cnpj/" + cnpj))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("magazineluiza")));
    }

    @Test
    public void testConsultarCNPJInvalido() throws Exception {
        String cnpj = "00000000000000";
        mockMvc.perform(get("/api/receita/consultar-cnpj/" + cnpj))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("ERROR")));
    }
}
