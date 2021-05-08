package original;

public interface AnalisadorSequenciaDeCaracteres {

    default int teste(Sequencia _sequencia, String palavra){

        String sequencia = _sequencia.obterSequencia();
        int countSeq = 0;
        int tamanho = sequencia.length() - 3;

        /* Check for sequential alpha string patterns (forward and reverse) */
        //String ALPHAS = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < tamanho; i++) {
            String sFwd = sequencia.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (palavra.toLowerCase().contains(sFwd) || palavra.toLowerCase().contains(sRev)) {
                countSeq++;
            }
        }
        return countSeq;
    }
}
