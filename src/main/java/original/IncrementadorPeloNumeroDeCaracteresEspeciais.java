package original;

public class IncrementadorPeloNumeroDeCaracteresEspeciais extends IncrementadorForcaDaSenha implements AnalisadorDeCaracteresSequenciais{
    String[] arrPwd;

    int countSeqSymbol = 0;

    public IncrementadorPeloNumeroDeCaracteresEspeciais(String senha) {
        peso = 6;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        calcularContagem();
        calcularBonus();

        countSeqSymbol = calcularQuantidadeDeCaracteresSequenciais(Sequencia.SIMBOLOS, senha);

        if (contagem > 0) checkRequerimentos();
    }

    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            /*
            if (arrPwd[i].matches("[A-Z]")) {
            } else if (arrPwd[i].matches("[a-z]")) {
            } else if (arrPwd[i].matches("[0-9]")) { }

            else*/ if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                contagem++;
            }

        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}
