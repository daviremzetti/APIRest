
package medi.voll.api.model.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import medi.voll.api.model.model.Endereco;

/**
 *
 * @author davi_
 */
@Entity
@Table(name="medicos")
@Data
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;
    private String email;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private boolean ativo;
    
    public Medico(DadosCadastroMedico dados){
        this.id = null;
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.ativo = true;
    }
    
    public Medico(){
        
    }

    public void atualizarDados(DadosAtualizacaoMedico dados) {
        if(dados.endereco() != null){
            this.endereco.atualizarDados(dados);
        }
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }
    
    public void excluir(){
        this.ativo = false;
    }
}
