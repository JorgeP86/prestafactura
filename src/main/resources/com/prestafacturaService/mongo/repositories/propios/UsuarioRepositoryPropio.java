package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Usuario;

public interface UsuarioRepositoryPropio {

	Usuario getUsuario(String username, String password);

}
