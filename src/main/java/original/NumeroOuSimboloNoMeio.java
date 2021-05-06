package original;

public class NumeroOuSimboloNoMeio extends IncrementaForcaDaSenha {
    String[] arrPwd;

    public NumeroOuSimboloNoMeio(String senha) {
        peso = 2;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calculoContagem();
        calculoBonus();

    }

    @Override
    public void calculoContagem() {


        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) { }
            else if (arrPwd[i].matches("[a-z]")) { }

            else if (arrPwd[i].matches("[0-9]")) {
                if (i > 0 && i < arrPwd.length - 1) {
                    contagem++;
                }
            } else if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                if (i > 0 && i < arrPwd.length - 1) {
                    contagem++;
                }
            }
        }
    }

    @Override
    public void calculoBonus() {
        bonus = contagem * peso;
    }
}
