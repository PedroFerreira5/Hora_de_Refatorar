package projetoprincipiosdesign.desconto;

public class DescontoProfessor implements Desconto {
    @Override
    public double calcular(double valor) {
        return valor * 0.85;
    }
}
