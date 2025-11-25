# Relatório da Atividade – Saques Concorrentes em Java

Esta atividade teve como objetivo simular saques bancários realizados por diferentes clientes ao mesmo tempo, utilizando **threads** em Java. A intenção foi observar problemas clássicos de concorrência e garantir que o saldo da conta fosse acessado de forma segura.

## Descrição da Atividade
Foi criada a classe `Conta`, responsável por armazenar o saldo e controlar operações de saque. Três threads representando **Mãe**, **Pai** e **Filho** tentaram realizar saques simultaneamente a partir da mesma conta.  
O foco principal foi aplicar **métodos sincronizados (`synchronized`)**, permitindo que apenas uma thread por vez acessasse a região crítica.

## Problema Abordado
Sem sincronização, múltiplas threads poderiam tentar sacar ao mesmo tempo, causando leituras incorretas do saldo ou permitindo saques indevidos.  
Com o uso de **`synchronized`**, a conta só permite o saque se houver saldo suficiente, evitando inconsistências.

## Funcionamento do Código
- Cada cliente executa uma tentativa de saque.
- O método `debitarValor()` verifica o saldo:
  - Se houver saldo: realiza o saque e imprime mensagem.
  - Se não houver: informa saldo insuficiente.
- No final, é exibido quanto cada cliente conseguiu sacar.

## Resultado Observado
A primeira thread que acessa a conta consegue sacar o valor pedido. As demais recebem mensagem de saldo insuficiente, pois o primeiro saque esgotou o saldo disponível.  
Isso confirma o comportamento esperado em um ambiente sincronizado: **não há saques duplicados ou inconsistências de saldo.**

## Conclusão
A atividade demonstra com clareza como **concorrência** e **sincronização** impactam o funcionamento de sistemas bancários. O uso de `synchronized` garante integridade dos dados e impede condições de corrida, simulando com fidelidade operações financeiras reais.
