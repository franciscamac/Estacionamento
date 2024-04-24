package br.com.macario.fran.estacionamento.service;

import br.com.macario.fran.estacionamento.model.Estacionamento;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstacionamentoService {
    private static Map<String, Estacionamento> estacionamentoMap = new HashMap();

    static {
        var id = getUUID();
        Estacionamento estacionamento = new Estacionamento(id,"DMS-1111", "MA", "Celta", "Vermelho");
        estacionamentoMap.put(id, estacionamento);
    }

    public List<Estacionamento> findAll(){
        return estacionamentoMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
