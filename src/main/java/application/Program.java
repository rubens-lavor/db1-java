package application;

import original.InstanciadorParaCriacaoDeDependencias;
import original.*;


public class Program {

    public static void main(String[] args) {

        //var teste = new MyCreatorFactore();

        var teste2 = new InstanciadorParaCriacaoDeDependencias();

        VerificadorDeSenha senha1;
        senha1 = new VerificadorDeSenha("123ab24abc4", teste2);

    }
}
