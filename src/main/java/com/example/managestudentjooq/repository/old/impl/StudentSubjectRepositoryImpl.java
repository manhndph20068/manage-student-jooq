package com.example.managestudentjooq.repository.old.impl;

import com.example.managestudentjooq.model.tables.pojos.StudentSubject;
import com.example.managestudentjooq.model.tables.records.StudentSubjectRecord;
import com.example.managestudentjooq.repository.old.BaseRepo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.example.managestudentjooq.model.tables.StudentSubject.STUDENT_SUBJECT;


@Repository
public class StudentSubjectRepositoryImpl extends BaseRepo<StudentSubject, StudentSubjectRecord> {

    @Autowired
    protected StudentSubjectRepositoryImpl(DSLContext dslContext) {
        super(dslContext, STUDENT_SUBJECT);
    }



//    public StudentSubject studentSubject = new StudentSubject();
//
//    @Override
//    public StudentSubject findById(Integer id, Class<StudentSubject> clazz) {
//        return super.findById(id, clazz);
//    }
}
