package com.ifsul.savapc.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifsul.savapc.model.Role;
import com.ifsul.savapc.repository.roleRepository;
import com.ifsul.savapc.service.roleServices;


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
