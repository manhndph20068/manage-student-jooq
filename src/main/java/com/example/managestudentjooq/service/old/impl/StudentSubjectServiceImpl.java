package com.example.managestudentjooq.service.old.impl;

import com.example.managestudentjooq.model.tables.pojos.StudentSubject;
import com.example.managestudentjooq.model.tables.records.StudentSubjectRecord;
import com.example.managestudentjooq.repository.old.BaseRepo;
import com.example.managestudentjooq.service.old.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

    @Autowired
    private BaseRepo<StudentSubject, StudentSubjectRecord> baseRepo;


    @Override
    public StudentSubject findById(Integer id) {
        StudentSubject student = baseRepo.findById(1, StudentSubject.class);
        return student;
    }
}
