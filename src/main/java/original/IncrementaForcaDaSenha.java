package original;


import java.util.Arrays;

public abstract class IncrementaForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    //private String[] requerimentos = new String[8];
    private static int indiceRequerimentos = 0;

    /*

    public IncrementaForcaDaSenha() {
        // super(senha);
    }


    public int obterBonus(){
        return bonus;
    }
    public int obterContagem() {
        return contagem;
    }
    */

    public int obterBonus(){
        return bonus;
    }
    public int obterContagem() {
        return contagem;
    }

    protected void checkRequerimentos(){
        indiceRequerimentos ++;
    }

    protected int obterRequerimentos() {
        if (indiceRequerimentos >= 5)  return 5;
        return indiceRequerimentos;
    }

    public abstract void calculoContagem();
    public abstract void calculoBonus();
}

