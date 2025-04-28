package com.hotel_service.Controller;


import com.hotel_service.Model.Hotel;
import com.hotel_service.service.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final IHotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody Hotel hotel, BindingResult bindingResult) {
        try {
            Map<String, Object> response = new HashMap<>();
            if (bindingResult.hasFieldErrors()) {
                List<String> errors = bindingResult.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList();
                response.put("Message", errors.toString());
                return ResponseEntity.badRequest().body(errors);
            }
            response.put("Message", "Exitoso");
            hotelService.save(hotel);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        hotelService.deleteById(id);
    }
}
