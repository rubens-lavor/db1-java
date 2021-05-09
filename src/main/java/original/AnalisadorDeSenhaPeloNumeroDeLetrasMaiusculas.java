package original;

import enums.Regex;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeLetrasMaiusculas extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {

    public AnalisadorDeSenhaPeloNumeroDeLetrasMaiusculas(String senha) {
        this.vetorSenha = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        peso = 2;

        calcularContagem();
        calcularBonus();

        contadorLetraMaiusculaConsecutiva = calcularConsecutivo(Regex.MAIUSCULA, vetorSenha);
        contadorLetraMaiuscula = contagem;
        if (contagem > 0) incrementarRequerimentos();
    }


    @Override
    public void calcularContagem() {
        for (int i = 0; i < vetorSenha.length; i++) {
            if (vetorSenha[i].matches("[A-Z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem == 0 ? 0 : (senha.length() - contagem) * peso;
    }

}