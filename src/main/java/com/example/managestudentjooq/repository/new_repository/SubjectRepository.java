package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.model.tables.pojos.Subjects;
import com.example.managestudentjooq.model.tables.records.SubjectsRecord;
import org.jooq.impl.TableImpl;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.example.managestudentjooq.model.tables.Subjects.SUBJECTS;

@Repository
public class SubjectRepository extends AbsRepository<SubjectsRecord, Subjects,Integer>{

    @Override
    protected TableImpl<SubjectsRecord> getTable() {
        return SUBJECTS;
    }


}
