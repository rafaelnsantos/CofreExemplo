# language: en
Feature: Validar senha

  Scenario Outline: Senha apenas com numeros
    Given a senha entrada <senha>
    Then o retorno deve ser <saida>

    Examples:
      | senha  | saida |
      | "123345" | True  |
      | "12245"  | True  |
      |   "53"   | True  |
      | "a234sd" | False |
      | "1a2"    | False |

  Scenario Outline: Senha valida
    Given a senha entrada <senha>
    Then a senha deve <saida>

    Examples:
      | senha  | saida |
      | "123345" | True  |
      | "12245"  | False |
      | "a234sd" | False |
      | "1a2"    | False |
      | "122245" | True  |
      