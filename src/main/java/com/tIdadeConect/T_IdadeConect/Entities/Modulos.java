package com.tIdadeConect.T_IdadeConect.Entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modulos")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Modulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Cursos curso;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "ordem")
    private int ordem;

}
