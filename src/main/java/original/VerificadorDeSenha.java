package original;

public class VerificadorDeSenha {
    private int forcaDaSenha = 0;
    private final String senha;
    //private String estado;


    private final IncrementadorPeloNumeroDeCaracteres incrementadorPeloNumeroDeCaracteres;
    private final IncrementadorPeloNumeroDeLetrasMinusculas incrementadorPeloNumeroDeLetrasMinusculas;
    private final IncrementadorPeloNumeroDeLetrasMaiusculas incrementadorPeloNumeroDeLetrasMaiusculas;
    private final IncrementadorPeloNumeroDeCaracteresNumericos incrementadorPeloNumeroDeCaracteresNumericos;
    private final IncrementadorPeloNumeroDeCaracteresEspeciais incrementadorPeloNumeroDeCaracteresEspeciais;
    private final IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha;
    private final IncrementadorPeloNumeroDeRequerimentos incrementadorPeloNumeroDeRequerimentos;

    public VerificadorDeSenha(String senha) {
        this.senha = senha;

        incrementadorPeloNumeroDeCaracteres = new IncrementadorPeloNumeroDeCaracteres(senha);
        incrementadorPeloNumeroDeLetrasMaiusculas = new IncrementadorPeloNumeroDeLetrasMaiusculas(senha);
        incrementadorPeloNumeroDeLetrasMinusculas = new IncrementadorPeloNumeroDeLetrasMinusculas(senha);
        incrementadorPeloNumeroDeCaracteresNumericos = new IncrementadorPeloNumeroDeCaracteresNumericos(senha);
        incrementadorPeloNumeroDeCaracteresEspeciais = new IncrementadorPeloNumeroDeCaracteresEspeciais(senha);
        incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha = new IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha(senha);
        incrementadorPeloNumeroDeRequerimentos = new IncrementadorPeloNumeroDeRequerimentos();

    }

    void checarSenha() {

        if (incrementadorPeloNumeroDeCaracteres.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeCaracteres.contagem);
        if (incrementadorPeloNumeroDeLetrasMaiusculas.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeLetrasMaiusculas.contagem);
        if (incrementadorPeloNumeroDeLetrasMinusculas.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeLetrasMinusculas.contagem);
        if (incrementadorPeloNumeroDeCaracteresNumericos.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeCaracteresNumericos.contagem);
        if (incrementadorPeloNumeroDeCaracteresEspeciais.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeCaracteresEspeciais.contagem);
        if (incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.contagem);
        if (incrementadorPeloNumeroDeRequerimentos.contagem != 0) setForcaDaSenha(incrementadorPeloNumeroDeRequerimentos.contagem);

        //forcaDaSenha = 10;
    }

    public void setForcaDaSenha(int value) {
        this.forcaDaSenha += value;
    }

    String obterComplexidade(){
        return "facil";
    }


    @Override
    public String toString() {
        return "Password: " + senha
                + "\nScore: " + forcaDaSenha
                + "\nComplexity: " + obterComplexidade()

                + "\nAddictions"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteres.contagem + " | B: " + incrementadorPeloNumeroDeCaracteres.bonus + "] Number of Characters"
                + "\n[C: " + incrementadorPeloNumeroDeLetrasMaiusculas.contagem + " | B: " + incrementadorPeloNumeroDeLetrasMaiusculas.bonus + "] Uppercase Letters"
                + "\n[C: " + incrementadorPeloNumeroDeLetrasMinusculas.contagem + " | B: " + incrementadorPeloNumeroDeLetrasMinusculas.bonus + "] Lowercase Letters"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteresNumericos.contagem + " | B: " + incrementadorPeloNumeroDeCaracteresNumericos.bonus + "] Numbers"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteresEspeciais.contagem + " | B: " + incrementadorPeloNumeroDeCaracteresEspeciais.bonus + "] Symbols"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.contagem + " | B: " + incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.bonus + "] Middle Numbers or Symbols"
                + "\n[C: " + incrementadorPeloNumeroDeRequerimentos.contagem + " | B: " + incrementadorPeloNumeroDeRequerimentos.bonus + "] Requirements";
    }
}


