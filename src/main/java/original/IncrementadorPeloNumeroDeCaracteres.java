package original;

public class IncrementadorPeloNumeroDeCaracteres extends IncrementadorForcaDaSenha {

        int countRepChar = 0;

        public IncrementadorPeloNumeroDeCaracteres(String senha) {
            peso = 4;
            this.senha = senha;
            calcularContagem();
            calcularBonus();

            countRepChar = testeRepeticao();

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

}
