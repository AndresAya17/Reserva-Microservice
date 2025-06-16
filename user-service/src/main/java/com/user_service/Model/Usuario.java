package com.user_service.Model;

import com.user_service.Model.Enum.RolUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede estar vacio.")
    @Column(nullable = false)
    private String nombre;

    @Email(message = "El correo tiene que ser correcto")
    @Column(nullable = false)
    private String correo;

    @NotNull(message = "La contraseña tiene que ser correcto")
    @Column(nullable = false)
    private String contraseña;

    @NotNull(message = "El tipo de usuario no puede estar vacia.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rol;
}
