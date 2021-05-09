package original;

import enums.Regex;
import enums.Sequencia;
import interfaces.AnalisadorDeCaracteresSequenciais;

public class AnalisadorDeSenhaPeloNumeroDeCaracteresSequenciaisNumericos extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {
    String[] arrPwd;

    public AnalisadorDeSenhaPeloNumeroDeCaracteresSequenciaisNumericos(String senha) {
        peso = 4;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();

        //testeRepeticao();
        contadorDeNumeros = contagem;
        contadorSequenciaDeNumeros = calcularQuantidadeDeCaracteresSequenciais(Sequencia.NUMEROS, senha);
        contadorNumeroConsecutivo = calcularConsecutivo(Regex.NUMERO, arrPwd);

        if (contagem > 0) {
            incrementarRequerimentos();
        }
    }
    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }

}
