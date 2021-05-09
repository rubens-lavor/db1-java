package original;

import enums.Bonus;
import enums.Contagem;
import original.AnalisadorDeIndicadoresDaSenha;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public interface ColecaoDeDependencias {

        Map<String, Object> mapDependencias = new HashMap<>();
        EnumMap<Contagem, Integer> mapContagem = new EnumMap<>(Contagem.class);
        EnumMap<Bonus, Integer> mapBonus = new EnumMap<>(Bonus.class);

        default Map<String, Object> retornarMap(){
            return mapDependencias;
        }
        default EnumMap<Contagem, Integer> retornarMapContagem(){
            return mapContagem;
        }
        default EnumMap<Bonus, Integer> retornarMapBonus(){ return mapBonus; }

        int calcularSomatorioDeBonus();
        AnalisadorDeIndicadoresDaSenha retornarUmaDependencia(String get);
        void atribuirValoresMapContagemEBonus();
}

