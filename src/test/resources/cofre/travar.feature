# language: en
Feature: Travar cofre
  Como um usuario
  eu quero travar o cofre
  por motivos de seguranca

  Scenario: Digitar numero com a porta aberta
    Given que a porta esta aberta
    When eu pressionar o botao 1
    Then o display deve mostrar "Feche a porta antes de digitar a senha"

  Scenario: Digitar um numero com a porta fechada
    Given que a porta esta fechada
    When eu pressionar o botao 0
    Then o display deve mostrar "0"

  Scenario: Gravar senha valida porta fechada destravada
    Given que a porta esta fechada
    And eu pressionar o botao 1
    And eu pressionar o botao 2
    And eu pressionar o botao 3
    And eu pressionar o botao 4
    And eu pressionar o botao 5
    And eu pressionar o botao 6
    When eu apertar ok
    Then o cofre deve travar
    And o display deve mostrar "Senha salva. Cofre trancado"

  Scenario: Senha com menos de 6 digitos
    Given que a porta esta fechada
    And eu pressionar o botao 1
    When eu apertar ok
    Then o display deve mostrar "senha precisa de 6 digitos. Tente novamente"

  Scenario: Digitar com a porta fechada e depois abrir e digitar
    Given que a porta esta fechada
    And eu pressionar o botao 9
    And eu pressionar o botao 8
    Then o display deve mostrar "98"
    And eu abrir a porta
    And eu pressionar o botao 7
    Then o display deve mostrar "Feche a porta antes de digitar a senha"
