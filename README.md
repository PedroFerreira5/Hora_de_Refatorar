# Pedido Solid Java

Projeto Java para exemplificar a aplicação de princípios de design orientado a objetos, com foco em SRP, ISP, OCP, DIP e composição em vez de herança.

## Objetivo

Este projeto simula um fluxo de pedido com:
- cadastro de cliente, endereço e cidade;
- cálculo de total com desconto;
- escolha de forma de pagamento;
- cálculo de frete por tipo de entrega;
- persistência do pedido em arquivo;
- organização por camadas, seguindo uma arquitetura mais limpa e extensível.

## Estrutura do projeto

```text
Gestao/
├── .gitignore
├── README.md
├── lib/
├── src/
│   └── projetoprincipiosdesign/
│       ├── app/
│       │   └── Main.java
│       ├── dominio/
│       │   ├── Cidade.java
│       │   ├── Cliente.java
│       │   ├── Endereco.java
│       │   ├── ItemPedido.java
│       │   └── Pedido.java
│       ├── pagamento/
│       │   ├── Pagamento.java
│       │   ├── PagamentoCartao.java
│       │   ├── PagamentoPix.java
│       │   └── PagamentoBoleto.java
│       ├── desconto/
│       │   ├── Desconto.java
│       │   ├── DescontoAluno.java
│       │   ├── DescontoProfessor.java
│       │   └── DescontoFuncionario.java
│       ├── entrega/
│       │   ├── TipoEntrega.java
│       │   ├── EntregaDomicilio.java
│       │   └── RetiradaLoja.java
│       ├── persistencia/
│       │   ├── PedidoRepository.java
│       │   ├── PedidoRepositoryArquivo.java
│       │   └── PedidoRepositoryBanco.java
│       └── service/
│           └── PedidoService.java
├── bin/
└── pedidos.txt
```

## Principais princípios aplicados

- SRP: cada classe tem uma responsabilidade bem definida.
- OCP: novos descontos ou formas de pagamento podem ser adicionados sem mexer no fluxo principal.
- DIP: o serviço depende de abstrações e não de implementações fixas.
- ISP: interfaces de pagamento e entrega são menores e mais específicas.
- Composição: o serviço recebe dependências em vez de herdar comportamento.

## Como executar

No terminal, na raiz do projeto:

```bash
javac -d bin $(Get-ChildItem -Recurse -Filter *.java -Path src | Select-Object -ExpandProperty FullName)
java -cp bin projetoprincipiosdesign.app.Main
```

## Saída esperada

O programa imprime:
- cidade de entrega;
- total com desconto do aluno;
- resumo do pedido;
- pagamento no cartão;
- mensagem final de confirmação.

## Observação

Os arquivos compilados ficam em `bin/` e não devem ser versionados no Git. O arquivo `pedidos.txt` é gerado em tempo de execução.
