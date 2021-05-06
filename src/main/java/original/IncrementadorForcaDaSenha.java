package original;

public abstract class IncrementadorForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;
    protected String senha = "";

    private static int indiceRequerimentos = 0;


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

    public abstract void calcularContagem();
    public abstract void calcularBonus();
}

