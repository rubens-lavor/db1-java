package original;

public class AnalisadorDeSenhaPeloNumeroDeRequerimentos extends AnalisadorDeIndicadoresDaSenha {

    public AnalisadorDeSenhaPeloNumeroDeRequerimentos() {
        peso = 2;
        calcularContagem();
        calcularBonus();
    }

    @Override
    protected void calcularContagem() {
        contagem = obterRequerimentos();
    }

    @Override
    protected void calcularBonus() {
        if (obterRequerimentos() <= 3) {
            bonus = 0;
        } else {
            bonus = contagem * peso;
        }
    }
}
