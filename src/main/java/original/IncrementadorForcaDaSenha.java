package original;

public abstract class IncrementadorForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    String[] arrPwd = {};

    protected static double incrementDeductionOfRepeatedChars = 0.0;
    //private static int countRepChar = 0;
    private static int countConsecutiveCaractere = 0;
    private static int indiceRequerimentos = 0;


    public int obterBonus(){
        return bonus;
    }
    public int obterContagem() {
        return contagem;
    }

    protected void checkRequerimentos(){
        indiceRequerimentos ++;
    }

    protected int obterRequerimentos() {
        if (indiceRequerimentos >= 5)  return 5;
        return indiceRequerimentos;
    }

    protected int testeRepeticao(){
        int countRepChar = 0;
        for (int i = 0; i < arrPwd.length; i++) {
            var bCharExists = false;
            for (int j = 0; j < arrPwd.length; j++) {
                if (arrPwd[i].equals(arrPwd[j]) && i != j) { /* repeat character exists */
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

        return countRepChar;
    }

    /*
    protected int testeLetrasConsecutivas() {
        Integer nTmpAlphaLC = null;
        int countConsecutiveAlphaLC = 0;
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

        return countConsecutiveAlphaLC;
    }
     */

    int sequencia(String sequencia) {
        int aux = 0;
        /* Check for sequential alpha string patterns (forward and reverse) */
        //String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
        int tamanho = sequencia.length() - 3;

        for (int i = 0; i < tamanho; i++) {
            String sFwd = sequencia.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {
                aux++;
            }
        }

        /* Check for sequential numeric string patterns (forward and reverse) */
        /*
        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {
                countSeqNumber++;
            }
        }
        */

        /* Check for sequential symbol string patterns (forward and reverse) */
        /*
        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {
                countSeqSymbol++;
            }
        }
         */

        return aux;
    }

    public abstract void calcularContagem();
    public abstract void calcularBonus();
}

