package original;

import enums.Bonus;
import enums.Contagem;
import interfaces.ColecaoDeDependencias;

import java.util.EnumMap;

public class InstanciadorParaCriacaoDeDependencias {
    public ColecaoDeDependencias fabricarInstanciaDeDependencias(String senha){
        return new CriadorDasDependencias(senha);
    }

    public Impressora fabricarImpressora(EnumMap<Contagem, Integer> mapContagem, EnumMap<Bonus, Integer> mapBonus, int forca, String comp, String senha){
        Impressora impressora = new Impressora(mapContagem,mapBonus, forca, comp, senha );
        return impressora;
    }
}
