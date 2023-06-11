package com.ifsul.sistema.computacional.sistematcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ifsul.sistema.computacional.sistematcc.model.Role;



public interface roleRepository extends JpaRepository<Role,Integer>{
    Role findByNameLike(String name);
    
}
