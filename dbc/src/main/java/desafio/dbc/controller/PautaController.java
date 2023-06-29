package desafio.dbc.controller;

import desafio.dbc.dto.request.AbrirVotacaoRequest;
import desafio.dbc.dto.request.CriarPautaRequest;
import desafio.dbc.dto.response.PautaResponse;
import desafio.dbc.dto.response.ResultadoResponse;
import desafio.dbc.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    PautaService pautaService;

    @PostMapping(path = "/criar")
    public ResponseEntity<Object> criarPauta(@RequestBody CriarPautaRequest criarPautaRequest) {
        PautaResponse pautaResponse = pautaService.criarPauta(criarPautaRequest);
        return new ResponseEntity<>(pautaResponse, HttpStatus.CREATED);
    }

    @PutMapping(path = "/abrir")
    public ResponseEntity<Object> abrirVotacao(@RequestBody AbrirVotacaoRequest abrirVotacaoRequest) {
        PautaResponse pautaResponse = pautaService.abrirVotacao(abrirVotacaoRequest);
        return new ResponseEntity<>(pautaResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "/resultado/{id}")
    public ResponseEntity<Object> obterResultado(@PathVariable Long id) {
        ResultadoResponse resultadoResponse = pautaService.obterResultado(id);
        return new ResponseEntity<>(resultadoResponse, HttpStatus.OK);
    }
}
