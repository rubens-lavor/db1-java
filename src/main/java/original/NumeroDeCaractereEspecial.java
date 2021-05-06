package original;

public class NumeroDeCaractereEspecial extends IncrementaForcaDaSenha {
    String[] arrPwd;
    public NumeroDeCaractereEspecial(String senha) {
        peso = 6;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        calculoContagem();
        calculoBonus();

        if (contagem > 0) checkRequerimentos();
    }

    @Override
    public void calculoContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
            } else if (arrPwd[i].matches("[a-z]")) {
            } else if (arrPwd[i].matches("[0-9]")) { }
            else if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                contagem++;
            }

        }
    }

    @Override
    public void calculoBonus() {
        bonus = contagem * peso;
    }
}
