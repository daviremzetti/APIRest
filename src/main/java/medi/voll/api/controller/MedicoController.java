
package medi.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medi.voll.api.model.medico.DadosAtualizacaoMedico;
import medi.voll.api.model.medico.DadosCadastroMedico;
import medi.voll.api.model.medico.DadosListaMedico;
import medi.voll.api.model.medico.Medico;
import medi.voll.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davi_
 */
@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        System.out.println(dados);
    }
    
    
    @GetMapping
    public Page<DadosListaMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        //o requisito do sistema é para retornar somente nome, crm, email e especialidade
        //para nao retornar todos os dados do médico, transitando mais dados e fazer as requisições mais pesadas
        //sem necessidade, o método irá retornar uma record
        //incluído paginação, ou seja, requisitar máximo 20 elementos a cada página que o cliente entrar.
        //esse seria o retorno se nao tivesse paginação e retornasse a lista inteira de medicos return repository.findAll().stream().map(DadosListaMedico::new).toList();
        //para controlar o tamanho da lista a url deve conter a informacao ex: localhost:8080/medicos?size=3
        //para controlar a página o url deve conter ex: localhost:8080/medicos?size=3&page=0
        //para ordenar a pesquisa basca colocar na url sort=atributo. Exemplo: localhost:8080/medicos?sort=name
        //por padrão a ordenação vem ordem crescente, para ordenar decrescente basta por ,desc. Exemplo: localhost:8080/medicos?sort=nome,desc
        //para mudar as configurações defult do pegable, basta usar o @Pageabledefault como utilizado
        return repository.findAll(paginacao).map(DadosListaMedico::new); 
    }
    
    @GetMapping("/ativos")
    public Page<DadosListaMedico> listarAtivos(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListaMedico::new);
    }
    
    @GetMapping("/inativos")
    public Page<DadosListaMedico> listarInativos(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return repository.findAllByAtivoFalse(paginacao).map(DadosListaMedico::new);
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
        //não há necessidade de fazer o repository.save(medico)
        //o @Transactional irá fazer toda a atualização automática no banco de dados
    }
    
    
    /*
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
    esse método exclui de fato do banco de dados
    */
    
    
    @DeleteMapping("/{id}")
    @Transactional
    public DadosListaMedico deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return new DadosListaMedico(medico);
    }
    
    
}
