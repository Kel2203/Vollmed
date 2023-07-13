package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consultas.AgendaDeConsultas;
import med.voll.api.domain.consultas.DadosAgendamentoConsultas;
import med.voll.api.domain.consultas.DadosCancelamentoConsulta;
import med.voll.api.domain.consultas.DadosDetalhamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultas dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsultas(null, null,null,null));
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
