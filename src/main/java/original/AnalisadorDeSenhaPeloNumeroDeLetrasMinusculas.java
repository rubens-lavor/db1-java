package original;

import enums.Regex;
import enums.Sequencia;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeLetrasMinusculas extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {

    public AnalisadorDeSenhaPeloNumeroDeLetrasMinusculas(String senha) {
        this.vetorSenha = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        peso = 2;

        calcularContagem();
        calcularBonus();

        verificarCaracteresRepetidos();

        contadorSequenciaDeLetras = calcularQuantidadeDeCaracteresSequenciais(Sequencia.LETRAS, senha);
        contadorLetraMinusculaConsecutiva = calcularConsecutivo(Regex.MINUSCULA, vetorSenha);
        contadorLetraMinuscula = contagem;
        if (contagem > 0) incrementarRequerimentos();
    }


    @Override
    protected void calcularContagem() {
        for (int i = 0; i < vetorSenha.length; i++) {
            if (vetorSenha[i].matches("[a-z]")) {
                contagem++;
            }
        }
    }

    @Override
    protected void calcularBonus() {
        bonus = contagem == 0 ? 0 : (senha.length() - contagem) * peso;
    }

}
