package original;

public class VerificadorDeSenha {
    private int forcaDaSenha = 0;
    private final String senha;
    //private String estado;
    //private String sComplexity;


    private final IncrementadorPeloNumeroDeCaracteres incrementadorPeloNumeroDeCaracteres;
    private final IncrementadorPeloNumeroDeLetrasMinusculas incrementadorPeloNumeroDeLetrasMinusculas;
    private final IncrementadorPeloNumeroDeLetrasMaiusculas incrementadorPeloNumeroDeLetrasMaiusculas;
    private final IncrementadorPeloNumeroDeCaracteresNumericos incrementadorPeloNumeroDeCaracteresNumericos;
    private final IncrementadorPeloNumeroDeCaracteresEspeciais incrementadorPeloNumeroDeCaracteresEspeciais;
    private final IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha;
    private final IncrementadorPeloNumeroDeRequerimentos incrementadorPeloNumeroDeRequerimentos;

    Deductions deduction;


    int countSymbol;
    int countNumber;
    int countLength;
    int countAlphaLC;
    int countAlphaUC;
    int countRepChar;
    int countConsecutiveAlphaUC;
    int countConsecutiveAlphaLC;
    int countConsecutiveNumber;
    int countSeqAlpha;
    int countSeqNumber;
    int countSeqSymbol;



    public VerificadorDeSenha(String senha) {
        this.senha = senha;

        incrementadorPeloNumeroDeCaracteres = new IncrementadorPeloNumeroDeCaracteres(senha);
        incrementadorPeloNumeroDeLetrasMaiusculas = new IncrementadorPeloNumeroDeLetrasMaiusculas(senha);
        incrementadorPeloNumeroDeLetrasMinusculas = new IncrementadorPeloNumeroDeLetrasMinusculas(senha);
        incrementadorPeloNumeroDeCaracteresNumericos = new IncrementadorPeloNumeroDeCaracteresNumericos(senha);
        incrementadorPeloNumeroDeCaracteresEspeciais = new IncrementadorPeloNumeroDeCaracteresEspeciais(senha);
        incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha = new IncrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha(senha);
        incrementadorPeloNumeroDeRequerimentos = new IncrementadorPeloNumeroDeRequerimentos();

        deduction = new Deductions();

        checarSenha();
        decremento();

        if (forcaDaSenha > 100) {
            forcaDaSenha = 100;
        } else if (forcaDaSenha < 0) {
            forcaDaSenha = 0;
        }

        Complexidade();

    }

    void checarSenha() {

        setForcaDaSenha(incrementadorPeloNumeroDeCaracteres.bonus);
        setForcaDaSenha(incrementadorPeloNumeroDeLetrasMaiusculas.bonus);
        setForcaDaSenha(incrementadorPeloNumeroDeLetrasMinusculas.bonus);
        setForcaDaSenha(incrementadorPeloNumeroDeCaracteresNumericos.bonus);
        setForcaDaSenha(incrementadorPeloNumeroDeCaracteresEspeciais.bonus);
        setForcaDaSenha(incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.bonus);
        setForcaDaSenha(incrementadorPeloNumeroDeRequerimentos.bonus);

        //forcaDaSenha = 10;
    }

