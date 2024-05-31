package com.example.managestudentjooq.service.old;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.dto.response.StudentPaginationResponse;
import com.example.managestudentjooq.dto.response.StudentResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();
    StudentResponse findById(Integer id);
    StudentResponse addStudent(StudentReqest studentReqest);
    ServiceResult<StudentResponse> updateStudent(StudentReqest studentReqest, BindingResult bindingResult);
    ServiceResult<String> deleteStudent(Integer id);
    ServiceResult<StudentPaginationResponse> findAllWithPagination(int page, int pageSize, String nameSearch, Integer age, Integer gender);
}
