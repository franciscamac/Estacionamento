package br.com.macario.fran.estacionamento.controller;

import br.com.macario.fran.estacionamento.controller.dto.EstacionamentoDTO;
import br.com.macario.fran.estacionamento.controller.mapper.EstacionamentoMapper;
import br.com.macario.fran.estacionamento.model.Estacionamento;
import br.com.macario.fran.estacionamento.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("/estacionamento")
public class EstacionamentoController {


    private final EstacionamentoService estacionamentoService;
    private final EstacionamentoMapper estacionamentoMapper;
    public EstacionamentoController(EstacionamentoService estacionamentoService, EstacionamentoMapper estacionamentoMapper) {
        this.estacionamentoService = estacionamentoService;
        this.estacionamentoMapper = estacionamentoMapper;
    }

    @GetMapping
    public List<EstacionamentoDTO> findAll(){
        List<Estacionamento> estacionamentoList = estacionamentoService.findAll();
        List<EstacionamentoDTO> result = estacionamentoMapper.toEstacionamentoList(estacionamentoList);
        return result;
    }
}
