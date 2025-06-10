package com.reservation_service.Model.dto;

import com.reservation_service.Model.Enum.EstadoHabitacion;
import com.reservation_service.Model.Enum.TipoHabitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDto {
    private String numero;
    private TipoHabitacion tipo;
    private Double precio;
    private EstadoHabitacion estado;
    private PisoDto pisoDto;
}
