package original;

import enums.Sequencia;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeCaracteresEspeciais extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {
    String[] arrPwd;

    public AnalisadorDeSenhaPeloNumeroDeCaracteresEspeciais(String senha) {
        peso = 6;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        calcularContagem();
        calcularBonus();

        contadorDeSimbolos = contagem;
        contadorSequenciaDeSimbolos = calcularQuantidadeDeCaracteresSequenciais(Sequencia.SIMBOLOS, senha);
        //testeRepeticao();

        if (contagem > 0) incrementarRequerimentos();
    }

    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                contagem++;
            }

        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}
