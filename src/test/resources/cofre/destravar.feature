# language: en
Feature: Destravar cofre
  Como um usuario
  eu quero destravar o cofre
  para acessar o que tem dentro

  Scenario: Senha correta
    Given que a senha do cofre "123456"
    And eu pressionei o botao 1
    And eu pressionei o botao 2
    And eu pressionei o botao 3
    And eu pressionei o botao 4
    And eu pressionei o botao 5
    And eu pressionei o botao 6
    When eu apertar destravar
    Then o cofre deve destravar
    And deve aparecer no display "senha correta. Cofre aberto"

  Scenario: Senha incorreta
    Given que a senha do cofre "123456"
    And eu pressionei o botao 1
    And eu pressionei o botao 2
    And eu pressionei o botao 3
    And eu pressionei o botao 4
    And eu pressionei o botao 6
    And eu pressionei o botao 6
    When eu apertar destravar
    Then deve aparecer no display "senha errada. Tente novamente"


  Scenario: Senha menos 6 digitos
    Given que a senha do cofre "123456"
    And eu pressionei o botao 6
    And eu pressionei o botao 6
    When eu apertar destravar
    Then deve aparecer no display "senha errada. Tente novamente"
