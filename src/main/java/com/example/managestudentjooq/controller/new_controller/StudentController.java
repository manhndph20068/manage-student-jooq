package com.example.managestudentjooq.controller.new_controller;

import com.example.managestudentjooq.ServiceResult;
import com.example.managestudentjooq.config.AppConstant;
import com.example.managestudentjooq.dto.paging.Page;
import com.example.managestudentjooq.dto.request.SearchRequest;
import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.dto.response.StudentResponse;
import com.example.managestudentjooq.service.new_service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addNewStudent")
    ResponseEntity<ServiceResult<StudentResponse>> addNew(@RequestBody StudentReqest studentReqest) {
        return ResponseEntity.ok(new ServiceResult<>(AppConstant.SUCCESS,
                "Student insert successfully"
                , studentService.insert(studentReqest)));
    }

    @PostMapping("/search")
    public ResponseEntity<ServiceResult<Page<StudentResponse>>> search(
            @RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok(
                new ServiceResult<>(AppConstant.SUCCESS,
                        "Students fetched successfully"
                        , studentService.search(searchRequest)));

    }

    @PostMapping("/updateStudent")
    public ResponseEntity<ServiceResult<StudentResponse>> update(@RequestBody StudentReqest studentReqest) {
        return ResponseEntity.ok(new ServiceResult<>(
                AppConstant.SUCCESS,
                "update success",
                studentService.update(studentReqest.getId(), studentReqest)
        ));
    }

    @PostMapping("/deleteStudent")
    public ResponseEntity<ServiceResult<StudentResponse>> deleteStudent(@RequestBody StudentReqest studentReqest) {
        return ResponseEntity.ok(new ServiceResult<>(
                AppConstant.SUCCESS,
                "delete succes",
                studentService.delete(studentReqest.getId())
        ));
    }


}
