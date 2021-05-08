package original;

public class IncrementadorPeloNumeroDeLetrasMinusculas extends IncrementadorForcaDaSenha {
    private String[] arrPwd;
    //protected double incrementDeductionOfRepeatedChars = 0.0;
    protected int countRepChar = 0;

    protected int countConsecutiveAlphaLC = 0;
    int countSeqAlpha = 0;

    public IncrementadorPeloNumeroDeLetrasMinusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        peso = 2;

        calcularContagem();
        calcularBonus();

        testeRepeticao();
        testeConsecutivo();

        countSeqAlpha = sequencia("abcdefghijklmnopqrstuvwxyz");

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
        bonus = (senha.length() - contagem) * peso;
    }


    /*
    private void testeRepeticao(){
        for (int i = 0; i < arrPwd.length; i++) {
            var bCharExists = false;
            for (int j = 0; j < arrPwd.length; j++) {
                if (arrPwd[i].equals(arrPwd[j]) && i != j) {
                    bCharExists = true;
                    incrementDeductionOfRepeatedChars += Math.abs(arrPwd.length / (j - i));
                }
            }
            if (bCharExists) {
                countRepChar++;
                int countUniqueCharacters = arrPwd.length - countRepChar;
                incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars);
            }
        }
    }

     */

    void testeConsecutivo() {
        Integer nTmpAlphaLC = null;
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveAlphaLC++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
    }
}
