package com.example.managestudentjooq.service.old;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.dto.response.AccountResponse;
import com.example.managestudentjooq.dto.response.TokenResponse;

import java.util.Optional;

public interface AccountService {
    Optional<AccountResponse> findByUsername(String username);
//    ServiceResult<TokenResponse> login(String username, String password);
}
