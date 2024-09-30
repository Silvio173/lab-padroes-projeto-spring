package sgmtec.lab_padroes_projeto_spring.repository;

import org.springframework.stereotype.Repository;
import sgmtec.lab_padroes_projeto_spring.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,String> {
}
