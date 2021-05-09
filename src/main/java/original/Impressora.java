package original;

import enums.Bonus;
import enums.Contagem;

import java.util.EnumMap;

public class Impressora {

    EnumMap<Contagem, Integer> mapContagem;
    EnumMap<Bonus, Integer> mapBonus;
    String senha;
    int forcaDaSenha;
    String Complexidade;

    public Impressora(EnumMap<Contagem, Integer> mapContagem, EnumMap<Bonus, Integer> mapBonus, int forcaDaSenha, String Complexidade, String senha){
        this.mapContagem = mapContagem;
        this.mapBonus = mapBonus;
        this.forcaDaSenha = forcaDaSenha;
        this.Complexidade = Complexidade;
        this.senha = senha;

    }




    @Override
    public String toString() {
        return "Password: " + senha
                + "\nScore: " + forcaDaSenha
                + "\nComplexity: " + Complexidade

                + "\nAddictions"
                + "\n[C: " + mapContagem.get(Contagem.TAM_SENHA) + " | B: " + mapBonus.get(Bonus.TAM_SENHA) + "] Number of Characters"

                + "\n[C: " + mapContagem.get(Contagem.QNT_LETRA_MAIUSC) + " | B: " + mapBonus.get(Bonus.QNT_LETRA_MAIUSC) + "] Uppercase Letters"
                + "\n[C: " + mapContagem.get(Contagem.QNT_LETRA_MINUSC) + " | B: " + mapBonus.get(Bonus.QNT_LETRA_MINUSC) + "] Lowercase Letters"
                + "\n[C: " + mapContagem.get(Contagem.QNT_NUMERO) + " | B: " + mapBonus.get(Bonus.QNT_NUMERO) + "] Numbers"
                + "\n[C: " + mapContagem.get(Contagem.QNT_SIMBOLO) + " | B: " + mapBonus.get(Bonus.QNT_SIMBOLO) + "] Symbols"
                + "\n[C: " + mapContagem.get(Contagem.QNT_NUMERO_OU_SIMBOLO_NO_MEIO) + " | B: " + mapBonus.get(Bonus.QNT_NUMERO_OU_SIMBOLO_NO_MEIO) + "] Middle Numbers or Symbols"
                + "\n[C: " + mapContagem.get(Contagem.QNT_REQUERIMENTOS) + " | B: " + mapBonus.get(Bonus.QNT_REQUERIMENTOS) + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + mapContagem.get(Contagem.APENAS_LETRAS) + " | B: " + mapBonus.get(Bonus.APENAS_LETRAS) + "] Letters Only"
                + "\n[C: " + mapContagem.get(Contagem.APENAS_NUMEROS) + " | B: " + mapBonus.get(Bonus.APENAS_NUMEROS) + "] Numbers Only"

                + "\n[C: " + mapContagem.get(Contagem.QNT_CARACTER_REPETIDO) + " | B: " + mapBonus.get(Bonus.QNT_CARACTER_REPETIDO) + "] Repeat Characters (Case Insensitive)"

                + "\n[C: " + mapContagem.get(Contagem.QNT_LETRA_MAIUSC_CONSECUTIVO) + " | B: " + mapBonus.get(Bonus.QNT_LETRA_MAIUSC_CONSECUTIVO) + "] Consecutive Uppercase Letters"
                + "\n[C: " + mapContagem.get(Contagem.QNT_LETRA_MINUSC_CONSECUTIVO) + " | B: " + mapBonus.get(Bonus.QNT_LETRA_MINUSC_CONSECUTIVO) + "] Consecutive Lowercase Letters"
                + "\n[C: " + mapContagem.get(Contagem.QNT_NUMERO_CONSECUTIVO) + " | B: " + mapBonus.get(Bonus.QNT_NUMERO_CONSECUTIVO) + "] Consecutive Numbers"

                + "\n[C: " + mapContagem.get(Contagem.QNT_SEQUENCIA_LETRA) + " | B: " + mapBonus.get(Bonus.QNT_SEQUENCIA_LETRA) + "] Sequential Letters"
                + "\n[C: " + mapContagem.get(Contagem.QNT_SEQUENCIA_NUMERO) + " | B: " + mapBonus.get(Bonus.QNT_SEQUENCIA_NUMERO) + "] Sequential Numbers"
                + "\n[C: " + mapContagem.get(Contagem.QNT_SEQUENCIA_SIMBOLO) + " | B: " + mapBonus.get(Bonus.QNT_SEQUENCIA_SIMBOLO) + "] Sequential Symbols"
                ;
    }
}
