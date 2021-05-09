package original;

public enum Contagem {
   QNT_SIMBOLO("QuantidadeDeSimbolos"),
   QNT_NUMERO("QuantidadeDeNumeros"),
   TAM_SENHA("TamanhoDaSenha"),
   QNT_LETRA_MINUSC("QuantidadeDeLetraMinuscula"),
   QNT_LETRA_MAIUSC("QuantidadeDeLetraMaiuscula"),
   QNT_CARACTER_REPETIDO("CaracteresRepetidos"),
   QNT_LETRA_MAIUSC_CONSECUTIVO("LetraMaiusculaConsecutiva"),
   QNT_LETRA_MINUSC_CONSECUTIVO("LetraMinusculaConsecutiva"),
   QNT_NUMERO_CONSECUTIVO("NumeroConsecutivo"),
   QNT_SEQUENCIA_LETRA("SequenciaLetras"),
   QNT_SEQUENCIA_NUMERO("SequenciaNumeros"),
   QNT_SEQUENCIA_SIMBOLO("SequenciaSimbolos"),
   QNT_REQUERIMENTOS("QuantidadeDeRequerimentos"),
   QNT_NUMERO_OU_SIMBOLO_NO_MEIO("QuantidadeDeNumeroOuSimboloNoMeio"),
   APENAS_LETRAS("ApenasLetras"),
   APENAS_NUMEROS("ApenasNumeros");

    private String contagem;

    Contagem(String contagem){
        this.contagem = contagem;
    }

    public String obterContagem(){
        return contagem;
    }
}
