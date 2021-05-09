package enums;

public enum Dependencias {
    ADSPNDC("AnalisadorDeSenhaPeloNumeroDeCaracteres"),
    ADSPNDCE("AnalisadorDeSenhaPeloNumeroDeCaracteresEspeciais"),
    ADSPNDCNENMDS("AnalisadorDeSenhaPeloNumeroDeCaracteresNumericosEEspeciaisNoMeioDaSenha"),
    ADSPNDCSN("AnalisadorDeSenhaPeloNumeroDeCaracteresSequenciaisNumericos"),
    ADSPNDLMa("AnalisadorDeSenhaPeloNumeroDeLetrasMaiusculas"),
    ADSPNDLMi("AnalisadorDeSenhaPeloNumeroDeLetrasMinusculas"),
    ADSPNDR("AnalisadorDeSenhaPeloNumeroDeRequerimentos"),
    IMPRESSORA("Impressora");

    private String dependencias;

    Dependencias(String dependencias){
        this.dependencias = dependencias;
    }

    public String obterDependencias(){
        return dependencias;
    }
}
