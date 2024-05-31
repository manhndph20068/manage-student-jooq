package com.example.managestudentjooq.repository.old.impl;

import com.example.managestudentjooq.model.tables.Account;
import com.example.managestudentjooq.model.tables.Role;
import com.example.managestudentjooq.repository.old.AccountRepository;
import org.jooq.DSLContext;
import org.jooq.Record7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private DSLContext dslContext;

    @Override
    public Record7<Integer, String, String, String, Integer, LocalDateTime, LocalDateTime> findByUserName(String userName) {
        Role r = Role.ROLE;
        Account a = Account.ACCOUNT;
        return dslContext.select(a.ID, a.USERNAME,a.PASSWORD, r.NAME, a.STATUS, a.CREATE_AT, a.UPDATED_AT)
                .from(a)
                .join(r).on(a.ROLE_ID.eq(r.ID))
                .where(a.USERNAME.eq(userName))
                .fetchOne();
    }


}
