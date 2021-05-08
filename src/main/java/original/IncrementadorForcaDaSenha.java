package original;

public abstract class IncrementadorForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    String[] arrPwd = {};

    protected static double incrementDeductionOfRepeatedChars = 0.0;
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

    public abstract void calcularContagem();
    public abstract void calcularBonus();
}

