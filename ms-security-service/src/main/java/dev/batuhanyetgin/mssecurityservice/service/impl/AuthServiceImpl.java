package dev.batuhanyetgin.mssecurityservice.service.impl;

import dev.batuhanyetgin.mssecurityservice.component.TokenManager;
import dev.batuhanyetgin.mssecurityservice.dto.CustomerDto;
import dev.batuhanyetgin.mssecurityservice.dto.LoginDto;
import dev.batuhanyetgin.mssecurityservice.dto.LoginResponseDto;
import dev.batuhanyetgin.mssecurityservice.dto.RegisterDto;
import dev.batuhanyetgin.mssecurityservice.entity.UserEntity;
import dev.batuhanyetgin.mssecurityservice.exception.AuthException;
import dev.batuhanyetgin.mssecurityservice.repository.UserRepository;
import dev.batuhanyetgin.mssecurityservice.service.abstr.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenManager tokenManager;


    @Override
    public String register(RegisterDto registerDto) throws AuthException {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new AuthException("Email already registered.");
        }
        registerDto.setPassword(encodedPassword(registerDto.getPassword()));
        log.info(registerDto + "send to customer client");
        userRepository.save(modelMapper.map(registerDto, UserEntity.class));
        log.info("User added -> " + registerDto);
        return registerDto.getName() + " successfully registered with " + registerDto.getEmail();
    }

    @Override
    public boolean isTokenExpired(String token) {
        return (tokenManager.isExpired(token) || userRepository.existsByEmail(tokenManager.getSubject(token)));
    }

    @Override
    public String getEmailByToken(String token) {
        return tokenManager.getSubject(token);
    }

    @Override
    public LoginResponseDto login(LoginDto loginDto) throws AuthException {
        CustomerDto customerDto = modelMapper.map(userRepository.getByEmail(loginDto.getEmail()), CustomerDto.class);
        if (customerDto != null && isPasswordMatch(loginDto.getPassword(), customerDto.getPassword())) {
            String token = tokenManager.generateToken(loginDto.getEmail(), String.valueOf(customerDto.getId()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            log.info("Successfully login.");
            return new LoginResponseDto(customerDto.getName(), sdf.format(new Date()), token);
        } else {
            throw new AuthException("There is no user with email : " + loginDto.getEmail());
        }
    }

    private String encodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private boolean isPasswordMatch(String rawPassword, String dbPassword) {
        return passwordEncoder.matches(rawPassword, dbPassword);
    }
}
