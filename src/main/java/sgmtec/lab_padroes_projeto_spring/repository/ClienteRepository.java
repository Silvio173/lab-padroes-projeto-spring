package sgmtec.lab_padroes_projeto_spring.repository;

import sgmtec.lab_padroes_projeto_spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
