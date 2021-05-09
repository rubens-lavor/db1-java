package original;

public abstract class AnalisadorDeIndicadoresDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    String[] vetorSenha = {};

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

    protected void incrementarRequerimentos(){
        contadorRequerimentos++;
    }

    protected int obterRequerimentos() {
        if (contadorRequerimentos >= 5)  return 5;
        return contadorRequerimentos;
    }

    protected void verificarCaracteresRepetidos(){
        for (int i = 0; i < vetorSenha.length; i++) {
            var bCharExists = false;
            for (int j = 0; j < vetorSenha.length; j++) {
                if (vetorSenha[i].equals(vetorSenha[j]) && i != j) {
                    bCharExists = true;
                    incrementDeductionOfRepeatedChars += Math.abs(vetorSenha.length / (j - i));
                }
            }
            if (bCharExists) {
                contadorCaracteresRepetidos++;
                int countUniqueCharacters = vetorSenha.length - contadorCaracteresRepetidos;
                incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars);
            }
        }

    }

    protected abstract void calcularContagem();
    protected abstract void calcularBonus();
}

