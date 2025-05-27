package com.reservation_service.Model;


import com.reservation_service.Model.Enum.EstadoReserva;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario no puede estar vacio.")
    @Column(name= "user_id", nullable = false)
    private Long userId;

    @NotNull(message = "La habitacion no puede estar vacio.")
    @Column(name= "habitacion_id", nullable = false)
    private Long habitacionId;

    @NotNull(message = "La fecha inicio no puede estar vacio.")
    @FutureOrPresent(message = "La fecha debe ser hoy o una fecha futura.")
    @Column(name= "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha fin no puede estar vacio.")
    @Future(message = "La fecha debe estar en el futuro.")
    @Column(name= "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @NotNull(message = "El estado de la reserva no puede estar vacio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado;

}
