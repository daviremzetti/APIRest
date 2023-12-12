
package medi.voll.api.model.medico;

import jakarta.validation.constraints.NotNull;
import medi.voll.api.model.model.DadosEndereco;

/**
 *
 * @author davi_
 */
public record DadosAtualizacaoMedico(
        @NotNull
        Long id, 
        String nome, 
        String telefone, 
        DadosEndereco endereco) {}
