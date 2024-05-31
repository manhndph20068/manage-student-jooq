package com.example.managestudentjooq.mapper.old;

import com.example.managestudentjooq.dto.request.SubjectRequest;
import com.example.managestudentjooq.dto.response.SubjectResponse;
import com.example.managestudentjooq.model.tables.records.SubjectsRecord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class SubjectMapper {
    public abstract SubjectResponse toSubjectResponse(SubjectsRecord subjectsRecord);

    public abstract List<SubjectResponse> toListSubjectResponse(List<SubjectsRecord> subjectsRecords);

    public abstract SubjectsRecord toSubjectsRecord(SubjectRequest subjectRequest);
}
