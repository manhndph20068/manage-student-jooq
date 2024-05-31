package com.example.managestudentjooq.repository.old;

import com.example.managestudentjooq.model.tables.records.SubjectsRecord;

import java.util.List;

public interface SubjectRepository {
    List<SubjectsRecord> findAll();
    SubjectsRecord findById(Integer id);
    SubjectsRecord addSubject(SubjectsRecord subjectsRecord);
    SubjectsRecord updateSubject(SubjectsRecord subjectsRecord);
    Integer deleteSubject(Integer id);
}
