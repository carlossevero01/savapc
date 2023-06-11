package com.ifsul.sistema.computacional.sistematcc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.sistema.computacional.sistematcc.model.Role;
import com.ifsul.sistema.computacional.sistematcc.repository.roleRepository;
import com.ifsul.sistema.computacional.sistematcc.service.roleServices;


public class roleServiceImplements implements roleServices{
        @Autowired
         roleRepository rRepository;

        @Override
        public List<Role> findAll() {
            return rRepository.findAll();
        }

        @Override
        public Role findByNameLike(String name) {
            return rRepository.findByNameLike(name);
        }

        

   
    

   

    
    
}
