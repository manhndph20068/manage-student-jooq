package com.example.managestudentjooq.service.old.impl;

import com.example.managestudentjooq.dto.response.AccountResponse;
import com.example.managestudentjooq.mapper.old.AccountMapper;
import com.example.managestudentjooq.repository.old.AccountRepository;
import com.example.managestudentjooq.service.old.AccountService;
import org.jooq.Record7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Optional<AccountResponse> findByUsername(String username) {
        Record7<Integer, String, String, String, Integer, LocalDateTime, LocalDateTime> accountRecord =
                accountRepository.findByUserName(username);
        AccountResponse accountResponse = accountMapper.recordToAccountResponse(accountRecord);
        return Optional.ofNullable(accountResponse);
    }

}
