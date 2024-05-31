package com.example.managestudentjooq.repository.old.impl;

import com.example.managestudentjooq.model.tables.pojos.Students;
import com.example.managestudentjooq.model.tables.records.StudentsRecord;
import com.example.managestudentjooq.repository.old.StudentRepository;
import org.jooq.DSLContext;
import org.jooq.SelectWhereStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.managestudentjooq.model.tables.Students.STUDENTS;
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<Students> findAll() {
        return dslContext.selectFrom(STUDENTS)
                .fetchInto(Students.class);
    }

    @Override
    public Students findById(Integer id) {
        return dslContext.selectFrom(STUDENTS)
                .where(STUDENTS.ID.eq(id))
                .fetchOne()
                .into(Students.class);
    }

    @Override
    public Students addStudent(Students student) {
        return dslContext.insertInto(STUDENTS)
                .set(dslContext.newRecord(STUDENTS, student))
                .returning()
                .fetchOne()
                .into(Students.class);
//        return dslContext.insertInto(STUDENTS)
//                .set(STUDENTS.FULL_NAME, student.getFullName())
//                .set(STUDENTS.AGE, student.getAge())
//                .set(STUDENTS.GENDER, student.getGender())
//                .set(STUDENTS.CREATE_AT, currentLocalDateTime())
//                .set(STUDENTS.UPDATED_AT, currentLocalDateTime())
//                .set(STUDENTS.STATUS, 0)
//                .returning()
//                .fetchOne()
//                .into(Students.class);
    }

    @Override
    public Students updateStudent(Students student) {
        StudentsRecord oldRecord = dslContext.selectFrom(STUDENTS)
                .where(STUDENTS.ID.eq(student.getId()))
                .fetchOne();
        return dslContext.update(STUDENTS)
                .set(STUDENTS.FULL_NAME, student.getFullName())
                .set(STUDENTS.AGE, student.getAge())
                .set(STUDENTS.GENDER, student.getGender())
                .set(STUDENTS.UPDATED_AT, oldRecord.getUpdatedAt())
                .set(STUDENTS.STATUS, oldRecord.getStatus())
                .where(STUDENTS.ID.eq(student.getId()))
                .execute() == 1 ? student : null;
//        return dslContext.update(STUDENTS)
//                .set(dslContext.newRecord(STUDENTS, student))
//                .set(STUDENTS.UPDATED_AT, oldRecord.getUpdatedAt())
//                .set(STUDENTS.STATUS, oldRecord.getStatus())
//                .where(STUDENTS.ID.eq(student.getId()))
//                .returning()
//                .fetchOne()
//                .into(Students.class);
    }

    @Override
    public Integer deleteStudent(Integer id) {
        return dslContext.update(STUDENTS)
                .set(STUDENTS.STATUS, 1)
                .where(STUDENTS.ID.eq(id))
                .execute();
    }

    @Override
    public List<Students> findAllWithPagination(int page, int pageSize, String nameSearch, Integer age, Integer gender) {
        int seek = (page - 1) * pageSize;

        SelectWhereStep<StudentsRecord> query = dslContext.selectFrom(STUDENTS);

        if (nameSearch != null && !nameSearch.trim().isEmpty()) {
            query.where(STUDENTS.FULL_NAME.like("%" + nameSearch + "%"));
        }

        if (age != null) {
            query.where(STUDENTS.AGE.eq(age));
        }

        if (gender != null) {
            query.where(STUDENTS.GENDER.eq(gender));
        }

        return query
                .orderBy(STUDENTS.ID.asc())
                .seek(seek)
                .limit(pageSize)
                .fetchInto(Students.class);
    }

    @Override
    public Integer countTotalRecordStudent(int page, int pageSize, String nameSearch, Integer age, Integer gender) {
        SelectWhereStep<StudentsRecord> query = dslContext.selectFrom(STUDENTS);

        if (nameSearch != null && !nameSearch.trim().isEmpty()) {
            query.where(STUDENTS.FULL_NAME.like("%" + nameSearch + "%"));
        }

        if (age != null) {
            query.where(STUDENTS.AGE.eq(age));
        }

        if (gender != null) {
            query.where(STUDENTS.GENDER.eq(gender));
        }

        return dslContext.fetchCount(query);
    }

}
