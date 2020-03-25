package com.santosh.springjwtauthorization.controller;

import com.santosh.springjwtauthorization.model.ApplicationUser;
import com.santosh.springjwtauthorization.model.Role;
import com.santosh.springjwtauthorization.model.RolesEnum;
import com.santosh.springjwtauthorization.repository.ApplicationUserRepository;
import com.santosh.springjwtauthorization.repository.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder,
                          RoleRepository roleRepository) {
        this.userRepository = applicationUserRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role adminRole = roleRepository.findByName(RolesEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);

        user.setRoles(roles);
        userRepository.save(user);
    }
}
