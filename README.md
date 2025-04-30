# PDV-Fiscal Web

Sistema PDV (Ponto de Venda) com Integração Fiscal

---

## Visão Geral
Este projeto é um sistema PDV completo, desenvolvido em Java com Spring Boot, que integra funcionalidades fiscais reais (NF-e, NFS-e, Receita Federal), controle de estoque, autenticação de usuários, relatórios e testes automatizados.

### Funcionalidades Principais
- **Cadastro e autenticação de usuários**
- **Cadastro e gestão de produtos**
- **Registro de vendas com controle de estoque**
- **Emissão automática de NF-e ao registrar venda**
- **Consulta de CNPJ via Receita Federal**
- **Relatórios de vendas por período e por produto**
- **Testes automatizados para controllers e integrações fiscais**

---

## Diferenciais do Projeto
- **Arquitetura modular**: Separação clara entre camadas (controller, service, repository).
- **Integração fiscal realista**: Simulação de emissão de NF-e com salvamento de chave, protocolo e XML na venda.
- **Relatórios completos**: Endpoints para relatórios gerenciais fundamentais.
- **Testes automatizados**: Cobertura de controllers e lógica fiscal com JUnit e Mockito.
- **Documentação e código comentado**: Facilita manutenção e entendimento.

---

## Endpoints Principais

### Usuários
- `POST /api/usuarios` — Cadastro de usuário
- `POST /api/usuarios/login` — Login de usuário

### Produtos
- `POST /api/produtos` — Cadastro de produto
- `GET /api/produtos` — Listar produtos

### Vendas
- `POST /api/vendas` — Registrar venda (emite NF-e automaticamente)
- `GET /api/vendas` — Listar vendas
- `GET /api/vendas/{id}` — Detalhar venda
- `GET /api/vendas/relatorio/periodo?inicio=...&fim=...` — Relatório de vendas por período
- `GET /api/vendas/relatorio/produto?inicio=...&fim=...` — Relatório de vendas por produto

---

## Simulação do Painel Web

### 1. Tela de Login
- **Layout:**
  - Fundo institucional (imagem de loja ou cor sólida).
  - Painel central com campos: E-mail, Senha, Botão "Entrar".
- **Explicação no fundo:**
  > "Acesso restrito. Faça login para registrar vendas, emitir notas fiscais e acessar relatórios. Apenas usuários cadastrados podem operar o sistema, garantindo segurança e rastreabilidade."
- **Função:**
  - Autenticação de usuários.
  - Redireciona para o painel principal após login.

### 2. Tela de Cadastro de Produto
- **Layout:**
  - Formulário: Nome do produto, Código, Preço, Estoque, Botão "Salvar".
- **Explicação no fundo:**
  > "Cadastre novos produtos para venda. O estoque é controlado automaticamente a cada venda realizada."
- **Função:**
  - Permite adicionar produtos ao catálogo do PDV.

### 3. Tela de Registro de Venda
- **Layout:**
  - Lista de produtos disponíveis.
  - Campos para selecionar produto, quantidade, adicionar item à venda.
  - Resumo da venda (itens, total).
  - Botão "Finalizar e emitir NF-e".
- **Explicação no fundo:**
  > "Aqui você registra as vendas. O sistema calcula o total, atualiza o estoque e emite a Nota Fiscal Eletrônica automaticamente."
- **Função:**
  - Gera a venda, desconta estoque, emite NF-e.

### 4. Tela de Relatórios
- **Layout:**
  - Filtros por período, produto, operador.
  - Tabela/lista de resultados.
- **Explicação no fundo:**
  > "Gere relatórios completos para análise de vendas por período ou por produto. Essencial para a gestão do negócio."
- **Função:**
  - Permite consulta gerencial.

### 5. Tela de Consulta de NF-e
- **Layout:**
  - Campo para digitar o número da venda ou chave da NF-e.
  - Exibe detalhes fiscais (chave, protocolo, XML).
- **Explicação no fundo:**
  > "Consulte as informações fiscais de cada venda, garantindo transparência e conformidade com a legislação."
- **Função:**
  - Permite visualizar a NF-e emitida para qualquer venda.

