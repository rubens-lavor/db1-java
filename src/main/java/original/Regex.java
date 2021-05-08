package original;

public enum Regex {
    MAIUSCULA("[A-Z]"),
    MINUSCULA("[a-z]"),
    NUMERO("[0-9]");

    private String regex;

    Regex(String regex){
        this.regex = regex;
    }

    public String obterRegex(){
        return regex;
    }
}
