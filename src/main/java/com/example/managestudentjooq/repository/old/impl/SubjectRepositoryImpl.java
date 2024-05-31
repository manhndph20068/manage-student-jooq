package com.example.managestudentjooq.repository.old.impl;

import com.example.managestudentjooq.model.tables.records.SubjectsRecord;
import com.example.managestudentjooq.repository.old.SubjectRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.managestudentjooq.model.tables.Subjects.SUBJECTS;
import static org.jooq.impl.DSL.currentLocalDateTime;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<SubjectsRecord> findAll() {
        return dslContext.selectFrom(SUBJECTS).fetch();
    }

    @Override
    public SubjectsRecord findById(Integer id) {
        return dslContext.selectFrom(SUBJECTS)
                .where(SUBJECTS.ID.eq(id))
                .fetchOne();
    }

    @Override
    public SubjectsRecord addSubject(SubjectsRecord subjectsRecord) {
        return dslContext.insertInto(SUBJECTS)
                .set(SUBJECTS.NAME, subjectsRecord.getName())
                .set(SUBJECTS.DESCRIPTION, subjectsRecord.getDescription())
                .set(SUBJECTS.STATUS, subjectsRecord.getStatus())
                .set(SUBJECTS.CREATE_AT, currentLocalDateTime())
                .set(SUBJECTS.UPDATED_AT, currentLocalDateTime())
                .returning()
                .fetchOne();
    }

    @Override
    public SubjectsRecord updateSubject(SubjectsRecord subjectsRecord) {
        return dslContext.update(SUBJECTS)
                .set(SUBJECTS.NAME, subjectsRecord.getName())
                .set(SUBJECTS.DESCRIPTION, subjectsRecord.getDescription())
                .set(SUBJECTS.STATUS, subjectsRecord.getStatus())
                .set(SUBJECTS.UPDATED_AT, currentLocalDateTime())
                .where(SUBJECTS.ID.eq(subjectsRecord.getId()))
                .execute() > 0 ? dslContext.selectFrom(SUBJECTS)
                .where(SUBJECTS.ID.eq(subjectsRecord.getId())).fetchOne() : null;
    }

    @Override
    public Integer deleteSubject(Integer id) {
        return dslContext.deleteFrom(SUBJECTS)
                .where(SUBJECTS.ID.eq(id))
                .execute();
    }
}
