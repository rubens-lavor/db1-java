package original;

public abstract class IncrementadorForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    String[] arrPwd = {};

    protected static double incrementDeductionOfRepeatedChars = 0.0;
    protected static int indiceRequerimentos = 0;

    protected static int countSymbol = 0;
    protected static int countNumber = 0;
    protected static int countLength = 0;
    protected static int countAlphaLC = 0;
    protected static int countAlphaUC = 0;
    protected static int countRepChar = 0;
    protected static int countConsecutiveAlphaUC = 0;
    protected static int countConsecutiveAlphaLC = 0;
    protected static int countConsecutiveNumber = 0;
    protected static int countSeqAlpha = 0;
    protected static int countSeqNumber = 0;
    protected static int countSeqSymbol = 0;

    protected static int countNumerAndSymbol = 0;


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


    protected void testeRepeticao(){
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


    public abstract void calcularContagem();
    public abstract void calcularBonus();
}

