package med.voll.api.domain.consultas;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultasRepository consultasRepository;

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsultas dados){
            if (!pacienteRepository.existsById(dados.idPaciente())) {
                throw new ValidacaoException("Id do paciente informado não existe!");
            }
            if (!medicoRepository.existsById(dados.idMedico())) {
                throw new ValidacaoException("Id do médico informado não existe!");
            }
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultasRepository.save(consulta);
        }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultasRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        var consulta = consultasRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
    private Medico escolherMedico(DadosAgendamentoConsultas dados){
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}
