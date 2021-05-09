package fabrica_dependencias;

import enums.Bonus;
import enums.Contagem;
import original._Impressora;

import java.util.EnumMap;

public class InstanciadorParaCriacaoDeDependencias {
    public ColecaoDeDependencias fabricarInstanciaDeDependencias(String senha){
        return new CriadorDasDependencias(senha);
    }

    public _Impressora fabricarImpressora(EnumMap<Contagem, Integer> mapContagem, EnumMap<Bonus, Integer> mapBonus, int forca, String comp, String senha){

        _Impressora impressora = new _Impressora(mapContagem,mapBonus, forca, comp, senha );
        return impressora;
    }
}
