package com.reservation_service.service.Impl;

import com.reservation_service.Client.HotelClient;
import com.reservation_service.Model.Enum.EstadoHabitacion;
import com.reservation_service.Model.Reserva;
import com.reservation_service.Model.dto.HabitacionDto;
import com.reservation_service.Repository.IReservaRepository;
import com.reservation_service.service.IReservaService;
import com.reservation_service.Exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@RequiredArgsConstructor
public class IReservaImpl implements IReservaService {
    private final IReservaRepository reservaRepository;
    private final HotelClient hotelService;

    @Override
    public void save(Reserva reserva) {
        HabitacionDto habitacion = hotelService.finHabitacionById(reserva.getHabitacionId());
        if (EstadoHabitacion.DISPONIBLE != habitacion.getEstado()) {
            throw new IllegalStateException("La habitación no está disponible para reservar.");
        }
        reservaRepository.save(reserva);
        hotelService.setEstado(reserva.getHabitacionId(), EstadoHabitacion.RESERVADA);
    }

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        var reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return reserva;
    }

    @Override
    public void deleteById(Long id) {
        if(!reservaRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        reservaRepository.deleteById(id);
    }
}
