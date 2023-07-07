package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "Este campo é obrigatório")
        String logradouro,
        @NotBlank(message = "Este campo é obrigatório")
        String bairro,
        @NotBlank(message = "Este campo é obrigatório")
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank(message = "Este campo é obrigatório")
        String cidade,
        @NotBlank(message = "Este campo é obrigatório")
        String uf,
        String complemento,
        String numero) {
}
