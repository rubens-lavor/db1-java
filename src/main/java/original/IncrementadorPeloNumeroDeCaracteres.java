package original;

public class IncrementadorPeloNumeroDeCaracteres extends IncrementadorForcaDaSenha {

        public IncrementadorPeloNumeroDeCaracteres(String senha) {
            peso = 4;
            this.senha = senha;
            calcularContagem();
            calcularBonus();

            //testeRepeticao();
            countLength = contagem;
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
