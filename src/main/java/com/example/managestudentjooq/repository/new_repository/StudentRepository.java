package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.model.tables.pojos.Students;
import com.example.managestudentjooq.model.tables.records.StudentsRecord;
import org.jooq.impl.TableImpl;
import org.springframework.stereotype.Repository;

import static com.example.managestudentjooq.model.tables.Students.STUDENTS;

@Repository
public class StudentRepository extends AbsRepository<StudentsRecord, Students, Integer>{

    @Override
    protected TableImpl<StudentsRecord> getTable() {
        return STUDENTS;
    }
}
