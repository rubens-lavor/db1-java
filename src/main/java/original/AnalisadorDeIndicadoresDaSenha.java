package original;

public abstract class IncrementadorForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    String[] arrPwd = {};

    protected static double incrementDeductionOfRepeatedChars = 0.0;
    protected static int contadorRequerimentos = 0;

    protected static int contadorDeSimbolos = 0;
    protected static int contadorDeNumeros = 0;
    protected static int tamanhoDaSenha = 0;
    protected static int contadorLetraMinuscula = 0;
    protected static int contadorLetraMaiuscula = 0;
    protected static int contadorCaracteresRepetidos = 0;
    protected static int contadorLetraMaiusculaConsecutiva = 0;
    protected static int contadorLetraMinusculaConsecutiva = 0;
    protected static int contadorNumeroConsecutivo = 0;
    protected static int contadorSequenciaDeLetras = 0;
    protected static int contadorSequenciaDeNumeros = 0;
    protected static int contadorSequenciaDeSimbolos = 0;

    protected static int contadorNumerosESimbolosNoMeioDaSenha = 0;


    public int obterBonus(){
        return bonus;
    }
    public int obterContagem() {
        return contagem;
    }
    protected void incrementarRequerimentos(){
        contadorRequerimentos++;
    }

    protected int obterRequerimentos() {
        if (contadorRequerimentos >= 5)  return 5;
        return contadorRequerimentos;
    }

    protected void verificarCaracteresRepetidos(){
        for (int i = 0; i < arrPwd.length; i++) {
            var bCharExists = false;
            for (int j = 0; j < arrPwd.length; j++) {
                if (arrPwd[i].equals(arrPwd[j]) && i != j) {
                    bCharExists = true;
                    incrementDeductionOfRepeatedChars += Math.abs(arrPwd.length / (j - i));
                }
            }
            if (bCharExists) {
                contadorCaracteresRepetidos++;
                int countUniqueCharacters = arrPwd.length - contadorCaracteresRepetidos;
                incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars);
            }
        }

    }

    protected abstract void calcularContagem();
    protected abstract void calcularBonus();
}

