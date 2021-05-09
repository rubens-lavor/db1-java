package original;

public class AnalisadorDeSenhaPeloNumeroDeCaracteres extends AnalisadorDeIndicadoresDaSenha {

        public AnalisadorDeSenhaPeloNumeroDeCaracteres(String senha) {
            peso = 4;
            this.senha = senha;
            calcularContagem();
            calcularBonus();

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
