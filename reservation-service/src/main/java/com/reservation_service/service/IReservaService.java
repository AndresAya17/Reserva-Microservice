package com.reservation_service.service;

import com.reservation_service.Model.Reserva;

import java.util.List;

public interface IReservaService {

    void save (Reserva reserva);

    List<Reserva> findAll();

    Reserva findById(Long id);

    void deleteById(Long id);
}
