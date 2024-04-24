package br.com.macario.fran.estacionamento.controller.mapper;

import br.com.macario.fran.estacionamento.controller.dto.EstacionamentoDTO;
import br.com.macario.fran.estacionamento.model.Estacionamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstacionamentoMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();


    public EstacionamentoDTO estacionamentoDTO(Estacionamento estacionamento){
        return MODEL_MAPPER.map(estacionamento, EstacionamentoDTO.class);
    }
    public List<EstacionamentoDTO> toEstacionamentoList(List<Estacionamento> estacionamentoList) {
    return estacionamentoList.stream().map(this::estacionamentoDTO).collect(Collectors.toList());
    }
}
