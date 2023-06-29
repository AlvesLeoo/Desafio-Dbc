package desafio.dbc.controller;


import desafio.dbc.dto.request.VotoRequest;
import desafio.dbc.dto.response.VotoResponse;
import desafio.dbc.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    VotoService votoService;

    @PostMapping(path = "/votar")
    public ResponseEntity<Object> votar(@RequestBody VotoRequest votoRequest) {

        VotoResponse votoResponse = votoService.votar(votoRequest);
        return new ResponseEntity<>(votoResponse, HttpStatus.CREATED);
    }
}
