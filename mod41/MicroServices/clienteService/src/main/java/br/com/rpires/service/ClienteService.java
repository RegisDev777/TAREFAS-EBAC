package br.com.rpires.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rpires.repository.ClienteRepository;
import br.com.rpires.client.ProdutoClient;
import br.com.rpires.client.ProdutoResponse;
import br.com.rpires.domain.Cliente;
import br.com.rpires.dto.ClienteRequestDTO;
import br.com.rpires.exception.ClienteNaoEncontradoException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;   
    private final ProdutoClient produtoClient;

    public ClienteService(ClienteRepository clienteRepository, ProdutoClient produtoClient) {
        this.clienteRepository = clienteRepository;
        this.produtoClient = produtoClient;
        
    }

    public Cliente cadastraCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setAtivo(true);

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizar(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(ClienteNaoEncontradoException::new);

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());

        return clienteRepository.save(cliente);
    }

    public void excluir(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(ClienteNaoEncontradoException::new);

        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }
    
    public void testarProduto(Long produtoId) {
        ProdutoResponse produto = produtoClient.buscarPorId(produtoId);
        System.out.println("Produto recebido: " + produto.getNome());
    }
}
