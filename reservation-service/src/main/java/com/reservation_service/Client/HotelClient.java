package com.reservation_service.Client;

import com.reservation_service.Model.Enum.EstadoHabitacion;
import com.reservation_service.Model.dto.HabitacionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hotel-service", url = "localhost:8080")
public interface HotelClient {

    @GetMapping("/api/v1/habitacion/{habitacionId}")
    HabitacionDto finHabitacionById(@PathVariable Long habitacionId);

    @PatchMapping("/api/v1/habitacion/{habitacionId}")
    void setEstado(@PathVariable Long habitacionId, @RequestBody EstadoHabitacion estado);
}