package original;

import enums.Regex;
import enums.Sequencia;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeCaracteresSequenciaisNumericos extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {

    public AnalisadorDeSenhaPeloNumeroDeCaracteresSequenciaisNumericos(String senha) {
        peso = 4;
        this.vetorSenha = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();

        contadorDeNumeros = contagem;
        contadorSequenciaDeNumeros = calcularQuantidadeDeCaracteresSequenciais(Sequencia.NUMEROS, senha);
        contadorNumeroConsecutivo = calcularConsecutivo(Regex.NUMERO, vetorSenha);

        if (contagem > 0) {
            incrementarRequerimentos();
        }
    }
    @Override
    public void calcularContagem() {
        for (int i = 0; i < vetorSenha.length; i++) {
            if (vetorSenha[i].matches("[0-9]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }

}
