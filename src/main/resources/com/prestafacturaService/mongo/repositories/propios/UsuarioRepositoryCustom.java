package com.prestafacturaService.mongo.repositories.propios;

import com.prestafacturaService.mongo.dto.Usuario;


public interface UsuarioRepositoryCustom{

	Usuario getUsuario(String username, String password);

}
