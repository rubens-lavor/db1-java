package enums;

public enum Bonus {
    QNT_SIMBOLO("BonusQuantidadeDeSimbolos"),
    QNT_NUMERO("BonusQuantidadeDeNumeros"),
    TAM_SENHA("BonusTamanhoDaSenha"),
    QNT_LETRA_MINUSC("BonusQuantidadeDeLetraMinuscula"),
    QNT_LETRA_MAIUSC("BonusQuantidadeDeLetraMaiuscula"),
    QNT_CARACTER_REPETIDO("BonusCaracteresRepetidos"),
    QNT_LETRA_MAIUSC_CONSECUTIVO("BonusLetraMaiusculaConsecutiva"),
    QNT_LETRA_MINUSC_CONSECUTIVO("BonusLetraMinusculaConsecutiva"),
    QNT_NUMERO_CONSECUTIVO("BonusNumeroConsecutivo"),
    QNT_SEQUENCIA_LETRA("BonusSequenciaLetras"),
    QNT_SEQUENCIA_NUMERO("BonusSequenciaNumeros"),
    QNT_SEQUENCIA_SIMBOLO("BonusSequenciaSimbolos"),
    QNT_REQUERIMENTOS("BonusQuantidadeDeRequerimentos"),
    QNT_NUMERO_OU_SIMBOLO_NO_MEIO("BonusQuantidadeDeNumeroOuSimboloNoMeio"),
    APENAS_LETRAS("BonusApenasLetras"),
    APENAS_NUMEROS("BonusApenasNumeros");

    private String bonus;

    Bonus(String bonus) {
        this.bonus = bonus;
    }
}