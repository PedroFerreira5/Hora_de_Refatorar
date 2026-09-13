package projetoprincipiosdesign.persistencia;

import projetoprincipiosdesign.dominio.Pedido;

public interface PedidoRepository {
    void salvar(Pedido pedido, double valorTotal);
}
