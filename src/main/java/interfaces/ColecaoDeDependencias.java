package interfaces;

import enums.Bonus;
import enums.Contagem;
import enums.Dependencias;
import original.AnalisadorDeIndicadoresDaSenha;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public interface ColecaoDeDependencias {

        EnumMap<Dependencias, Object> mapDependencias = new EnumMap<>(Dependencias.class);
        EnumMap<Contagem, Integer> mapContagem = new EnumMap<>(Contagem.class);
        EnumMap<Bonus, Integer> mapBonus = new EnumMap<>(Bonus.class);

        default EnumMap<Dependencias, Object> retornarMap(){
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

