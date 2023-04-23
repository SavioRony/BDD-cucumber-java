# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
  Dado um lance valido
  Quando propoe ao leilao
  Entao o lance e aceito

Cenario: Propondo varios lances validos
  Dado um lance de 10.0 reais do usuario "fulano"
  E um lance de 15.0 reais do usuario "beltrano"
  Quando propoe varios lances ao leilao
  Entao os lances sao aceitos

Esquema do Cenário: Propondo um lance invalido
  Dado um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
  Quando propoe ao leilao
  Entao o lance nao e aceito

  Cenarios:
    | valor | nomeUsuario |
    | 0     | Fulano      |
    | -1    | Beltrano    |

Cenario: Propondo uma sequencia de lances
  Dado dois lances
    | valor | nomeUsuario |
    | 10    | Fulano      |
    | 15    | Fulano      |
  Quando propoe varios lances ao leilao
  Entao o segundo lance nao e aceito
