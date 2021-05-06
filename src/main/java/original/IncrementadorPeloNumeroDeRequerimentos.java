package original;

public class IncrementadorPeloNumeroDeRequerimentos extends IncrementadorForcaDaSenha{

    public IncrementadorPeloNumeroDeRequerimentos() {
        peso = 2;
        calcularContagem();
        calcularBonus();
    }

    @Override
    public void calcularContagem() {
        contagem = obterRequerimentos();
    }

    @Override
    public void calcularBonus() {
        if (obterRequerimentos() <= 3) {
            bonus = 0;
        } else {
            bonus = contagem * peso;
        }
    }
}
