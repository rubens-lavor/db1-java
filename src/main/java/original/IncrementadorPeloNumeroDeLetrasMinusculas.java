package original;

public class IncrementadorPeloNumeroDeLetrasMinusculas extends IncrementadorForcaDaSenha implements AnalisadorDeCaracteresSequenciais {

    public IncrementadorPeloNumeroDeLetrasMinusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        peso = 2;

        calcularContagem();
        calcularBonus();

        testeRepeticao();

        countSeqAlpha = calcularQuantidadeDeCaracteresSequenciais(Sequencia.LETRAS, senha);
        countConsecutiveAlphaLC = calcularConsecutivo(Regex.MINUSCULA, arrPwd);
        countAlphaLC = contagem;
        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem == 0 ? 0 : (senha.length() - contagem) * peso;
    }

}
