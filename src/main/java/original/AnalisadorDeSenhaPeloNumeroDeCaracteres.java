package original;

public class IncrementadorPeloNumeroDeCaracteres extends IncrementadorForcaDaSenha {

        public IncrementadorPeloNumeroDeCaracteres(String senha) {
            peso = 4;
            this.senha = senha;
            calcularContagem();
            calcularBonus();

            //testeRepeticao();
            tamanhoDaSenha = contagem;
            if (senha.length() >= 8) incrementarRequerimentos();
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