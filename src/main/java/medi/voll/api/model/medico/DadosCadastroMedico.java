
package medi.voll.api.model.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medi.voll.api.model.model.DadosEndereco;

/**
 *
 * @author davi_
 */
public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //expressão regular para o campo ter de 4 a 6 dígitos, somente números.
        String crm,
        @NotBlank
        @Email
        String email,
        @NotNull //@NotBlank é somente para Strings
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco,
        @Pattern(regexp = "([0-9]{2})[0-9]{5}-[0-9]{4}")
        String telefone) {}
