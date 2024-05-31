package com.example.managestudentjooq.mapper.old;

import com.example.managestudentjooq.dto.request.AccountRoleRequest;
import com.example.managestudentjooq.dto.response.AccountResponse;
import com.example.managestudentjooq.dto.response.AccountRoleResponse;
import com.example.managestudentjooq.mapper.new_mappper.BaseMapper;
import com.example.managestudentjooq.mapper.new_mappper.RoleMapper;
import com.example.managestudentjooq.model.tables.pojos.Role;
import com.example.managestudentjooq.model.tables.pojos.Account;
import org.jooq.Record7;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public abstract class AccountMapper extends BaseMapper<AccountRoleRequest, AccountRoleResponse, Account> {

    @Autowired
    private RoleMapper roleMapper;

    @Mapping(target = "id", expression = "java(record.value1())")
    @Mapping(target = "userName", expression = "java(record.value2())")
    @Mapping(target = "password", expression = "java(record.value3())")
    @Mapping(target = "role", expression = "java(record.value4())")
    @Mapping(target = "status", expression = "java(record.value5())")
    @Mapping(target = "createAt", expression = "java(record.value6())")
    @Mapping(target = "updatedAt", expression = "java(record.value7())")
    public abstract AccountResponse recordToAccountResponse(Record7<Integer, String, String, String, Integer, LocalDateTime, LocalDateTime> record);

//    @Mapping(target = "userName", source = "username")
//    public abstract AccountResponse toAccountResponse(AccountRecord accountRecord);

    @Mapping(source = "account.id", target = "id")
    @Mapping(source = "account.username", target = "username")
    public abstract AccountRoleResponse toAccountRoleResponse(Account account, Role role);

    @AfterMapping
    public void afterResponse(@MappingTarget AccountRoleResponse accountRoleResponse, Role role){
        accountRoleResponse.setRoleResponse(roleMapper.toResponse(role));
    }
}
