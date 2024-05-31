package com.example.managestudentjooq.service.old;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.dto.request.SubjectRequest;
import com.example.managestudentjooq.dto.response.StudentResponse;
import com.example.managestudentjooq.dto.response.SubjectResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface SubjectService {
    ServiceResult<List<SubjectResponse>> findAll();
    ServiceResult<SubjectResponse> findById(Integer id);
    ServiceResult<SubjectResponse> addSubject(SubjectRequest subjectRequest);
    ServiceResult<SubjectResponse> updateSubject(SubjectRequest subjectRequestt, BindingResult bindingResult);
    ServiceResult<String> deleteSubject(Integer id);
}
