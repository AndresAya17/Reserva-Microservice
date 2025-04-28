package com.hotel_service.service;

import com.hotel_service.Model.Hotel;

public interface IHotelService {
    void save (Hotel hotel);

    Hotel findById(Long id);

    void deleteById(Long id);
}
