
package medi.voll.api.model.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davi_
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
    Page<Medico> findAllByAtivoFalse(Pageable paginacao);
    
}
