#language: pt
Funcionalidade: Cadastrar usuario

  Contexto: 
    Dado que estou na tela inicial do aplicativo e clico no botao superior esquerdo
    Quando clico no botao de login
    E clico no campo 'sign up today' localizado na parte inferior da tela
    

  @CadastroComSucesso
  Cenario: Cadastrar usuario com sucesso
    E preencho os campos com os meus dados para o cadastro
      | userName   | email                       | password | passConfirm | firstName | lastName | phone       | country | city   | address          | state     | postalCode |
      | MateusRsi34 | mateus.valentim@outlook.com | Teste123 | Teste123    | Mateus    | Valentim | 11943211234 | Brazil  | Osasco | Rua Salvador, 40 | Sao Paulo |   06325060 |
    E clico no botao "Register" localizado na parte inferior da tela
   
    Entao vou verificar se o meu nome de usuario esta conforme o registro realizado
    
    @CadastroComFalha
    Cenario: Cadastrar usuario com falha
    E preencho os campos com os meus dados para o cadastro
      | userName    | email                       | password | passConfirm | firstName | lastName | phone       | country | city   | address          | state     | postalCode |
      | MateusRsi20 | mateus.valentim@outlook.com | Teste123 | Teste12    | Mateus    | Valentim | 11943211234 | Brazil  | Osasco | Rua Salvador, 40 | Sao Paulo |   06325060 |
 Entao vou receber a mensagem "Passwords do not match" e vou permanecer na tela de registro
 
