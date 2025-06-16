package com.user_service.Service.Impl;

import com.user_service.Exceptions.UserNotFoundException;
import com.user_service.Model.Usuario;
import com.user_service.Repository.IUsuarioRepository;
import com.user_service.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class IUsuarioImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        var usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return usuario;
    }

    @Override
    public void deleteById(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        usuarioRepository.deleteById(id);
    }
}
