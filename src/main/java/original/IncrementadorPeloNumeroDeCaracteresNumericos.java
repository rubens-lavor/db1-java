package original;

public class IncrementadorPeloNumeroDeCaracteresNumericos extends IncrementadorForcaDaSenha{
    String[] arrPwd;

    IncrementadorPeloNumeroDeCaracteresNumericos(String senha) {
        peso = 4;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();

        if (contagem > 0) {
            checkRequerimentos();
        }
    }
    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}