---

## Tabela de Rastreabilidade de Requisitos

| Requisito                                | Tela/Seção do README                 | Observação                                          |
|------------------------------------------|--------------------------------------|-----------------------------------------------------|
| Cadastro/autenticação de usuários        | Tela de Login                        | Segurança, acesso restrito                          |
| Cadastro e gestão de produtos            | Tela de Cadastro de Produto          | Controle de estoque                                 |
| Registro de vendas                       | Tela de Registro de Venda            | Desconto de estoque, cálculo automático             |
| Emissão automática de NF-e               | Tela de Registro de Venda / Consulta de NF-e | Geração e consulta de dados fiscais         |
| Consulta de CNPJ                         | (Explicação técnica/fluxo)           | Pode ser detalhado na apresentação                  |
| Relatórios de vendas                     | Tela de Relatórios                   | Filtros por período, produto, operador              |
| Consulta de NF-e                         | Tela de Consulta de NF-e             | Transparência e conformidade fiscal                 |
| Segurança                                | Tela de Login / README               | Autenticação, dados sensíveis                       |
| Usabilidade                              | Wireframes e explicações das telas   | Experiência do usuário, clareza de fluxo            |
| Modularidade e manutenibilidade          | README (Diferenciais do Projeto)      | Separação de camadas, código comentado              |
| Testabilidade                            | README (Testes Automatizados)         | JUnit, Mockito, cobertura de controllers e fiscal   |
| Portabilidade                            | README (Como Executar)                | Java, Spring Boot, Maven, H2                        |
| Documentação                             | README completo e comentado           | Facilita entendimento e manutenção                  |

---

## Observações sobre a Integração Fiscal

- A integração fiscal (emissão, consulta e cancelamento de NF-e) está atualmente **simulada** no código, devido à indisponibilidade da dependência JavaNFe no repositório público.
- O código está preparado para receber a integração real assim que a dependência estiver disponível, bastando remover os comentários nos pontos indicados e ajustar as configurações.
- Todos os métodos de emissão, consulta e cancelamento de NF-e atualmente geram dados fictícios para fins de demonstração acadêmica.

## Pontos de Melhoria Futura

- Implementar a integração real com a SEFAZ utilizando a biblioteca JavaNFe, assim que for possível importar a dependência.
- Tratar retorno, salvar XML e lidar com erros fiscais de forma robusta.
- Preencher corretamente os dados de cancelamento e consulta de NF-e.
- Implementar integração com NFS-e municipal, conforme necessidade do cliente.

## Roteiro Sugerido para Apresentação

1. **Introdução**: Explique o objetivo do sistema PDV Fiscal Web e os diferenciais do projeto.
2. **Demonstração das Telas**: Mostre as principais telas (Login, Cadastro de Produto, Registro de Venda, Relatórios, Consulta de NF-e) e como cada uma cobre os requisitos do projeto.
3. **Explicação Técnica**: Destaque a arquitetura modular, uso de Spring Boot, persistência de dados fiscais e rastreabilidade dos requisitos.
4. **Observação sobre a Integração Fiscal**: Informe que a integração está simulada, mas o sistema está pronto para receber a implementação real.
5. **Pontos de Melhoria Futura**: Aponte os TODOs no código como oportunidades de evolução do projeto.
6. **Perguntas e Encerramento**: Abra para dúvidas e destaque a facilidade de expansão do sistema.

---

## Como Executar

1. **Pré-requisitos:**
   - Java 11+
   - Maven
   - Banco de dados H2 (padrão, pode ser alterado no `application.properties`)

2. **Build e execução:**
   ```
   mvn clean install
   mvn spring-boot:run
   ```

3. **Testes:**
   ```
   mvn test
   ```

---

## Observações Finais
- O sistema está pronto para demonstração acadêmica e pode ser facilmente expandido para produção.
- Todos os pontos extras implementados estão comentados no código e destacados neste README.
- Para dúvidas ou sugestões, consulte os comentários do código ou entre em contato com o desenvolvedor.

---

**Desenvolvido para fins acadêmicos — PDV Fiscal Web**
