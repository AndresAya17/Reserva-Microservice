package com.hotel_service.service;

import com.hotel_service.Model.Piso;
import com.hotel_service.Model.Dto.PisoDto;

import java.util.List;

public interface IPisoService {

    void save (Piso piso);

    List<PisoDto> findAll();

    Piso findById(Long id);

    void deleteById(Long id);
}
