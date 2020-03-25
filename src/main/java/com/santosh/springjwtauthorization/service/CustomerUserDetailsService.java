package com.santosh.springjwtauthorization.service;

import com.santosh.springjwtauthorization.model.ApplicationUser;
import com.santosh.springjwtauthorization.repository.ApplicationUserRepository;
import com.santosh.springjwtauthorization.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private ApplicationUserRepository userRepository;

    public CustomerUserDetailsService(ApplicationUserRepository applicationUserRepository) {
        this.userRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserPrincipal.build(applicationUser);
    }
}
