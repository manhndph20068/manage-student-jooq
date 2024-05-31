package com.example.managestudentjooq.controller.new_controller;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.config.AppConstant;
import com.example.managestudentjooq.dto.paging.Page;
import com.example.managestudentjooq.dto.request.SearchRequest;
import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.dto.response.StudentResponse;
import com.example.managestudentjooq.dto.response.new_res.StudentSubjectResponse;
import com.example.managestudentjooq.service.new_service.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/studentSubject")
public class StudentSubjectController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    @PostMapping("/search")
    ResponseEntity<ServiceResult<Page<StudentSubjectResponse>>> search(@RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok( new ServiceResult<>(
                AppConstant.SUCCESS, "Student Subject fetched successfully",
                studentSubjectService.search(searchRequest)
        ) );
    }
}
