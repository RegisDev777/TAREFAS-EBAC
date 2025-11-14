package br.com.hospitalcaldas.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.hospitalcaldas.typeEnum.StatusInternacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * ENTIDADE INTERNACAO
 * - Representa uma internação de um paciente.
 * - Regras principais:
 *   • Sempre ligada a um Paciente (@ManyToOne obrigatório).
 *   • Possui datas de entrada e (opcionalmente) alta.
 *   • Usa status (ATIVA, ALTA, etc).
 *   • Usa campo "ativo" para soft delete.
 *   • Usa auditoria (criadoEm / atualizadoEm).
 */
@Entity
@Table(name = "internacao")
public class Internacao {

    // ===== IDENTIDADE =====
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== RELACIONAMENTOS =====

    @ManyToOne(optional = false) // uma internação sempre tem um paciente
    @JoinColumn(
        name = "paciente_id",
        foreignKey = @ForeignKey(name = "fk_internacao_paciente")
    )
    private Paciente paciente;

    // ===== DADOS PRINCIPAIS =====

    @NotNull
    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;          // quando o paciente entrou

    @Column(name = "data_prevista_alta")
    private LocalDate dataPrevistaAlta;     // previsão de alta (opcional)

    @Column(name = "data_alta")
    private LocalDate dataAlta;             // data de alta real (opcional)

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StatusInternacao status = StatusInternacao.ATIVA;

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "motivo", nullable = false, length = 255)
    private String motivo;                  // ex: "Pneumonia grave"

    @Size(max = 500)
    @Column(name = "diagnostico_principal", length = 500)
    private String diagnosticoPrincipal;    // laudo principal (opcional)

    @Size(max = 1000)
    @Column(name = "observacoes", length = 1000)
    private String observacoes;             // outras infos, texto livre

    // ===== CONTROLE / AUDITORIA =====

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;           // soft delete

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;

    // ===== CONSTRUTORES =====

    public Internacao() {
    }

    public Internacao(Paciente paciente, LocalDate dataEntrada, String motivo) {
        this.paciente = paciente;
        this.dataEntrada = dataEntrada;
        this.motivo = motivo;
        this.status = StatusInternacao.ATIVA;
        this.ativo = true;
    }

    // ===== CALLBACKS JPA =====

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = this.criadoEm;

        if (this.motivo != null) {
            this.motivo = this.motivo.trim();
        }
        if (this.diagnosticoPrincipal != null) {
            this.diagnosticoPrincipal = this.diagnosticoPrincipal.trim();
        }
        if (this.observacoes != null) {
            this.observacoes = this.observacoes.trim();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();

        if (this.motivo != null) {
            this.motivo = this.motivo.trim();
        }
        if (this.diagnosticoPrincipal != null) {
            this.diagnosticoPrincipal = this.diagnosticoPrincipal.trim();
        }
        if (this.observacoes != null) {
            this.observacoes = this.observacoes.trim();
        }
    }

    // ===== GETTERS E SETTERS =====

    public Long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataPrevistaAlta() {
        return dataPrevistaAlta;
    }

    public void setDataPrevistaAlta(LocalDate dataPrevistaAlta) {
        this.dataPrevistaAlta = dataPrevistaAlta;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public StatusInternacao getStatus() {
        return status;
    }

    public void setStatus(StatusInternacao status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
    }

    public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}
