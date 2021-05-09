package original;

public class AnalisadorDeSenhaPeloNumeroDeRequerimentos extends AnalisadorDeIndicadoresDaSenha {

    public AnalisadorDeSenhaPeloNumeroDeRequerimentos() {
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
