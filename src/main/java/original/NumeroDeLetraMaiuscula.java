package original;

public class NumeroDeLetraMaiuscula extends IncrementaForcaDaSenha {
    String[] arrPwd;

    public NumeroDeLetraMaiuscula(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        peso = 2;

        calculoContagem();
        calculoBonus();

        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calculoContagem() {
        // String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calculoBonus() {
        bonus = (senha.length() - contagem) * peso;
    }

    /*
    public int obterContagem(int x) {
        return x;
    }
     */
}