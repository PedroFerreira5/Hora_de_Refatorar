package projetoprincipiosdesign.service;

import projetoprincipiosdesign.dominio.ItemPedido;
import projetoprincipiosdesign.dominio.Pedido;
import projetoprincipiosdesign.desconto.Desconto;
import projetoprincipiosdesign.entrega.TipoEntrega;
import projetoprincipiosdesign.pagamento.Pagamento;
import projetoprincipiosdesign.persistencia.PedidoRepository;

public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final TipoEntrega tipoEntrega;
    private final Desconto desconto;

    public PedidoService(PedidoRepository pedidoRepository, TipoEntrega tipoEntrega, Desconto desconto) {
        this.pedidoRepository = pedidoRepository;
        this.tipoEntrega = tipoEntrega;
        this.desconto = desconto;
    }

    public double calcularTotal(Pedido pedido) {
        double total = 0.0;

        for (ItemPedido item : pedido.getItens()) {
            total += item.getPreco() * item.getQuantidade();
        }

        return desconto.calcular(total);
    }

    public double calcularFrete(Pedido pedido) {
        double totalComDesconto = calcularTotal(pedido);
        return tipoEntrega.calcularFrete(totalComDesconto);
    }

    public String obterCidadeEntrega(Pedido pedido) {
        return pedido.getCliente().getEndereco().getCidade().getNome();
    }

    public void finalizarPedido(Pedido pedido, Pagamento pagamento) {
        double totalComDesconto = calcularTotal(pedido);
        double frete = calcularFrete(pedido);
        double valorFinal = totalComDesconto + frete;

        System.out.println("Salvando pedido...");
        pedidoRepository.salvar(pedido, valorFinal);

        System.out.println("Gerando resumo do pedido...");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.printf("Subtotal com desconto: R$ %.2f%n", totalComDesconto);
        System.out.printf("Frete: R$ %.2f%n", frete);
        System.out.printf("Total final: R$ %.2f%n", valorFinal);

        pagamento.pagar(valorFinal);

        System.out.println(
            "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
        );
    }
}
