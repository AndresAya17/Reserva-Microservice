package com.reservation_service.Controller;

import com.reservation_service.Model.Reserva;
import com.reservation_service.service.IReservaService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/v1/reserva")
@RequiredArgsConstructor
public class ReservaController {
    private final IReservaService reservaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@Valid @RequestBody Reserva reserva, BindingResult bindingResult) {
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
            reservaService.save(reserva);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        reservaService.deleteById(id);
    }
}
