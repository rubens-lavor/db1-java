package application;

import original.*;


public class Program {

    public static void main(String[] args) {

        //var teste = new MyCreatorFactore();

        var teste2 = new InstanciadorParaCriacaoDeDependencias();

        _VerificadorDeSenha senha1;
        senha1 = new _VerificadorDeSenha("123ab24abc4", teste2);

    }
}
