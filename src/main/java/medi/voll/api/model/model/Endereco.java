
package medi.voll.api.model.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medi.voll.api.model.medico.DadosAtualizacaoMedico;

/**
 *
 * @author davi_
 */

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String complemento;
    
    public Endereco(DadosEndereco dados){
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
        this.complemento = dados.complemento();
    }

    public void atualizarDados(DadosAtualizacaoMedico dados) {
        if(dados.endereco().logradouro() != null){
            this.logradouro = dados.endereco().logradouro();
        }
        if(dados.endereco().bairro() != null){
            this.bairro = dados.endereco().bairro();
        }
        if(dados.endereco().cidade() != null){
            this.cidade = dados.endereco().cidade();
        }
        if(dados.endereco().uf() != null){
            this.uf = dados.endereco().uf();
        }
        if(dados.endereco().cep() != null){
            this.cep = dados.endereco().cep();
        }
        if(dados.endereco().numero() != null){
            this.numero = dados.endereco().numero();
        }
        if(dados.endereco().complemento() != null){
            this.complemento = dados.endereco().complemento();
        }
    }

}
