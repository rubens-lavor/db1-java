package original;

import enums.Regex;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeLetrasMaiusculas extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {
    private String[] arrPwd;

    public AnalisadorDeSenhaPeloNumeroDeLetrasMaiusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        peso = 2;

        calcularContagem();
        calcularBonus();
        //testeRepeticao();

        contadorLetraMaiusculaConsecutiva = calcularConsecutivo(Regex.MAIUSCULA, arrPwd);
        contadorLetraMaiuscula = contagem;
        if (contagem > 0) incrementarRequerimentos();
    }


    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem == 0 ? 0 : (senha.length() - contagem) * peso;
    }

}