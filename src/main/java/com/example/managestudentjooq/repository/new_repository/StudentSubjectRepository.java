package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.model.tables.pojos.Subjects;
import com.example.managestudentjooq.model.tables.pojos.StudentSubject;
import com.example.managestudentjooq.model.tables.records.StudentSubjectRecord;
import org.jooq.Field;
import org.jooq.impl.TableImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.example.managestudentjooq.model.tables.StudentSubject.STUDENT_SUBJECT;
import static com.example.managestudentjooq.model.Tables.*;

@Repository
public class StudentSubjectRepository extends AbsRepository<StudentSubjectRecord, StudentSubject, Integer>{

    @Override
    protected TableImpl<StudentSubjectRecord> getTable() {
        return STUDENT_SUBJECT;
    }

    public List<StudentSubject> getByStudentIds(List<Integer> studentIds){
        return dslContext.selectFrom(STUDENT_SUBJECT)
                .where(STUDENT_SUBJECT.STUDENT_ID.in(studentIds))
                .fetchInto(StudentSubject.class);
    }

    public Map<Integer, Subjects> getSubjectByStudentUserIds(List<Integer> studentIds){
        return dslContext.select(SUBJECTS.ID, SUBJECTS.NAME, SUBJECTS.DESCRIPTION, SUBJECTS.STATUS)
                .from(SUBJECTS)
                .join(STUDENT_SUBJECT)
                .on(SUBJECTS.ID.eq(STUDENT_SUBJECT.ID))
                .join(STUDENTS)
                .on(STUDENT_SUBJECT.STUDENT_ID.eq(STUDENTS.ID))
                .where(STUDENTS.ID.in(studentIds))
                .fetchMap(SUBJECTS.ID, Subjects.class);
    }
}
