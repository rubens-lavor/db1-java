package original;

public class IncrementadorPeloNumeroDeLetrasMinusculas extends AnalisadorDeIndicadoresDaSenha implements AnalisadorDeCaracteresSequenciais {

    public IncrementadorPeloNumeroDeLetrasMinusculas(String senha) {
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
    public void calcularContagem() {
        for (int i = 0; i < vetorSenha.length; i++) {
            if (vetorSenha[i].matches("[a-z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem == 0 ? 0 : (senha.length() - contagem) * peso;
    }

}
