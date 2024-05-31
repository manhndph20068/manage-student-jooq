package com.example.managestudentjooq.repository.old;

import com.example.managestudentjooq.model.tables.pojos.Students;
import com.example.managestudentjooq.model.tables.records.StudentsRecord;

import java.util.List;

public interface StudentRepository {
    List<Students> findAll();
    Students findById(Integer id);
    Students addStudent(Students student);
    Students updateStudent(Students student);
    Integer deleteStudent(Integer id);
    List<Students> findAllWithPagination(int page, int pageSize, String nameSearch, Integer age, Integer gender);
    Integer countTotalRecordStudent(int page, int pageSize, String nameSearch, Integer age, Integer gender);
}
