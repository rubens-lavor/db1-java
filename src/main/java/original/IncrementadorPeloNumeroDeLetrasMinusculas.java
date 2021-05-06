package original;

public class IncrementadorPeloNumeroDeLetrasMinusculas extends IncrementadorForcaDaSenha {
    String[] arrPwd;

    public IncrementadorPeloNumeroDeLetrasMinusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;
        peso = 2;

        calcularContagem();
        calcularBonus();

        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = (senha.length() - contagem) * peso;
    }
}