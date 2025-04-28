package com.hotel_service.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "piso")
public class Piso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Nombre;
    @Column(nullable = false)
    private String Descripcion;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false) // Crea una FK llamada hotel_id
    private Hotel hotel;
}
