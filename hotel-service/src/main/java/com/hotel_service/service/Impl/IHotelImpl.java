package com.hotel_service.service.Impl;

import com.hotel_service.Exceptions.UserNotFoundException;
import com.hotel_service.Model.Hotel;
import com.hotel_service.Repository.IHotelRepository;
import com.hotel_service.service.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IHotelImpl implements IHotelService {

    private final IHotelRepository hotelRepository;

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel findById(Long id) {
        var hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return hotel;
    }

    @Override
    public void deleteById(Long id) {
        if(!hotelRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        hotelRepository.deleteById(id);
    }
}
