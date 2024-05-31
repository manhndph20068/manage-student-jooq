package com.example.managestudentjooq.repository.old.impl;


import com.example.managestudentjooq.model.tables.Role;
import com.example.managestudentjooq.model.tables.pojos.Account;
import com.example.managestudentjooq.repository.old.AuthRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.example.managestudentjooq.model.tables.Account.ACCOUNT;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

    @Autowired
    private DSLContext dslContext;

    @Override
    public Boolean checkUsernameHasExited(String username) {
        return dslContext.selectCount()
                .from(ACCOUNT)
                .where(ACCOUNT.USERNAME.eq(username))
                .fetchOne(0, Integer.class) > 0;
    }

    @Override
    public Account registerAccount(Account account) {
        return dslContext.insertInto(ACCOUNT)
                .set(dslContext.newRecord(ACCOUNT, account))
                .returning()
                .fetchOne()
                .into(Account.class);
    }

    @Override
    public String getRoleNameByUsername(String username) {
        return dslContext.select(Role.ROLE.NAME)
                .from(Role.ROLE)
                .join(ACCOUNT).on(Role.ROLE.ID.eq(ACCOUNT.ROLE_ID))
                .where(ACCOUNT.USERNAME.eq(username))
                .fetchOneInto(String.class);
    }
}
