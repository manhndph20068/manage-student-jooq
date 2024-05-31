package com.example.managestudentjooq.repository.old;

import com.example.managestudentjooq.model.tables.pojos.StudentSubject ;

import java.util.List;

public interface StudentSubjectRepository {
    List<StudentSubject> findAllWithPagination();
//    StudentSubject findById(Integer id);
}
