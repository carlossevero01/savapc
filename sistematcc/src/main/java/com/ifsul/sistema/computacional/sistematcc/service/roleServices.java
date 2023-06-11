package com.ifsul.sistema.computacional.sistematcc.service;

import java.util.List;

import com.ifsul.sistema.computacional.sistematcc.model.Role;


public interface roleServices {
    List<Role> findAll();
    Role findByNameLike(String name);
    
}
