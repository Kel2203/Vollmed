package med.voll.api.domain.consultas.validacoes.agendamento;

import med.voll.api.domain.consultas.DadosAgendamentoConsultas;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsultas dados);
}
