
package medi.voll.api.model.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author davi_
 */
public record DadosEndereco (
        @NotBlank
        @Size(max=30)
        String logradouro, 
        String numero,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
        String cep, 
        String complemento) {}
