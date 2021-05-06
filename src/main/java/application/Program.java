package application;

import original.VerificadorDeSenha;

public class Program {
    public static void main(String[] args) {

        VerificadorDeSenha senha1;
        senha1 = new VerificadorDeSenha("rubens123AçÇj");

        System.out.print(senha1.toString());
    }
}
