package original;

public class NumeroDeRequerimentos extends IncrementaForcaDaSenha{

    public NumeroDeRequerimentos() {
        peso = 2;
        calculoContagem();
        calculoBonus();
    }

    @Override
    public void calculoContagem() {
        contagem = obterRequerimentos();
    }

    @Override
    public void calculoBonus() {
        if (obterRequerimentos() <= 3) {
            bonus = 0;
        } else {
            bonus = contagem * peso;
        }
    }
}
