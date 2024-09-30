package sgmtec.lab_padroes_projeto_spring.service;

import org.springframework.stereotype.Service;
import sgmtec.lab_padroes_projeto_spring.model.Cliente;
@Service
public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Integer id);
    void inserir(Cliente cliente);
    void atualizar(Integer id, Cliente cliente);
    void deletar(Integer id);
}
