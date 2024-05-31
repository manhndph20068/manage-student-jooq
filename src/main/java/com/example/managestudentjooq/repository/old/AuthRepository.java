package com.example.managestudentjooq.repository.old;

import com.example.managestudentjooq.model.tables.pojos.Account;

public interface AuthRepository {
    Boolean checkUsernameHasExited(String username);
    Account registerAccount(Account account);
    String getRoleNameByUsername(String username);
}
