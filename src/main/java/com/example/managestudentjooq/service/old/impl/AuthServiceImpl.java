package com.example.managestudentjooq.service.old.impl;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.config.AppConstant;
import com.example.managestudentjooq.dto.request.AuthRequest;
import com.example.managestudentjooq.dto.response.AccountResponse;
import com.example.managestudentjooq.dto.response.TokenResponse;
import com.example.managestudentjooq.exception.UsernameHasExited;
import com.example.managestudentjooq.mapper.old.AuthMapper;
import com.example.managestudentjooq.repository.old.AuthRepository;
import com.example.managestudentjooq.sercurity.service.JwtService;
import com.example.managestudentjooq.service.old.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthMapper authMapper;

    @Override
    public ServiceResult<TokenResponse> login(String username, String password) {
        try {
            authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(username, password));
                String role = authRepository.getRoleNameByUsername(username);
                String accessToken = jwtService.generateAccessToken(role, username);
                String refreshToken = jwtService.generateRefreshToken(role, username);
                return new ServiceResult<>(AppConstant.SUCCESS, "Login success"
                        , TokenResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build()
                );
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ServiceResult<AccountResponse> register(AuthRequest authRequest) throws Exception {
        try {
            Boolean accountRecord
                    = authRepository.checkUsernameHasExited(authRequest.getUsername());
            if (accountRecord == true) {
                throw new UsernameHasExited("Username is already exist");
            }
            authRepository.registerAccount(authMapper.toRegisterAccountRecord(authRequest));
            return new ServiceResult<AccountResponse>(AppConstant.SUCCESS, "Register success", null);
        }catch (Exception e) {
            return new ServiceResult<AccountResponse>(AppConstant.BAD_REQUEST, e.getMessage(), null);
        }

    }

    @Override
    public ServiceResult<TokenResponse> refreshToken(String token) throws Exception {
        if (token == null) {
            return new ServiceResult<>(AppConstant.FAIL, "Token is null", null);
        }
        String username = jwtService.extractToUserName(token);
        String role = authRepository.getRoleNameByUsername(username);
        String accessToken = jwtService.generateAccessToken(role,username);
        String refreshToken = jwtService.generateRefreshToken(role,username);
        return new ServiceResult<>(AppConstant.SUCCESS, "Login success"
                , TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build()
        );
    }
}
