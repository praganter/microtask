package dev.batuhanyetgin.mssecurityservice.service.abstr;

import dev.batuhanyetgin.mssecurityservice.dto.LoginDto;
import dev.batuhanyetgin.mssecurityservice.dto.LoginResponseDto;
import dev.batuhanyetgin.mssecurityservice.dto.RegisterDto;
import dev.batuhanyetgin.mssecurityservice.exception.AuthException;

public interface AuthService {

    LoginResponseDto login(LoginDto loginDto) throws AuthException;

    String register(RegisterDto registerDto) throws AuthException;

    boolean isTokenExpired(String token);

    String getEmailByToken(String token);
}
