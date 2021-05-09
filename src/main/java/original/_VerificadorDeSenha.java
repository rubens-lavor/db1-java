package original;

import java.util.EnumMap;

public class _VerificadorDeSenha {
        private int forcaDaSenha = 0;
        private final String senha;

        private final EnumMap<Contagem, Integer> mapContagem;
        private final EnumMap<Bonus, Integer> mapBonus;
        private final _Impressora impressora;

        public _VerificadorDeSenha(String senha, InstanciadorParaCriacaoDeDependencias _dependencias) {
            this.senha = senha;
            var dependencias = _dependencias.fabricarInstanciaDeDependencias(senha);

            mapContagem = dependencias.retornarMapContagem();
            mapBonus = dependencias.retornarMapBonus();

            int soma = dependencias.calcularSomatorioDeBonus();
            calcularForcaDaSenha(soma);

            if (forcaDaSenha > 100) {
                forcaDaSenha = 100;
            } else if (forcaDaSenha < 0) {
                forcaDaSenha = 0;
            }

            var comp = calcularComplexidade();
            impressora = _dependencias.fabricarImpressora(mapContagem, mapBonus, forcaDaSenha, comp, senha);
            System.out.print(impressora.toString());

        }

        private void calcularForcaDaSenha(int valor) {
            this.forcaDaSenha += valor;
        }

        private String calcularComplexidade(){
            String complexidade;
            if (forcaDaSenha < 20) {
                complexidade = "Very Weak";
            } else if (forcaDaSenha < 40) {
                complexidade = "Weak";
            } else if (forcaDaSenha < 60) {
                complexidade = "Good";
            } else if (forcaDaSenha < 80) {
                complexidade = "Strong";
            } else {
                complexidade = "Very Strong";
            }
            return complexidade;
        }

    }
