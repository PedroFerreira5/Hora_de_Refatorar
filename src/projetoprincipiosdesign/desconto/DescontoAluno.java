package projetoprincipiosdesign.desconto;

public class DescontoAluno implements Desconto {
    @Override
    public double calcular(double valor) {
        return valor * 0.90;
    }
}
