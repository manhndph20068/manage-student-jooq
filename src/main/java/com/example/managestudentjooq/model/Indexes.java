/*
 * This file is generated by jOOQ.
 */
package com.example.managestudentjooq.model;


import com.example.managestudentjooq.model.tables.Account;
import com.example.managestudentjooq.model.tables.StudentSubject;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in manage_students.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ACCOUNT_ROLE_ID = Internal.createIndex(DSL.name("role_id"), Account.ACCOUNT, new OrderField[] { Account.ACCOUNT.ROLE_ID }, false);
    public static final Index STUDENT_SUBJECT_STUDENT_ID = Internal.createIndex(DSL.name("student_id"), StudentSubject.STUDENT_SUBJECT, new OrderField[] { StudentSubject.STUDENT_SUBJECT.STUDENT_ID }, false);
    public static final Index STUDENT_SUBJECT_SUBJECT_ID = Internal.createIndex(DSL.name("subject_id"), StudentSubject.STUDENT_SUBJECT, new OrderField[] { StudentSubject.STUDENT_SUBJECT.SUBJECT_ID }, false);
}
