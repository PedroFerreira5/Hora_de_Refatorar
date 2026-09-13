package projetoprincipiosdesign.persistencia;

import projetoprincipiosdesign.dominio.Pedido;

public class PedidoRepositoryBanco implements PedidoRepository {
    @Override
    public void salvar(Pedido pedido, double valorTotal) {
        System.out.printf("Pedido salvo no banco para %s - total: R$ %.2f%n",
            pedido.getCliente().getNome(), valorTotal);
    }
}
