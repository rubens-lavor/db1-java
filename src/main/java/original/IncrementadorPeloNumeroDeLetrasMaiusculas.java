package original;

public class IncrementadorPeloNumeroDeLetrasMaiusculas extends IncrementadorForcaDaSenha {
    private String[] arrPwd;

    protected int countConsecutiveAlphaUC = 0;

    public IncrementadorPeloNumeroDeLetrasMaiusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        peso = 2;

        calcularContagem();
        calcularBonus();
        testeRepeticao();

        testeConsecutivo();

        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calcularContagem() {
        // String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
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

    void testeConsecutivo(){
        Integer nTmpAlphaUC = null;
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        countConsecutiveAlphaUC++;
                    }
                }
                nTmpAlphaUC = i;
            }
        }
    }

}