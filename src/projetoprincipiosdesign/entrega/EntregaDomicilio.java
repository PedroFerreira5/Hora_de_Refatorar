package projetoprincipiosdesign.entrega;

public class EntregaDomicilio implements TipoEntrega {
    @Override
    public double calcularFrete(double valor) {
        return valor >= 200 ? 0.0 : 15.0;
    }
}
