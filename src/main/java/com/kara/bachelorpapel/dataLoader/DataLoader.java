package com.kara.bachelorpapel.dataLoader;

import com.kara.bachelorpapel.entity.Role;
import com.kara.bachelorpapel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private final RoleRepository roleRepo;

    @Autowired
    public DataLoader(RoleRepository roleRepository){
        this.roleRepo=roleRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args)  {
        if(roleRepo.findByName("ROLE_USER")==null) {
            Role userRole = new Role("ROLE_USER");
            roleRepo.save(userRole);
        }

        if(roleRepo.findByName("ROLE_ADMIN")==null) {
            Role adminRole = new Role("ROLE_ADMIN");
            roleRepo.save(adminRole);
        }

    }
}
