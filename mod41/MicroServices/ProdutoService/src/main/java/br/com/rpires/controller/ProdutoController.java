package br.com.rpires.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.rpires.domain.Produto;
import br.com.rpires.dto.ProdutoRequestDTO;
import br.com.rpires.dto.ProdutoResponseDTO;
import br.com.rpires.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
  

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

  
    private ProdutoResponseDTO toResponseDTO(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setQuantidade(produto.getQuantidade());
        return dto;
    }


    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(
            @RequestBody @Valid ProdutoRequestDTO dto) {

        Produto produto = produtoService.cadastraProduto(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponseDTO(produto));
    }


    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar() {
        List<ProdutoResponseDTO> lista = produtoService.listaProdutos()
                .stream()
                .map(this::toResponseDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(toResponseDTO(produto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ProdutoRequestDTO dto) {

        Produto produto = produtoService.atualizar(id, dto);
        return ResponseEntity.ok(toResponseDTO(produto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    

}
