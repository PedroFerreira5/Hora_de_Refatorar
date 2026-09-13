package projetoprincipiosdesign.desconto;

public class DescontoFuncionario implements Desconto {
    @Override
    public double calcular(double valor) {
        return valor * 0.80;
    }
}
