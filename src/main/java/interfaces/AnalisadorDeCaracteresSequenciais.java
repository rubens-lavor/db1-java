package interfaces;

import enums.Regex;
import enums.Sequencia;

public interface AnalisadorDeCaracteresSequenciais {

    default int calcularQuantidadeDeCaracteresSequenciais(Sequencia _sequencia, String palavra){

        String sequencia = _sequencia.obterSequencia();
        int countSeq = 0;
        int tamanho = sequencia.length() - 3;

        for (int i = 0; i < tamanho; i++) {
            String sFwd = sequencia.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (palavra.toLowerCase().contains(sFwd) || palavra.toLowerCase().contains(sRev)) {
                countSeq++;
            }
        }
        return countSeq;
    }

    default int calcularConsecutivo(Regex _regex, String[] arrPwd){
        Integer numeroAux = null;
        int qndtadeCaracteresConsecutivos = 0;
        String regex = _regex.obterRegex();

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches(regex)) {
                if (numeroAux != null) {
                    if (numeroAux + 1 == i) {
                        qndtadeCaracteresConsecutivos++;
                    }
                }
                numeroAux = i;
            }
        }
        return qndtadeCaracteresConsecutivos;
    }
}
