package original;

public class IncrementadorPeloNumeroDeCaracteresNumericos extends IncrementadorForcaDaSenha{

    String[] arrPwd;
    int countConsecutiveNumber = 0;
    int countSeqNumber = 0;

    IncrementadorPeloNumeroDeCaracteresNumericos(String senha) {
        peso = 4;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();

        testeConsecutivo();



        countSeqNumber = sequencia("01234567890");

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

    void testeConsecutivo() {
        Integer nTmpNumber = null;
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {
                if (nTmpNumber != null) {
                    if (nTmpNumber + 1 == i) {
                        countConsecutiveNumber++;
                    }
                }
                nTmpNumber = i;
            }
        }
    }
}
