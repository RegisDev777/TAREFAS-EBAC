package br.com.rpires;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.dao.ProdutoDAO;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOTest {

    private final IProdutoDAO produtoDao = new ProdutoDAO();

    @AfterEach
    void cleanup() {
        try {
            Collection<Produto> list = produtoDao.buscarTodos();
            for (Produto p : list) {
                produtoDao.excluir(p.getCodigo());
            }
        } catch (Exception ignore) { }
    }

    private Produto novoProduto(String codigo) {
        Produto p = new Produto();
        p.setCodigo(codigo);
        p.setNome("Teclado Mecânico");
        p.setDescricao("Switch blue, ABNT2");
        p.setValor(new BigDecimal("199.90"));
        p.setEstoque(15);
        return p;
    }

    @Test
    void salvarEConsultar() throws Exception {
        Produto p = novoProduto("P-001");
        Boolean ok = produtoDao.cadastrar(p);
        assertTrue(ok);

        Produto consultado = produtoDao.consultar("P-001");
        assertNotNull(consultado);
        assertEquals("Teclado Mecânico", consultado.getNome());
        assertEquals(new BigDecimal("199.90"), consultado.getValor());
        assertEquals(15, consultado.getEstoque());
    }

    @Test
    void alterar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Produto p = novoProduto("P-002");
        assertTrue(produtoDao.cadastrar(p));

        Produto existente = produtoDao.consultar("P-002");
        assertNotNull(existente);

        existente.setNome("Teclado Mecânico Pro");
        existente.setDescricao("Switch red, RGB");
        existente.setValor(new BigDecimal("349.90"));
        existente.setEstoque(20);

        produtoDao.alterar(existente);

        Produto alterado = produtoDao.consultar("P-002");
        assertNotNull(alterado);
        assertEquals("Teclado Mecânico Pro", alterado.getNome());
        assertEquals("Switch red, RGB", alterado.getDescricao());
        assertEquals(new BigDecimal("349.90"), alterado.getValor());
        assertEquals(20, alterado.getEstoque());
    }

    @Test
    void excluir() throws Exception {
        Produto p = novoProduto("P-003");
        assertTrue(produtoDao.cadastrar(p));

        Produto consultado = produtoDao.consultar("P-003");
        assertNotNull(consultado);

        produtoDao.excluir("P-003");
        Produto depois = produtoDao.consultar("P-003");
        assertNull(depois);
    }

    @Test
    void buscarTodos() throws Exception {
        assertTrue(produtoDao.cadastrar(novoProduto("P-004")));
        assertTrue(produtoDao.cadastrar(novoProduto("P-005")));

        Collection<Produto> list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
    }
}
