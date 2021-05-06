package original;

public abstract class DecrementaForcaDaSenha {
    protected int peso = 0;
    protected int contagem;
    protected int bonus;

    public int obterBonus(){
        return bonus;
    }
    public int obterContagem() {
        return contagem;
    }

    public abstract void calculoContagem(String senha);
    public abstract void calculoBonus(String senha);
}

