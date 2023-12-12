
package medi.voll.api.model.medico;

/**
 *
 * @author davi_
 */
public record DadosListaMedico(Long id, String nome, String crm, String telefone, Especialidade especialidade, boolean ativo) {
    
    public DadosListaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.isAtivo());
    }
}
