package original;

public class NumeroDeLetraMinuscula extends IncrementaForcaDaSenha {
    String[] arrPwd;

    public NumeroDeLetraMinuscula(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        peso = 2;

        calculoContagem();
        calculoBonus();

        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calculoContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calculoBonus() {
        bonus = (senha.length() - contagem) * peso;
    }
}
