package com.tIdadeConect.T_IdadeConect.Entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "aulas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "modulo_id", nullable = false)
    private Modulos modulo;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(name = "video_url", nullable = false, length = 500)
    private String videoUrl;

    @Column(name = "ordem")
    private Integer ordem;

    @Column(name = "duracao_segundos")
    private Integer duracaoSegundos;

}
