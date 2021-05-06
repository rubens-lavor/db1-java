package original;

public class IncrementadorPeloNumeroDeLetrasMaiusculas extends IncrementadorForcaDaSenha {
    String[] arrPwd;

    public IncrementadorPeloNumeroDeLetrasMaiusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        peso = 2;

        calcularContagem();
        calcularBonus();

        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calcularContagem() {
        // String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = (senha.length() - contagem) * peso;
    }

}