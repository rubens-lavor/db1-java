package original;

import java.util.EnumMap;
import java.util.Map;

public class CriadorDasDependencias implements ColecaoDeDependencias {
    public CriadorDasDependencias(String s) {
        alocarDependencias(s);
        atribuirValoresMapContagemEBonus();
    }

    void alocarDependencias(String s) {

        mapDependencias.put("IPNDC", new IncrementadorPeloNumeroDeCaracteres(s));
        mapDependencias.put("IPNDCE", new IncrementadorPeloNumeroDeCaracteresEspeciais(s));
        mapDependencias.put("IPNDCENMS", new IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha(s));
        mapDependencias.put("IPNDCSN", new IncrementadorPeloNumeroDeCaracteresSequenciaisNumericos(s));
        mapDependencias.put("IPNDCSMa", new IncrementadorPeloNumeroDeLetrasMaiusculas(s));
        mapDependencias.put("IPNDCSMi", new IncrementadorPeloNumeroDeLetrasMinusculas(s));
        mapDependencias.put("IPNDR", new IncrementadorPeloNumeroDeRequerimentos());

    }

    @Override
    public int calcularSomatorioDeBonus() {
        int contagem = 0;
        for (EnumMap.Entry<Bonus, Integer> bonus : mapBonus.entrySet()) contagem += bonus.getValue();
        return contagem;
    }

    @Override
    public IncrementadorForcaDaSenha retornarUmaDependencia(String get) {
        for (Map.Entry<String, Object> dependencia : mapDependencias.entrySet()) {
            if (dependencia.getKey() == get) {
                return (IncrementadorForcaDaSenha) dependencia.getValue();
            }
        }
        return null;
    }

    @Override
    public void atribuirValoresMapContagemEBonus() {

        mapContagem.put(Contagem.TAM_SENHA, IncrementadorForcaDaSenha.countLength);
        mapContagem.put(Contagem.QNT_SIMBOLO, IncrementadorForcaDaSenha.countSymbol);
        mapContagem.put(Contagem.QNT_NUMERO, IncrementadorForcaDaSenha.countNumber);
        mapContagem.put(Contagem.QNT_LETRA_MINUSC, IncrementadorForcaDaSenha.countAlphaLC);
        mapContagem.put(Contagem.QNT_LETRA_MAIUSC, IncrementadorForcaDaSenha.countAlphaUC);
        mapContagem.put(Contagem.QNT_REQUERIMENTOS, IncrementadorForcaDaSenha.indiceRequerimentos);
        mapContagem.put(Contagem.QNT_CARACTER_REPETIDO, IncrementadorForcaDaSenha.countRepChar);
        mapContagem.put(Contagem.QNT_LETRA_MAIUSC_CONSECUTIVO, IncrementadorForcaDaSenha.countConsecutiveAlphaUC);
        mapContagem.put(Contagem.QNT_LETRA_MINUSC_CONSECUTIVO, IncrementadorForcaDaSenha.countConsecutiveAlphaLC);
        mapContagem.put(Contagem.QNT_NUMERO_CONSECUTIVO, IncrementadorForcaDaSenha.countConsecutiveNumber);
        mapContagem.put(Contagem.QNT_SEQUENCIA_LETRA, IncrementadorForcaDaSenha.countSeqAlpha);
        mapContagem.put(Contagem.QNT_SEQUENCIA_NUMERO, IncrementadorForcaDaSenha.countSeqNumber);
        mapContagem.put(Contagem.QNT_SEQUENCIA_SIMBOLO, IncrementadorForcaDaSenha.countSeqSymbol);
        mapContagem.put(Contagem.QNT_NUMERO_OU_SIMBOLO_NO_MEIO,IncrementadorForcaDaSenha.countNumerAndSymbol);


        int countSymbol = IncrementadorForcaDaSenha.countSymbol;
        int countNumber = IncrementadorForcaDaSenha.countNumber;
        int countLength = IncrementadorForcaDaSenha.countLength;
        int countAlphaLC = IncrementadorForcaDaSenha.countAlphaLC;
        int countAlphaUC = IncrementadorForcaDaSenha.countAlphaUC;

        if ((countSymbol == 0 && countNumber == 0)) {
            mapContagem.put(Contagem.APENAS_LETRAS, countLength);
            mapBonus.put(Bonus.APENAS_LETRAS, - IncrementadorForcaDaSenha.countLength);
        } else {
            mapContagem.put(Contagem.APENAS_LETRAS, 0);
            mapBonus.put(Bonus.APENAS_LETRAS, 0);
        }
        if ((countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0)) {
            mapContagem.put(Contagem.APENAS_NUMEROS, countLength);
            mapBonus.put(Bonus.APENAS_NUMEROS, - IncrementadorForcaDaSenha.countLength);
        } else {
            mapContagem.put(Contagem.APENAS_NUMEROS, 0);
            mapBonus.put(Bonus.APENAS_NUMEROS, 0);
        }


        /*Adicions bonus*/
        mapBonus.put(Bonus.TAM_SENHA, IncrementadorForcaDaSenha.countLength*4);
        mapBonus.put(Bonus.QNT_LETRA_MAIUSC, retornarUmaDependencia("IPNDCSMa").bonus);
        mapBonus.put(Bonus.QNT_LETRA_MINUSC, retornarUmaDependencia("IPNDCSMi").bonus);
        mapBonus.put(Bonus.QNT_NUMERO, IncrementadorForcaDaSenha.countNumber * 4);
        mapBonus.put(Bonus.QNT_NUMERO_OU_SIMBOLO_NO_MEIO, retornarUmaDependencia("IPNDCENMS").bonus);
        mapBonus.put(Bonus.QNT_SIMBOLO, IncrementadorForcaDaSenha.countSymbol * 6);
        mapBonus.put(Bonus.QNT_REQUERIMENTOS, retornarUmaDependencia("IPNDR").bonus);


        /*Deductions bonus*/
        if (0 != IncrementadorForcaDaSenha.countRepChar) {
            mapBonus.put(Bonus.QNT_CARACTER_REPETIDO, - (int) IncrementadorForcaDaSenha.incrementDeductionOfRepeatedChars);
        }else {
            mapBonus.put(Bonus.QNT_CARACTER_REPETIDO, 0);
        }

        mapBonus.put(Bonus.QNT_LETRA_MAIUSC_CONSECUTIVO, - IncrementadorForcaDaSenha.countConsecutiveAlphaUC * 2);
        mapBonus.put(Bonus.QNT_LETRA_MINUSC_CONSECUTIVO, - IncrementadorForcaDaSenha.countConsecutiveAlphaLC * 2);
        mapBonus.put(Bonus.QNT_NUMERO_CONSECUTIVO, - IncrementadorForcaDaSenha.countConsecutiveNumber * 2);

        mapBonus.put(Bonus.QNT_SEQUENCIA_LETRA, - IncrementadorForcaDaSenha.countSeqAlpha * 3);
        mapBonus.put(Bonus.QNT_SEQUENCIA_NUMERO, - IncrementadorForcaDaSenha.countSeqNumber * 3);
        mapBonus.put(Bonus.QNT_SEQUENCIA_SIMBOLO, - IncrementadorForcaDaSenha.countSeqSymbol * 3);

    }
}
