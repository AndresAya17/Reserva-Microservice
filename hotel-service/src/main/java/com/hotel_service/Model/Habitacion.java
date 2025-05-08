package com.hotel_service.Model;

import com.hotel_service.Model.Enum.EstadoHabitacion;
import com.hotel_service.Model.Enum.TipoHabitacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El numero no puede estar vacio.")
    @Column(nullable = false)
    private String numero;

    @NotNull(message = "El tipo de habitacion no puede estar vacio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoHabitacion tipo;

    @NotNull(message = "El precio no puede estar vacio.")
    @Column(nullable = false)
    private Double precio;

    @NotNull(message = "El estado de la habitacion no puede estar vacio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoHabitacion estado;

    @ManyToOne
    @JoinColumn(name = "piso_id", nullable = false) // Crea una FK llamada piso_id
    private Piso piso;
}
