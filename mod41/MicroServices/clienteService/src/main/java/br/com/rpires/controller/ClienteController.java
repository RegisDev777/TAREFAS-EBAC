package br.com.rpires.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.rpires.domain.Cliente;
import br.com.rpires.dto.ClienteRequestDTO;
import br.com.rpires.dto.ClienteResponseDTO;
import br.com.rpires.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    private ClienteResponseDTO toResponseDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setAtivo(cliente.getAtivo());
        return dto;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteRequestDTO dto) {
        Cliente cliente = clienteService.cadastraCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        List<ClienteResponseDTO> lista = clienteService.listarClientes()
                .stream()
                .map(this::toResponseDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ClienteRequestDTO dto
    ) {
        Cliente cliente = clienteService.atualizar(id, dto);
        return ResponseEntity.ok(toResponseDTO(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/testar-produto/{produtoId}")
    public ResponseEntity<String> testarProduto(@PathVariable Long produtoId) {
        clienteService.testarProduto(produtoId);
        return ResponseEntity.ok("Produto encontrado com sucesso");
    }
}
