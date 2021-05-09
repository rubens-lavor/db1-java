package original;

public class IncrementadorPeloNumeroDeCaracteresEspeciais extends IncrementadorForcaDaSenha implements AnalisadorDeCaracteresSequenciais{
    String[] arrPwd;

    public IncrementadorPeloNumeroDeCaracteresEspeciais(String senha) {
        peso = 6;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        calcularContagem();
        calcularBonus();

        countSymbol = contagem;
        countSeqSymbol = calcularQuantidadeDeCaracteresSequenciais(Sequencia.SIMBOLOS, senha);
        //testeRepeticao();

        if (contagem > 0) checkRequerimentos();
    }

    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                contagem++;
            }

        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}
