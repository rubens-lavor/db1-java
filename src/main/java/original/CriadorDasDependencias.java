package fabrica_dependencias;

import enums.Bonus;
import enums.Contagem;
import original.*;

import java.util.EnumMap;
import java.util.Map;

public class CriadorDasDependencias implements ColecaoDeDependencias {
    public CriadorDasDependencias(String s) {
        alocarDependencias(s);
        atribuirValoresMapContagemEBonus();
    }

    void alocarDependencias(String s) {

        mapDependencias.put("IPNDC", new AnalisadorDeSenhaPeloNumeroDeCaracteres(s));
        mapDependencias.put("IPNDCE", new AnalisadorDeSenhaPeloNumeroDeCaracteresEspeciais(s));
        mapDependencias.put("IPNDCENMS", new AnalisadorDeSenhaPeloNumeroDeCaracteresNumericosEEspeciaisNoMeioDaSenha(s));
        mapDependencias.put("IPNDCSN", new AnalisadorDeSenhaPeloNumeroDeCaracteresSequenciaisNumericos(s));
        mapDependencias.put("IPNDCSMa", new AnalisadorDeSenhaPeloNumeroDeLetrasMaiusculas(s));
        mapDependencias.put("IPNDCSMi", new AnalisadorDeSenhaPeloNumeroDeLetrasMinusculas(s));
        mapDependencias.put("IPNDR", new AnalisadorDeSenhaPeloNumeroDeRequerimentos());

    }

    @Override
    public int calcularSomatorioDeBonus() {
        int contagem = 0;
        for (EnumMap.Entry<Bonus, Integer> bonus : mapBonus.entrySet()) contagem += bonus.getValue();
        return contagem;
    }

    @Override
    public AnalisadorDeIndicadoresDaSenha retornarUmaDependencia(String get) {
        for (Map.Entry<String, Object> dependencia : mapDependencias.entrySet()) {
            if (dependencia.getKey() == get) {
                return (AnalisadorDeIndicadoresDaSenha) dependencia.getValue();
            }
        }
        return null;
    }

