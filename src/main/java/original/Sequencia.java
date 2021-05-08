package original;

public enum Sequencia {
    LETRAS("abcdefghijklmnopqrstuvwxyz"),
    NUMEROS("01234567890"),
    SIMBOLOS(")!@#$%^&*()");

    private String sequencia;

    Sequencia(String sequencia){
        this.sequencia = sequencia;
    }

    public String obterSequencia(){
        return sequencia;
    }
}
