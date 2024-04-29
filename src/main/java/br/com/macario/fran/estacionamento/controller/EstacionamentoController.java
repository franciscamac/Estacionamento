package br.com.macario.fran.estacionamento.controller;

import br.com.macario.fran.estacionamento.controller.dto.EstacionamentoCreateDTO;
import br.com.macario.fran.estacionamento.controller.dto.EstacionamentoDTO;
import br.com.macario.fran.estacionamento.controller.mapper.EstacionamentoMapper;
import br.com.macario.fran.estacionamento.model.Estacionamento;
import br.com.macario.fran.estacionamento.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<EstacionamentoDTO>> findAll(){
        List<Estacionamento> estacionamentoList = estacionamentoService.findAll();
        List<EstacionamentoDTO> result = estacionamentoMapper.toEstacionamentoList(estacionamentoList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionamentoDTO> findById(@PathVariable String id){
        Estacionamento estacionamento = estacionamentoService.findById(id);
        EstacionamentoDTO result = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<EstacionamentoDTO> create(@RequestBody EstacionamentoCreateDTO dto){
        var estacionamentoCreate = estacionamentoMapper.toEstacionamentoCreate(dto);
        var estacionamento = estacionamentoService.create(estacionamentoCreate);
        var result = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
