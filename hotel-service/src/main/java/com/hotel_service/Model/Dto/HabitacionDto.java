package com.hotel_service.Model.Dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hotel_service.Model.Enum.EstadoHabitacion;
import com.hotel_service.Model.Enum.TipoHabitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "numero", "tipo", "precio", "estado", "pisoDto"})
public class HabitacionDto {
    private String numero;
    private TipoHabitacion tipo;
    private Double precio;
    private EstadoHabitacion estado;
    private PisoDto pisoDto;
}
