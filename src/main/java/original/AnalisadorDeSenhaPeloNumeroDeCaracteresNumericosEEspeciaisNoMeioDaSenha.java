package original;

import enums.Regex;

public class AnalisadorDeSenhaPeloNumeroDeCaracteresNumericosEEspeciaisNoMeioDaSenha extends AnalisadorDeIndicadoresDaSenha {

    public AnalisadorDeSenhaPeloNumeroDeCaracteresNumericosEEspeciaisNoMeioDaSenha(String senha) {
        peso = 2;
        this.vetorSenha = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();
        contadorNumerosESimbolosNoMeioDaSenha = contagem;
    }

    @Override
    public void calcularContagem() {

        for (int i = 0; i < vetorSenha.length; i++) {
         if (vetorSenha[i].matches(Regex.NUMERO.obterRegex())) {
                if (i > 0 && i < vetorSenha.length - 1) {
                    contagem++;
                }
            } else if (vetorSenha[i].matches(Regex.SIMBOLO.obterRegex())) {
                if (i > 0 && i < vetorSenha.length - 1) {
                    contagem++;
                }
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}
