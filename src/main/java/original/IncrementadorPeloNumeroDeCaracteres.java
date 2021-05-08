package original;

public class IncrementadorPeloNumeroDeCaracteres extends IncrementadorForcaDaSenha {

        int countSeqAlpha = 0;
        int countSeqNumber = 0;
        int countSeqSymbol = 0;
        int countRepChar = 0;

        public IncrementadorPeloNumeroDeCaracteres(String senha) {
            peso = 4;
            this.senha = senha;
            calcularContagem();
            calcularBonus();

            countRepChar = testeRepeticao();

            testeSequencia();
            if (senha.length() >= 8) checkRequerimentos();
        }


        @Override
        public void calcularContagem() {

            contagem = senha.length();
        }

        @Override
        public void calcularBonus() {
            bonus = contagem * peso;
        }

        /*criar uma clase abstrata para sequencia*/
        void testeSequencia(){
            /* Check for sequential alpha string patterns (forward and reverse) */
            String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
            int tamanho = ALPHAS.length() - 3;
            for (int i = 0; i < tamanho; i++) {
                String sFwd = ALPHAS.substring(i, i + 3);
                String sRev = new StringBuilder(sFwd).reverse().toString();
                if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {
                    countSeqAlpha++;
                }
            }

            /* Check for sequential numeric string patterns (forward and reverse) */
            for (int i = 0; i < 8; i++) {
                String DIGITS = "01234567890";
                String sFwd = DIGITS.substring(i, i + 3);
                String sRev = new StringBuilder(sFwd).reverse().toString();
                if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {
                    countSeqNumber++;
                }
            }

            /* Check for sequential symbol string patterns (forward and reverse) */
            for (int i = 0; i < 8; i++) {
                String SYMBOLS = ")!@#$%^&*()";
                String sFwd = SYMBOLS.substring(i, i + 3);
                String sRev = new StringBuilder(sFwd).reverse().toString();
                if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {
                    countSeqSymbol++;
                }
            }
        }

}
