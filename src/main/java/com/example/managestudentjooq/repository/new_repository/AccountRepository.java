package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.model.tables.pojos.Account;
import com.example.managestudentjooq.model.tables.records.AccountRecord;
import org.jooq.User;
import org.jooq.impl.TableImpl;
import org.springframework.stereotype.Repository;

import static com.example.managestudentjooq.model.tables.Account.ACCOUNT;

@Repository
public class AccountRepository extends AbsRepository<AccountRecord, Account, Integer>{
    @Override
    protected TableImpl<AccountRecord> getTable() {
        return ACCOUNT;
    }

    public Account findByUsername(String username){
        return dslContext.selectFrom(ACCOUNT)
                .where(ACCOUNT.USERNAME.eq(username))
                .fetchOneInto(Account.class);
    }



}
