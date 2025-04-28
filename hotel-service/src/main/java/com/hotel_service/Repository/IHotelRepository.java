package com.hotel_service.Repository;

import com.hotel_service.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepository extends JpaRepository<Hotel, Long> {

}
