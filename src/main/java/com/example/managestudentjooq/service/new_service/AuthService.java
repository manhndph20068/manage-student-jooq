package com.example.managestudentjooq.service.new_service;

import com.example.managestudentjooq.dto.response.AccountRoleResponse;
import com.example.managestudentjooq.mapper.old.AccountMapper;
import com.example.managestudentjooq.model.tables.pojos.Account;
import com.example.managestudentjooq.model.tables.pojos.Role;
import com.example.managestudentjooq.repository.new_repository.AccountRepository;
import com.example.managestudentjooq.repository.new_repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountMapper accountMapper;

    public AccountRoleResponse findAccountRoleByUsername(String username){
        Account account = accountRepository.findByUsername(username);
        Optional<Role> role = roleRepository.findById(account.getRoleId());
        return accountMapper.toAccountRoleResponse(account, role.get());
    }
}
