package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "Este campo é obrigatório")
        String nome,
        @NotBlank(message = "Este campo é obrigatório")
        @Email
        String email,
        @NotBlank(message = "Este campo é obrigatório")
        String telefone,
        @NotBlank(message = "Este campo é obrigatório")
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull(message = "Este campo é obrigatório")
        Especialidade especialidade,
        @NotNull(message = "Este campo é obrigatório") @Valid
        DadosEndereco endereco) {
}
