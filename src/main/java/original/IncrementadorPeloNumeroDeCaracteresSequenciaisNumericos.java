package original;

public class IncrementadorPeloNumeroDeCaracteresSequenciaisNumericos extends IncrementadorForcaDaSenha implements AnalisadorDeCaracteresSequenciais {
    String[] arrPwd;

    IncrementadorPeloNumeroDeCaracteresSequenciaisNumericos(String senha) {
        peso = 4;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();

        //testeRepeticao();
        countNumber = contagem;
        countSeqNumber = calcularQuantidadeDeCaracteresSequenciais(Sequencia.NUMEROS, senha);
        countConsecutiveNumber = calcularConsecutivo(Regex.NUMERO, arrPwd);

        if (contagem > 0) {
            checkRequerimentos();
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
