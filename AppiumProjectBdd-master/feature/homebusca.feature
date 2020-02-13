#language: pt
Funcionalidade: Busca pela lupa

  Contexto: 
    Dado clico em um tipo de produto

  @BuscaComSucesso
  Cenario: busca um produto com sucesso
    E clico no produto desejado
    E clico em "Add to Cart"
    E insiro meu usuario e senha
      | userName   | password |
      | MateusRsi0 | Teste123 |
    Entao clico em login

  @BuscaComFalha
  Cenario: busca um produto com falha
    Quando clico em um tipo de produto
    E clico o produto desejado
    Entao vou visualizar a mensagem "SoldOut" indicando que nao ha mais unidades disponiveis
