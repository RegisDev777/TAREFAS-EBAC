package br.com.hospitalcaldas.services.contract;

import br.com.hospitalcaldas.entities.Internacao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço de Internacao.
 * - Aqui ficam as REGRAS DE NEGÓCIO.
 * - A tela (JSF, etc.) chama esse serviço.
 * - Ele usa o DAO por baixo.
 */
public interface InternacaoService {

    /**
     * Cria uma nova internação para um paciente.
     *
     * @param pacienteId   id do paciente que será internado
     * @param dataEntrada  data da entrada (se null, usa a data de hoje)
     * @param motivo       motivo da internação (obrigatório)
     * @param observacoes  observações opcionais
     */
    Internacao internarPaciente(Long pacienteId,
                                LocalDate dataEntrada,
                                String motivo,
                                String observacoes);

    /**
     * Dá alta em uma internação.
     *
     * @param internacaoId id da internação
     * @param dataAlta     data da alta (se null, usa a data de hoje)
     * @param observacoesAlta texto sobre a alta (opcional)
     */
    Internacao darAlta(Long internacaoId,
                       LocalDate dataAlta,
                       String observacoesAlta);

    /**
     * Marca uma internação como transferida.
     */
    Internacao transferir(Long internacaoId,
                          String observacoesTransferencia);

    /**
     * Busca uma internação pelo id.
     */
    Optional<Internacao> buscarPorId(Long id);

    /**
     * Lista todas as internações ativas (ativo = true).
     */
    List<Internacao> listarAtivas();

    /**
     * Lista todas as internações (ativas ou não) de um paciente.
     */
    List<Internacao> listarPorPaciente(Long pacienteId);

    /**
     * "Exclui" uma internação (soft delete: ativo = false).
     */
    void excluir(Long id);
}
