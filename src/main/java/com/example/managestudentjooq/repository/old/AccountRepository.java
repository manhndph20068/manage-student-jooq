package com.example.managestudentjooq.repository.old;

import org.jooq.Record7;

import java.time.LocalDateTime;

public interface AccountRepository {
    Record7<Integer, String, String, String, Integer, LocalDateTime, LocalDateTime> findByUserName(String userName);

}
