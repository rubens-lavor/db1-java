package original;

import java.util.EnumMap;

public class InstanciadorParaCriacaoDeDependencias {
    ColecaoDeDependencias fabricarInstanciaDeDependencias(String senha){
        return new CriadorDasDependencias(senha);
    }

    _Impressora fabricarImpressora(EnumMap<Contagem, Integer> mapContagem, EnumMap<Bonus, Integer> mapBonus, int forca, String comp, String senha){

        _Impressora impressora = new _Impressora(mapContagem,mapBonus, forca, comp, senha );
        return impressora;
    }
}