    @Override
    public void atribuirValoresMapContagemEBonus() {

        mapContagem.put(Contagem.TAM_SENHA, AnalisadorDeIndicadoresDaSenha.tamanhoDaSenha);
        mapContagem.put(Contagem.QNT_SIMBOLO, AnalisadorDeIndicadoresDaSenha.contadorDeSimbolos);
        mapContagem.put(Contagem.QNT_NUMERO, AnalisadorDeIndicadoresDaSenha.contadorDeNumeros);
        mapContagem.put(Contagem.QNT_LETRA_MINUSC, AnalisadorDeIndicadoresDaSenha.contadorLetraMinuscula);
        mapContagem.put(Contagem.QNT_LETRA_MAIUSC, AnalisadorDeIndicadoresDaSenha.contadorLetraMaiuscula);
        mapContagem.put(Contagem.QNT_REQUERIMENTOS, AnalisadorDeIndicadoresDaSenha.contadorRequerimentos);
        mapContagem.put(Contagem.QNT_CARACTER_REPETIDO, AnalisadorDeIndicadoresDaSenha.contadorCaracteresRepetidos);
        mapContagem.put(Contagem.QNT_LETRA_MAIUSC_CONSECUTIVO, AnalisadorDeIndicadoresDaSenha.contadorLetraMaiusculaConsecutiva);
        mapContagem.put(Contagem.QNT_LETRA_MINUSC_CONSECUTIVO, AnalisadorDeIndicadoresDaSenha.contadorLetraMinusculaConsecutiva);
        mapContagem.put(Contagem.QNT_NUMERO_CONSECUTIVO, AnalisadorDeIndicadoresDaSenha.contadorNumeroConsecutivo);
        mapContagem.put(Contagem.QNT_SEQUENCIA_LETRA, AnalisadorDeIndicadoresDaSenha.contadorSequenciaDeLetras);
        mapContagem.put(Contagem.QNT_SEQUENCIA_NUMERO, AnalisadorDeIndicadoresDaSenha.contadorSequenciaDeNumeros);
        mapContagem.put(Contagem.QNT_SEQUENCIA_SIMBOLO, AnalisadorDeIndicadoresDaSenha.contadorSequenciaDeSimbolos);
        mapContagem.put(Contagem.QNT_NUMERO_OU_SIMBOLO_NO_MEIO, AnalisadorDeIndicadoresDaSenha.contadorNumerosESimbolosNoMeioDaSenha);


        int countSymbol = AnalisadorDeIndicadoresDaSenha.contadorDeSimbolos;
        int countNumber = AnalisadorDeIndicadoresDaSenha.contadorDeNumeros;
        int countLength = AnalisadorDeIndicadoresDaSenha.tamanhoDaSenha;
        int countAlphaLC = AnalisadorDeIndicadoresDaSenha.contadorLetraMinuscula;
        int countAlphaUC = AnalisadorDeIndicadoresDaSenha.contadorLetraMaiuscula;

        if ((countSymbol == 0 && countNumber == 0)) {
            mapContagem.put(Contagem.APENAS_LETRAS, countLength);
            mapBonus.put(Bonus.APENAS_LETRAS, - AnalisadorDeIndicadoresDaSenha.tamanhoDaSenha);
        } else {
            mapContagem.put(Contagem.APENAS_LETRAS, 0);
            mapBonus.put(Bonus.APENAS_LETRAS, 0);
        }
        if ((countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0)) {
            mapContagem.put(Contagem.APENAS_NUMEROS, countLength);
            mapBonus.put(Bonus.APENAS_NUMEROS, - AnalisadorDeIndicadoresDaSenha.tamanhoDaSenha);
        } else {
            mapContagem.put(Contagem.APENAS_NUMEROS, 0);
            mapBonus.put(Bonus.APENAS_NUMEROS, 0);
        }


        /*Adicions bonus*/
        mapBonus.put(Bonus.TAM_SENHA, AnalisadorDeIndicadoresDaSenha.tamanhoDaSenha *4);
        mapBonus.put(Bonus.QNT_LETRA_MAIUSC, retornarUmaDependencia("IPNDCSMa").bonus);
        mapBonus.put(Bonus.QNT_LETRA_MINUSC, retornarUmaDependencia("IPNDCSMi").bonus);
        mapBonus.put(Bonus.QNT_NUMERO, AnalisadorDeIndicadoresDaSenha.contadorDeNumeros * 4);
        mapBonus.put(Bonus.QNT_NUMERO_OU_SIMBOLO_NO_MEIO, retornarUmaDependencia("IPNDCENMS").bonus);
        mapBonus.put(Bonus.QNT_SIMBOLO, AnalisadorDeIndicadoresDaSenha.contadorDeSimbolos * 6);
        mapBonus.put(Bonus.QNT_REQUERIMENTOS, retornarUmaDependencia("IPNDR").bonus);


        /*Deductions bonus*/
        if (0 != AnalisadorDeIndicadoresDaSenha.contadorCaracteresRepetidos) {
            mapBonus.put(Bonus.QNT_CARACTER_REPETIDO, - (int) AnalisadorDeIndicadoresDaSenha.incrementDeductionOfRepeatedChars);
        }else {
            mapBonus.put(Bonus.QNT_CARACTER_REPETIDO, 0);
        }

        mapBonus.put(Bonus.QNT_LETRA_MAIUSC_CONSECUTIVO, - AnalisadorDeIndicadoresDaSenha.contadorLetraMaiusculaConsecutiva * 2);
        mapBonus.put(Bonus.QNT_LETRA_MINUSC_CONSECUTIVO, - AnalisadorDeIndicadoresDaSenha.contadorLetraMinusculaConsecutiva * 2);
        mapBonus.put(Bonus.QNT_NUMERO_CONSECUTIVO, - AnalisadorDeIndicadoresDaSenha.contadorNumeroConsecutivo * 2);

        mapBonus.put(Bonus.QNT_SEQUENCIA_LETRA, - AnalisadorDeIndicadoresDaSenha.contadorSequenciaDeLetras * 3);
        mapBonus.put(Bonus.QNT_SEQUENCIA_NUMERO, - AnalisadorDeIndicadoresDaSenha.contadorSequenciaDeNumeros * 3);
        mapBonus.put(Bonus.QNT_SEQUENCIA_SIMBOLO, - AnalisadorDeIndicadoresDaSenha.contadorSequenciaDeSimbolos * 3);

    }
}
