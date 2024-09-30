package sgmtec.lab_padroes_projeto_spring.service;

import org.springframework.stereotype.Service;
import sgmtec.lab_padroes_projeto_spring.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import sgmtec.lab_padroes_projeto_spring.model.Endereco;
import sgmtec.lab_padroes_projeto_spring.repository.ClienteRepository;
import sgmtec.lab_padroes_projeto_spring.repository.EnderecoRepository;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Integer id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(
                () -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
