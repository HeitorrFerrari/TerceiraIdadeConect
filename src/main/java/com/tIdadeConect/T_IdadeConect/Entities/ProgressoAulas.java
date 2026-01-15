package com.tIdadeConect.T_IdadeConect.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "progresso_aulas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgressoAulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aulas aula;

    @Column(nullable = false)
    private Boolean assistido = false;

    @Column(name = "assistido_em")
    private LocalDateTime assistidoEm;

}
