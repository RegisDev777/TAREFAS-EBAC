package br.com.hospitalcaldas.services.impl;

import br.com.hospitalcaldas.dao.contract.InternacaoDAO;
import br.com.hospitalcaldas.dao.contract.PacienteDAO;
import br.com.hospitalcaldas.entities.Internacao;
import br.com.hospitalcaldas.entities.Paciente;
import br.com.hospitalcaldas.services.contract.InternacaoService;
import br.com.hospitalcaldas.typeEnum.StatusInternacao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Implementação da camada de serviço de Internacao.
 * - Aqui entra a REGRA DE NEGÓCIO.
 * - Usa InternacaoDAO e PacienteDAO para acessar o banco.
 */
@ApplicationScoped
public class InternacaoServiceImpl implements InternacaoService {

    @Inject
    private InternacaoDAO internacaoDAO;

    @Inject
    private PacienteDAO pacienteDAO;

    @Override
    public Internacao internarPaciente(Long pacienteId,
                                       LocalDate dataEntrada,
                                       String motivo,
                                       String observacoes) {

        if (pacienteId == null) {
            throw new IllegalArgumentException("ID do paciente é obrigatório.");
        }

        // 1) Buscar o paciente
        Optional<Paciente> optPaciente = pacienteDAO.findById(pacienteId);
        if (optPaciente.isEmpty()) {
            throw new IllegalArgumentException("Paciente não encontrado. ID: " + pacienteId);
        }
        Paciente paciente = optPaciente.get();

        // 2) Se não informar data de entrada, usa hoje
        if (dataEntrada == null) {
            dataEntrada = LocalDate.now();
        }

        // 3) Motivo obrigatório
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("Motivo da internação é obrigatório.");
        }

        // 4) Montar objeto Internacao
        Internacao internacao = new Internacao();
        internacao.setPaciente(paciente);
        internacao.setDataEntrada(dataEntrada);
        internacao.setMotivo(motivo);
        internacao.setObservacoes(observacoes);
        internacao.setStatus(StatusInternacao.ATIVA);
        internacao.setAtivo(true);

        // 5) Salvar via DAO
        return internacaoDAO.save(internacao);
    }

    @Override
    public Internacao darAlta(Long internacaoId,
                              LocalDate dataAlta,
                              String observacoesAlta) {

        if (internacaoId == null) {
            throw new IllegalArgumentException("ID da internação é obrigatório.");
        }

        Optional<Internacao> opt = internacaoDAO.findById(internacaoId);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Internação não encontrada. ID: " + internacaoId);
        }

        Internacao internacao = opt.get();

        // Se não informar data de alta, usa hoje
        if (dataAlta == null) {
            dataAlta = LocalDate.now();
        }

        internacao.setStatus(StatusInternacao.ALTA);
        internacao.setDataAlta(dataAlta);

        // Anexa observação de alta, se enviada
        if (observacoesAlta != null && !observacoesAlta.isBlank()) {
            String textoAtual = internacao.getObservacoes();
            if (textoAtual == null || textoAtual.isBlank()) {
                internacao.setObservacoes("Alta: " + observacoesAlta);
            } else {
                internacao.setObservacoes(textoAtual + " | Alta: " + observacoesAlta);
            }
        }

        return internacaoDAO.save(internacao);
    }

    @Override
    public Internacao transferir(Long internacaoId,
                                 String observacoesTransferencia) {

        if (internacaoId == null) {
            throw new IllegalArgumentException("ID da internação é obrigatório.");
        }

        Optional<Internacao> opt = internacaoDAO.findById(internacaoId);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Internação não encontrada. ID: " + internacaoId);
        }

        Internacao internacao = opt.get();
        internacao.setStatus(StatusInternacao.TRANSFERIDO);

        if (observacoesTransferencia != null && !observacoesTransferencia.isBlank()) {
            String textoAtual = internacao.getObservacoes();
            if (textoAtual == null || textoAtual.isBlank()) {
                internacao.setObservacoes("Transferência: " + observacoesTransferencia);
            } else {
                internacao.setObservacoes(textoAtual + " | Transferência: " + observacoesTransferencia);
            }
        }

        return internacaoDAO.save(internacao);
    }

    @Override
    public Optional<Internacao> buscarPorId(Long id) {
        return internacaoDAO.findById(id);
    }

    @Override
    public List<Internacao> listarAtivas() {
        return internacaoDAO.findAllAtivas();
    }

    @Override
    public List<Internacao> listarPorPaciente(Long pacienteId) {
        return internacaoDAO.findByPaciente(pacienteId);
    }

    @Override
    public void excluir(Long id) {
        internacaoDAO.delete(id);
    }
}
