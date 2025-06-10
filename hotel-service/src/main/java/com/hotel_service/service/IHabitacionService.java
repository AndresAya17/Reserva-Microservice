package com.hotel_service.service;


import com.hotel_service.Model.Dto.HabitacionDto;
import com.hotel_service.Model.Enum.EstadoHabitacion;
import com.hotel_service.Model.Habitacion;

import java.util.List;

public interface IHabitacionService {

    void save (Habitacion habitacion);

    List<HabitacionDto> findAll();

    Habitacion findById(Long id);

    void deleteById(Long id);

    void setEstado(Long id, EstadoHabitacion estadoHabitacion);
}
