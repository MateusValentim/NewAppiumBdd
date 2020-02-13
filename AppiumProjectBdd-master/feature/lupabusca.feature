#language: pt
Funcionalidade: Busca por produto por barra de pesquisa

  Contexto: 
    Dado: que estou na tela inicial
	    Quando quando clico na lupa
	

  @PesquisaComSucesso
  Cenario: Pesquisa por um produto com sucesso
    
    E digito o produto desejado
      | produto                       |
      | BEATS STUDIO 2 OVER-EAR MATTE |
    E clico no produto pesquisado
    E clico em "Add to cart"
    Entao entro com meu usuario e senha
      | userName   | password |
      | MateusRsi0 | Teste123 |

  @PesquisaComFalha
  Cenario: Pesquisa por um produto com falha
    Quando digito o nome do produto desejado
      | produtoIncorreto              |
      | BEATS STUDIO 2 OVER-EAE MATTE |
    Entao vou receber a mensagem "No results for"
