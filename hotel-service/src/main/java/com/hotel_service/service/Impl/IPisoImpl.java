package com.hotel_service.service.Impl;

import com.hotel_service.Exceptions.UserNotFoundException;
import com.hotel_service.Model.Piso;
import com.hotel_service.Model.Dto.HotelDto;
import com.hotel_service.Model.Dto.PisoDto;
import com.hotel_service.Repository.IPisoRepository;
import com.hotel_service.service.IPisoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class IPisoImpl implements IPisoService {

    private final IPisoRepository pisoRepository;

    @Override
    public void save(Piso piso) {
        pisoRepository.save(piso);
    }

    @Override
    public List<PisoDto> findAll() {
        return StreamSupport.stream(pisoRepository.findAll().spliterator(), false)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PisoDto convertToDto(Piso piso) {
        HotelDto hotelDto = new HotelDto(piso.getHotel().getNombre());
        return new PisoDto(piso.getNombre(),piso.getDescripcion(),hotelDto);
    }

    @Override
    public Piso findById(Long id) {
        var piso = pisoRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return piso;
    }

    @Override
    public void deleteById(Long id) {
        if(!pisoRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        pisoRepository.deleteById(id);
    }
}