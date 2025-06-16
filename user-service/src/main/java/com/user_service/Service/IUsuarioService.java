package com.user_service.Service;

import com.user_service.Model.Usuario;

public interface IUsuarioService {
    void save (Usuario usuario);

    Usuario findById(Long id);

    void deleteById(Long id);
}
