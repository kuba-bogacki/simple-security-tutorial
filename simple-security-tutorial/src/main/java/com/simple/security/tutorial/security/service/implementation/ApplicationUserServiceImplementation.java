package com.simple.security.tutorial.security.service.implementation;

import com.simple.security.tutorial.security.authentication.ApplicationUser;
import com.simple.security.tutorial.security.repository.ApplicationUserRepository;
import com.simple.security.tutorial.security.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.simple.security.tutorial.security.security.ApplicationUserRole.*;

@Service
public class ApplicationUserServiceImplementation implements ApplicationUserService, UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserServiceImplementation(ApplicationUserRepository applicationUserRepository,
                                                PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findApplicationUserByUsername(username);
    }

    @Override
    public void createNewApplicationUser() {
        ApplicationUser appUser1 = new ApplicationUser();
        appUser1.setUsername("John");
        appUser1.setPassword(passwordEncoder.encode("admin"));
        appUser1.setAccountNonExpired(true);
        appUser1.setAccountNonLocked(true);
        appUser1.setCredentialsNonExpired(true);
        appUser1.setEnabled(true);
        appUser1.setAuthorities(ADMIN.getGrantedAuthorities());

        ApplicationUser appUser2 = new ApplicationUser();
        appUser2.setUsername("Jack");
        appUser2.setPassword(passwordEncoder.encode("moderator"));
        appUser2.setAccountNonExpired(true);
        appUser2.setAccountNonLocked(true);
        appUser2.setCredentialsNonExpired(true);
        appUser2.setEnabled(true);
        appUser2.setAuthorities(MODERATOR.getGrantedAuthorities());

        ApplicationUser appUser3 = new ApplicationUser();
        appUser3.setUsername("Miriam");
        appUser3.setPassword(passwordEncoder.encode("student"));
        appUser3.setAccountNonExpired(true);
        appUser3.setAccountNonLocked(true);
        appUser3.setCredentialsNonExpired(true);
        appUser3.setEnabled(true);
        appUser3.setAuthorities(STUDENT.getGrantedAuthorities());

        applicationUserRepository.save(appUser1);
        applicationUserRepository.save(appUser2);
        applicationUserRepository.save(appUser3);
    }
}
