package original;

public class IncrementadorPeloNumeroDeCaracteresSequenciaisNumericos extends IncrementadorForcaDaSenha implements AnalisadorDeCaracteresSequenciais {

    String[] arrPwd;
    int countConsecutiveNumber = 0;
    int countSeqNumber = 0;


    /*Deductions*/
    protected int contagemSomenteNumeros = 0;
    protected int bonusSomenteNumeros = 0;

    IncrementadorPeloNumeroDeCaracteresSequenciaisNumericos(String senha) {
        peso = 4;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();

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
