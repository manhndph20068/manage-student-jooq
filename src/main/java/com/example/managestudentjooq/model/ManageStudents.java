/*
 * This file is generated by jOOQ.
 */
package com.example.managestudentjooq.model;


import com.example.managestudentjooq.model.tables.Account;
import com.example.managestudentjooq.model.tables.Role;
import com.example.managestudentjooq.model.tables.StudentSubject;
import com.example.managestudentjooq.model.tables.Students;
import com.example.managestudentjooq.model.tables.Subjects;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ManageStudents extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>manage_students</code>
     */
    public static final ManageStudents MANAGE_STUDENTS = new ManageStudents();

    /**
     * The table <code>manage_students.account</code>.
     */
    public final Account ACCOUNT = Account.ACCOUNT;

    /**
     * The table <code>manage_students.role</code>.
     */
    public final Role ROLE = Role.ROLE;

    /**
     * The table <code>manage_students.student_subject</code>.
     */
    public final StudentSubject STUDENT_SUBJECT = StudentSubject.STUDENT_SUBJECT;

    /**
     * The table <code>manage_students.students</code>.
     */
    public final Students STUDENTS = Students.STUDENTS;

    /**
     * The table <code>manage_students.subjects</code>.
     */
    public final Subjects SUBJECTS = Subjects.SUBJECTS;

    /**
     * No further instances allowed
     */
    private ManageStudents() {
        super("manage_students", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Account.ACCOUNT,
            Role.ROLE,
            StudentSubject.STUDENT_SUBJECT,
            Students.STUDENTS,
            Subjects.SUBJECTS
        );
    }
}
