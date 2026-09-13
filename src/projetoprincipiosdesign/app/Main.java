package projetoprincipiosdesign.app;

import java.util.List;

import projetoprincipiosdesign.dominio.Cidade;
import projetoprincipiosdesign.dominio.Cliente;
import projetoprincipiosdesign.dominio.Endereco;
import projetoprincipiosdesign.dominio.ItemPedido;
import projetoprincipiosdesign.dominio.Pedido;
import projetoprincipiosdesign.desconto.DescontoAluno;
import projetoprincipiosdesign.entrega.EntregaDomicilio;
import projetoprincipiosdesign.pagamento.PagamentoCartao;
import projetoprincipiosdesign.persistencia.PedidoRepositoryArquivo;
import projetoprincipiosdesign.service.PedidoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LOJA ACADÊMICA ===");

        Cliente cliente = new Cliente(
            "Ana",
            new Endereco(
                "Rua das Flores",
                new Cidade("Belo Horizonte")
            )
        );

        Pedido pedido = new Pedido(
            cliente,
            List.of(
                new ItemPedido("Livro de Engenharia de Software", 120.0, 1),
                new ItemPedido("Caderno", 20.0, 2)
            )
        );

        PedidoService servico = new PedidoService(
            new PedidoRepositoryArquivo(),
            new EntregaDomicilio(),
            new DescontoAluno()
        );

        System.out.println();
        System.out.println("Cidade de entrega:");
        System.out.println(servico.obterCidadeEntrega(pedido));

        System.out.println();
        System.out.println("Total com desconto:");
        System.out.printf("R$ %.2f%n", servico.calcularTotal(pedido));

        System.out.println();
        System.out.println("Pagamento:");
        servico.finalizarPedido(pedido, new PagamentoCartao());

        System.out.println();
        System.out.println("Programa executado com sucesso.");
    }
}
