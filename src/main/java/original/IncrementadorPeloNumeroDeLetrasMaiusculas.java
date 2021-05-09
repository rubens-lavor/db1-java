package original;

public class IncrementadorPeloNumeroDeLetrasMaiusculas extends IncrementadorForcaDaSenha implements AnalisadorDeCaracteresSequenciais {
    private String[] arrPwd;

    public IncrementadorPeloNumeroDeLetrasMaiusculas(String senha) {
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        peso = 2;

        calcularContagem();
        calcularBonus();
        //testeRepeticao();

        countConsecutiveAlphaUC = calcularConsecutivo(Regex.MAIUSCULA, arrPwd);
        countAlphaUC = contagem;
        if (contagem > 0) checkRequerimentos();
    }


    @Override
    public void calcularContagem() {
        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                contagem++;
            }
        }
    }

    @Override
    public void calcularBonus() {
        bonus = contagem == 0 ? 0 : (senha.length() - contagem) * peso;
    }

}