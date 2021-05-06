package original;

public class NumeroDeCaractereNumerico extends IncrementaForcaDaSenha{
    String[] arrPwd;

    NumeroDeCaractereNumerico (String senha) {
        peso = 4;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calculoContagem();
        calculoBonus();

        if (contagem > 0) {
            checkRequerimentos();
        }
    }
    @Override
    public void calculoContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calculoBonus() {
        bonus = contagem * peso;
    }
}
