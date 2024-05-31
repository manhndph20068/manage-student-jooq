package com.example.managestudentjooq.service.old;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.dto.request.AuthRequest;
import com.example.managestudentjooq.dto.response.AccountResponse;
import com.example.managestudentjooq.dto.response.TokenResponse;

public interface AuthService {
    ServiceResult<TokenResponse> login(String username, String password);
    ServiceResult<AccountResponse> register(AuthRequest authRequest) throws Exception;
    ServiceResult<TokenResponse> refreshToken(String token) throws Exception;
}
