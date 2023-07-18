package com.ifsul.savapc.service;

import java.util.List;

import com.ifsul.savapc.model.Role;


public interface roleServices {
    List<Role> findAll();
    Role findByNameLike(String name);
    
}
