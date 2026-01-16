package br.com.rpires.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔹 ERRO 404 – Produto não encontrado
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleProdutoNaoEncontrado(
            ProdutoNaoEncontradoException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    // 🔹 ERRO 400 – Validação (DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidacao(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        erros.put(error.getField(), error.getDefaultMessage())
                );

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("status", 400);
        resposta.put("erros", erros);

        return ResponseEntity.badRequest().body(resposta);
    }

    // 🔹 ERRO 500 – Genérico
    public ResponseEntity<Map<String, Object>> handleErroGeral(Exception ex) {

        ex.printStackTrace(); // 👈 MUITO IMPORTANTE AGORA

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 500);
        erro.put("mensagem", "Erro interno do servidor");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(erro);
    }
}
