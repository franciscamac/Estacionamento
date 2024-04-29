package br.com.macario.fran.estacionamento.controller.mapper;

import br.com.macario.fran.estacionamento.controller.dto.EstacionamentoCreateDTO;
import br.com.macario.fran.estacionamento.controller.dto.EstacionamentoDTO;
import br.com.macario.fran.estacionamento.model.Estacionamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstacionamentoMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();


    public EstacionamentoDTO toEstacionamentoDTO(Estacionamento estacionamento){
        return MODEL_MAPPER.map(estacionamento, EstacionamentoDTO.class);
    }
    public List<EstacionamentoDTO> toEstacionamentoList(List<Estacionamento> estacionamentoList) {
    return estacionamentoList.stream().map(this::toEstacionamentoDTO).collect(Collectors.toList());
    }

    public Estacionamento toEstacionamento(EstacionamentoDTO dto) {
        return MODEL_MAPPER.map(dto, Estacionamento.class);
    }

    public Estacionamento toEstacionamentoCreate(EstacionamentoCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Estacionamento.class);
    }
}
