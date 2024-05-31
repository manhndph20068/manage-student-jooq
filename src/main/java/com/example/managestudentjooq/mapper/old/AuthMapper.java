package com.example.managestudentjooq.mapper.old;

import com.example.managestudentjooq.dto.request.AuthRequest;
import com.example.managestudentjooq.model.tables.pojos.Account;
import com.example.managestudentjooq.model.tables.records.AccountRecord;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Mapper
public abstract class AuthMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account toRegisterAccountRecord(AuthRequest authRequest){
        Account accountRecord = new Account();
        accountRecord.setUsername(authRequest.getUsername());
        accountRecord.setCreateAt(LocalDateTime.now());
        accountRecord.setUpdatedAt(LocalDateTime.now());
        accountRecord.setStatus(0);
        accountRecord.setRoleId(2);
        accountRecord.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        return accountRecord;
    }
}
