package original;

import enums.Regex;
import enums.Sequencia;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeCaracteresEspeciais extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {

    public AnalisadorDeSenhaPeloNumeroDeCaracteresEspeciais(String senha) {
        peso = 6;
        this.vetorSenha = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        calcularContagem();
        calcularBonus();

        contadorDeSimbolos = contagem;
        contadorSequenciaDeSimbolos = calcularQuantidadeDeCaracteresSequenciais(Sequencia.SIMBOLOS, senha);

        if (contagem > 0) incrementarRequerimentos();
    }

    @Override
    public void calcularContagem() {
        for (int i = 0; i < vetorSenha.length; i++) {
            if (vetorSenha[i].matches(Regex.SIMBOLO.obterRegex())) {
                contagem++;
            }

        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}