    void decremento(){
        countSymbol = incrementadorPeloNumeroDeCaracteresEspeciais.contagem;
        countNumber = incrementadorPeloNumeroDeCaracteresNumericos.contagem;
        countLength = incrementadorPeloNumeroDeCaracteres.contagem;
        countAlphaLC = incrementadorPeloNumeroDeLetrasMinusculas.contagem;
        countAlphaUC = incrementadorPeloNumeroDeLetrasMaiusculas.contagem;
        countRepChar = incrementadorPeloNumeroDeCaracteres.countRepChar;
        countConsecutiveAlphaUC = incrementadorPeloNumeroDeLetrasMaiusculas.countConsecutiveAlphaUC;
        countConsecutiveAlphaLC = incrementadorPeloNumeroDeLetrasMinusculas.countConsecutiveAlphaLC;
        countConsecutiveNumber = incrementadorPeloNumeroDeCaracteresNumericos.countConsecutiveNumber;
        countSeqAlpha = incrementadorPeloNumeroDeLetrasMinusculas.countSeqAlpha;
        countSeqNumber = incrementadorPeloNumeroDeCaracteresNumericos.countSeqNumber;
        countSeqSymbol = incrementadorPeloNumeroDeCaracteresEspeciais.countSeqSymbol;



        if ( countSymbol == 0 && countNumber == 0) {
            setForcaDaSenha(-countLength);
            deduction.contagemSomenteLetras = countLength;
            deduction.bonusSomenteLetras = countLength;
        }

        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {
            setForcaDaSenha(-countLength);
            deduction.contagemSomenteNumeros = countLength;
            deduction.bonusSomenteNumeros = countLength;
        }

        if (countRepChar > 0) {  // Same character exists more than once
            setForcaDaSenha( - (int) IncrementadorForcaDaSenha.incrementDeductionOfRepeatedChars);
            deduction.bonusRepChar = (int) IncrementadorForcaDaSenha.incrementDeductionOfRepeatedChars;
        }
        if (countConsecutiveAlphaUC > 0) {  // Consecutive Uppercase Letters exist
            int multiplierConsecutiveAlphaUC = 2;
            setForcaDaSenha(- countConsecutiveAlphaUC * multiplierConsecutiveAlphaUC);
            deduction.bonusConsecutiveAlphaUC = countConsecutiveAlphaUC * multiplierConsecutiveAlphaUC;
        }
        if (countConsecutiveAlphaLC > 0) {  // Consecutive Lowercase Letters exist
            int multiplierConsecutiveAlphaLC = 2;
            setForcaDaSenha(- countConsecutiveAlphaLC * multiplierConsecutiveAlphaLC);
            deduction.bonusConsecutiveAlphaLC = countConsecutiveAlphaLC * multiplierConsecutiveAlphaLC;
        }
        if (countConsecutiveNumber > 0) {  // Consecutive Numbers exist
            int multiplierConsecutiveNumber = 2;
            setForcaDaSenha(- countConsecutiveNumber * multiplierConsecutiveNumber);
            deduction.bonusConsecutiveNumber = countConsecutiveNumber * multiplierConsecutiveNumber;
        }
        if (countSeqAlpha > 0) {  // Sequential alpha strings exist (3 characters or more)
            int multiplierSeqAlpha = 3;
            setForcaDaSenha(- countSeqAlpha * multiplierSeqAlpha);
            deduction.bonusSeqAlpha = countSeqAlpha * multiplierSeqAlpha;
        }
        if (countSeqNumber > 0) {  // Sequential numeric strings exist (3 characters or more)
            int multiplierSeqNumber = 3;
            setForcaDaSenha(- countSeqNumber * multiplierSeqNumber);
            deduction.bonusSeqNumber = countSeqNumber * multiplierSeqNumber;
        }
        if (countSeqSymbol > 0) {  // Sequential symbol strings exist (3 characters or more)
            int multiplierSeqSymbol = 3;
            setForcaDaSenha(- countSeqSymbol * multiplierSeqSymbol);
            deduction.bonusSeqSymbol = countSeqSymbol * multiplierSeqSymbol;
        }

    }

    public void setForcaDaSenha(int value) {
        this.forcaDaSenha += value;
    }

    String Complexidade(){
        String sComplexity;
        if (forcaDaSenha < 20) {
            sComplexity = "Very Weak";
        } else if (forcaDaSenha < 40) {
            sComplexity = "Weak";
        } else if (forcaDaSenha < 60) {
            sComplexity = "Good";
        } else if (forcaDaSenha < 80) {
            sComplexity = "Strong";
        } else {
            sComplexity = "Very Strong";
        }
        return sComplexity;
    }


    @Override
    public String toString() {
        return "Password: " + senha
                + "\nScore: " + forcaDaSenha
                + "\nComplexity: " + Complexidade()

                + "\nAddictions"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteres.contagem + " | B: " + incrementadorPeloNumeroDeCaracteres.bonus + "] Number of Characters"
                + "\n[C: " + incrementadorPeloNumeroDeLetrasMaiusculas.contagem + " | B: " + incrementadorPeloNumeroDeLetrasMaiusculas.bonus + "] Uppercase Letters"
                + "\n[C: " + incrementadorPeloNumeroDeLetrasMinusculas.contagem + " | B: " + incrementadorPeloNumeroDeLetrasMinusculas.bonus + "] Lowercase Letters"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteresNumericos.contagem + " | B: " + incrementadorPeloNumeroDeCaracteresNumericos.bonus + "] Numbers"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteresEspeciais.contagem + " | B: " + incrementadorPeloNumeroDeCaracteresEspeciais.bonus + "] Symbols"
                + "\n[C: " + incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.contagem + " | B: " + incrementadorPeloNumeroDeCaracteresEspeciaisENumericosNoMeioDaSenha.bonus + "] Middle Numbers or Symbols"
                + "\n[C: " + incrementadorPeloNumeroDeRequerimentos.contagem + " | B: " + incrementadorPeloNumeroDeRequerimentos.bonus + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + deduction.contagemSomenteLetras + " | B: " + deduction.bonusSomenteLetras + "] Letters Only"
                + "\n[C: " + deduction.contagemSomenteNumeros + " | B: " + deduction.bonusSomenteNumeros + "] Numbers Only"

                + "\n[C: " + countRepChar + " | B: " + deduction.bonusRepChar + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + countConsecutiveAlphaUC + " | B: " + deduction.bonusConsecutiveAlphaUC + "] Consecutive Uppercase Letters"
                + "\n[C: " + countConsecutiveAlphaLC + " | B: " + deduction.bonusConsecutiveAlphaLC + "] Consecutive Lowercase Letters"
                + "\n[C: " + countConsecutiveNumber + " | B: " + deduction.bonusConsecutiveNumber + "] Consecutive Numbers"
                + "\n[C: " + countSeqAlpha + " | B: " + deduction.bonusSeqAlpha + "] Sequential Letters"
                + "\n[C: " + countSeqNumber + " | B: " + deduction.bonusSeqNumber + "] Sequential Numbers"
                + "\n[C: " + countSeqSymbol + " | B: " + deduction.bonusSeqSymbol + "] Sequential Symbols"

                ;
    }
}


