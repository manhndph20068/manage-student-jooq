package com.example.managestudentjooq.service.old.impl;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.config.AppConstant;
import com.example.managestudentjooq.dto.request.SubjectRequest;
import com.example.managestudentjooq.dto.response.SubjectResponse;
import com.example.managestudentjooq.exception.DataNotFoundException;
import com.example.managestudentjooq.mapper.old.SubjectMapper;
import com.example.managestudentjooq.model.tables.records.SubjectsRecord;
import com.example.managestudentjooq.repository.old.SubjectRepository;
import com.example.managestudentjooq.service.old.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.sql.SQLException;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public ServiceResult<List<SubjectResponse>> findAll() {
        List<SubjectsRecord> subjectsRecord = subjectRepository.findAll();
        return new ServiceResult<>(
                AppConstant.SUCCESS,
                "success",
                subjectMapper.toListSubjectResponse(subjectsRecord)
        );
    }

    @Override
    public ServiceResult<SubjectResponse> findById(Integer id) {
        SubjectsRecord subjectsRecord = subjectRepository.findById(id);
        return new ServiceResult<>(
                AppConstant.SUCCESS,
                "success",
                subjectMapper.toSubjectResponse(subjectsRecord)
        );
    }

    @Override
    public ServiceResult<SubjectResponse> addSubject(SubjectRequest subjectRequest) {
        SubjectsRecord subjectsRecord = subjectRepository.addSubject(subjectMapper.toSubjectsRecord(subjectRequest));
        return new ServiceResult<>(
                AppConstant.SUCCESS,
                "success",
                subjectMapper.toSubjectResponse(subjectsRecord)
        );
    }

    @Override
    public ServiceResult<SubjectResponse> updateSubject(SubjectRequest subjectRequest, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getAllErrors().stream()
                        .map(error -> error.getDefaultMessage())
                        .toList();
                String errorsMessage = String.join(", ", errors);
                throw new DataNotFoundException(errorsMessage);
            }else {
                SubjectsRecord subjectsRecord = subjectRepository.findById(subjectRequest.getId());
                if (subjectsRecord == null) {
                    throw new DataNotFoundException("Subjects not found");
                }

                SubjectsRecord subjectsRecordUpdate = subjectRepository
                        .updateSubject(subjectMapper.toSubjectsRecord(subjectRequest));
                if (subjectsRecordUpdate == null) {
                    throw new SQLException("SQl error");
                }

                return new ServiceResult<>(
                        AppConstant.SUCCESS, "Update student success",
                        subjectMapper.toSubjectResponse(subjectsRecordUpdate)
                );
            }
        } catch (Exception e) {
            return new ServiceResult<>(
                    AppConstant.BAD_REQUEST, e.getMessage(), null
            );
        }
    }

    @Override
    public ServiceResult<String> deleteSubject(Integer id) {
        try {
            SubjectsRecord subjectsRecord = subjectRepository.findById(id);
            if (subjectsRecord == null) {
                throw new DataNotFoundException("Subject not found");
            }
            Integer result = subjectRepository.deleteSubject(id);
            if (result == 1) {
                return new ServiceResult<>(
                        AppConstant.SUCCESS, "Delete subject success", null
                );
            }else {
                throw new SQLException("Sql error");
            }
        }catch (Exception e){
            return new ServiceResult<>(
                    AppConstant.BAD_REQUEST, e.getMessage(), null
            );
        }
    }

}
