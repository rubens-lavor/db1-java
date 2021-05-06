package original;

public class NumeroDeCaractere extends IncrementaForcaDaSenha {

        public NumeroDeCaractere(String senha) {
            peso = 4;
            this.senha = senha;
            calculoContagem();
            calculoBonus();
            if (senha.length() >= 8) checkRequerimentos();
        }


        @Override
        public void calculoContagem() {

            contagem = senha.length();
        }

        @Override
        public void calculoBonus() {
            bonus = contagem * peso;
        }

}
