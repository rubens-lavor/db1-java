package original;

public class IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha extends AnalisadorDeIndicadoresDaSenha {
    String[] arrPwd;

    public IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha(String senha) {
        peso = 2;
        this.arrPwd = senha.replaceAll("\\s+", "").split("\\s*");
        this.senha = senha;

        calcularContagem();
        calcularBonus();
        contadorNumerosESimbolosNoMeioDaSenha = contagem;
    }

    @Override
    public void calcularContagem() {

        for (int i = 0; i < arrPwd.length; i++) {
         if (arrPwd[i].matches("[0-9]")) {
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
    public void calcularBonus() {
        bonus = contagem * peso;
    }
}