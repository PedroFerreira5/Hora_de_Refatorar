package projetoprincipiosdesign.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import projetoprincipiosdesign.dominio.Pedido;

public class PedidoRepositoryArquivo implements PedidoRepository {
    @Override
    public void salvar(Pedido pedido, double valorTotal) {
        String linha = pedido.getCliente().getNome() + ";" + valorTotal + System.lineSeparator();
        try {
            Files.writeString(
                Path.of("pedidos.txt"),
                linha,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o pedido em arquivo.", e);
        }
    }
}
