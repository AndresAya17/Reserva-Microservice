package com.hotel_service.service.Impl;

import com.hotel_service.Exceptions.UserNotFoundException;
import com.hotel_service.Model.Dto.HabitacionDto;
import com.hotel_service.Model.Dto.HotelDto;
import com.hotel_service.Model.Dto.PisoDto;
import com.hotel_service.Model.Habitacion;
import com.hotel_service.Repository.IHabitacionRepository;
import com.hotel_service.service.IHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class IHabitacionImpl implements IHabitacionService {

    private final IHabitacionRepository habitacionRepository;

    @Override
    public void save(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    @Override
    public List<HabitacionDto> findAll() {
        return StreamSupport.stream(habitacionRepository.findAll().spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private HabitacionDto convertToDto(Habitacion habitacion) {
        HotelDto hotelDto = new HotelDto(habitacion.getPiso().getHotel().getNombre());
        PisoDto pisoDto = new PisoDto(habitacion.getPiso().getNombre(),habitacion.getPiso().getDescripcion(),hotelDto);
        return new HabitacionDto(habitacion.getNumero(),habitacion.getTipo(),habitacion.getPrecio(),habitacion.getEstado(),pisoDto);
    }

    @Override
    public Habitacion findById(Long id) {
        var habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return habitacion;
    }

    @Override
    public void deleteById(Long id) {
        if(!habitacionRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        habitacionRepository.deleteById(id);
    }
}
