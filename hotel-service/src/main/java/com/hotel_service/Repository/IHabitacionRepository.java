package com.hotel_service.Repository;

import com.hotel_service.Model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHabitacionRepository extends JpaRepository<Habitacion, Long> {
}
