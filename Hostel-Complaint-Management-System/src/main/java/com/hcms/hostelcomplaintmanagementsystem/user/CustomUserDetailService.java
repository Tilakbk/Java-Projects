package com.hcms.hostelcomplaintmanagementsystem.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername( String email) throws UsernameNotFoundException {

        log.debug("Attempting to load user by email: {}",email);
        UserPrinciple user= userRepo.findByEmail(email).map(UserPrinciple::new).orElseThrow(()->new UsernameNotFoundException(email+"User with this email not found"));

        log.debug("User successfully loaded with id : {} and role : {}",user.getUsername(),user.getUser().getRole());

        return user;


    }
}
