package br.com.macario.fran.estacionamento.service;

import br.com.macario.fran.estacionamento.model.Estacionamento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
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
        var id1 = getUUID();
        Estacionamento estacionamento = new Estacionamento(id,"DMS-1111", "MA", "Celta", "Vermelho");
        Estacionamento estacionamento1 = new Estacionamento(id1,"Was-1234", "PI", "VW GOL", "preto");
        estacionamentoMap.put(id, estacionamento);
        estacionamentoMap.put(id1, estacionamento1);
    }

    public List<Estacionamento> findAll(){
        return estacionamentoMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public Estacionamento findById(String id) {
        return estacionamentoMap.get(id);
    }

    public Estacionamento create( Estacionamento estacionamentoCreate) {
        String uuid = getUUID();
        estacionamentoCreate.setId(uuid);
        estacionamentoCreate.setDataDeEntrada(LocalDateTime.now());
        estacionamentoMap.put(uuid, estacionamentoCreate);
        return estacionamentoCreate;
    }
}
