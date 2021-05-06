package original;

public class VerificadorDeSenha {
    private int forcaDaSenha = 0;
    private final String senha;
    //private String estado;


    private final NumeroDeCaractere numeroDeCaractere;
    private final NumeroDeLetraMinuscula numeroDeLetraMinuscula;
    private final NumeroDeLetraMaiuscula numeroDeLetraMaiuscula;
    private final NumeroDeCaractereNumerico numeroDeCaractereNumerico;
    private final NumeroDeCaractereEspecial numeroDeCaractereEspecial;
    private final NumeroOuSimboloNoMeio numeroOuSimboloNoMeio;
    private final NumeroDeRequerimentos numeroDeRequerimentos;

    public VerificadorDeSenha(String senha) {
        this.senha = senha;

        numeroDeCaractere = new NumeroDeCaractere(senha);
        numeroDeLetraMaiuscula = new NumeroDeLetraMaiuscula(senha);
        numeroDeLetraMinuscula = new NumeroDeLetraMinuscula(senha);
        numeroDeCaractereNumerico = new NumeroDeCaractereNumerico(senha);
        numeroDeCaractereEspecial = new NumeroDeCaractereEspecial(senha);
        numeroOuSimboloNoMeio = new NumeroOuSimboloNoMeio(senha);
        numeroDeRequerimentos = new NumeroDeRequerimentos();

    }

    void checarSenha() {

        if (numeroDeCaractere.contagem != 0) setForcaDaSenha(numeroDeCaractere.contagem);
        if (numeroDeLetraMaiuscula.contagem != 0) setForcaDaSenha(numeroDeLetraMaiuscula.contagem);
        if (numeroDeLetraMinuscula.contagem != 0) setForcaDaSenha(numeroDeLetraMinuscula.contagem);
        if (numeroDeCaractereNumerico.contagem != 0) setForcaDaSenha(numeroDeCaractereNumerico.contagem);
        if (numeroDeCaractereEspecial.contagem != 0) setForcaDaSenha(numeroDeCaractereEspecial.contagem);
        if (numeroOuSimboloNoMeio.contagem != 0) setForcaDaSenha(numeroOuSimboloNoMeio.contagem);
        if (numeroDeRequerimentos.contagem != 0) setForcaDaSenha(numeroDeRequerimentos.contagem);

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
                + "\n[C: " + numeroDeCaractere.contagem + " | B: " + numeroDeCaractere.bonus + "] Number of Characters"
                + "\n[C: " + numeroDeLetraMaiuscula.contagem + " | B: " + numeroDeLetraMaiuscula.bonus + "] Uppercase Letters"
                + "\n[C: " + numeroDeLetraMinuscula.contagem + " | B: " + numeroDeLetraMinuscula.bonus + "] Lowercase Letters"
                + "\n[C: " + numeroDeCaractereNumerico.contagem + " | B: " + numeroDeCaractereNumerico.bonus + "] Numbers"
                + "\n[C: " + numeroDeCaractereEspecial.contagem + " | B: " + numeroDeCaractereEspecial.bonus + "] Symbols"
                + "\n[C: " + numeroOuSimboloNoMeio.contagem + " | B: " + numeroOuSimboloNoMeio.bonus + "] Middle Numbers or Symbols"
                + "\n[C: " + numeroDeRequerimentos.contagem + " | B: " + numeroDeRequerimentos.bonus + "] Requirements";
    }
}


