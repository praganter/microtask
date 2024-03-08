package dev.batuhanyetgin.mssecurityservice.controller;

import dev.batuhanyetgin.mssecurityservice.dto.LoginDto;
import dev.batuhanyetgin.mssecurityservice.dto.LoginResponseDto;
import dev.batuhanyetgin.mssecurityservice.dto.RegisterDto;
import dev.batuhanyetgin.mssecurityservice.exception.AuthException;
import dev.batuhanyetgin.mssecurityservice.service.abstr.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto loginDto) throws AuthException {
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) throws AuthException {
        return ResponseEntity.ok(authService.register(registerDto));
    }

    @GetMapping("/{token}")
    public boolean isTokenExpired(@PathVariable String token) {
        return authService.isTokenExpired(token);
    }

    @GetMapping("/getEmail/{token}")
    private String getEmailFromToken(@PathVariable String token) {
        return authService.getEmailByToken(token);
    }
}
