package com.hotel_service.Repository;

import com.hotel_service.Model.Piso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPisoRepository extends JpaRepository<Piso, Long> {
}
