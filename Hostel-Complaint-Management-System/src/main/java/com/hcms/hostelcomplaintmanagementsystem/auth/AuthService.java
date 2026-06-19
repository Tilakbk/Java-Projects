package com.hcms.hostelcomplaintmanagementsystem.auth;

import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.EmailAlreadyExistsException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.IllegalStateFoundException;
import com.hcms.hostelcomplaintmanagementsystem.exceptionhandling.illegalStateFoundException;
import com.hcms.hostelcomplaintmanagementsystem.jwt.JwtService;
import com.hcms.hostelcomplaintmanagementsystem.mapper.Mapper;
import com.hcms.hostelcomplaintmanagementsystem.user.Role;
import com.hcms.hostelcomplaintmanagementsystem.user.User;
import com.hcms.hostelcomplaintmanagementsystem.user.UserPrinciple;
import com.hcms.hostelcomplaintmanagementsystem.user.UserRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Transactional
    public AuthResponseDto register(RegisterRequestDto registerRequestDto)
    {
        log.debug("Attempting to login user with email, {}", registerRequestDto.getEmail());

        if (userRepo.existsByEmail(registerRequestDto.getEmail()))
        {
            log.warn("Email exists: {}",registerRequestDto.getEmail());
            throw new EmailAlreadyExistsException(registerRequestDto.getEmail()+" This email already exists");
        }

        User systemUser= Mapper.toUser(registerRequestDto);
        systemUser.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        systemUser.setRole(Role.SYSTEM_ADMIN);

        User savedUser= userRepo.save(systemUser);
        AuthResponseDto authResponseDto= Mapper.toResponseDto(savedUser);

        HashMap<String, Object> extraClaim= new HashMap<>();
        extraClaim.put("role",Role.SYSTEM_ADMIN.name());
        authResponseDto.setToken(jwtService.generateToken(extraClaim,new UserPrinciple(savedUser)));

        return authResponseDto;
    }

    @Transactional(readOnly = true)
    public AuthResponseDto login(@Valid LoginRequestDto loginRequestDto) {

        log.debug("Attempting to login using : {}",loginRequestDto.getEmail());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword()));

        User authenticatedUser= userRepo.findByEmail(loginRequestDto.getEmail()).orElseThrow(()-> new IllegalStateFoundException(loginRequestDto.getEmail()+" Authenticated user with this email is not in db"));

    }
}
