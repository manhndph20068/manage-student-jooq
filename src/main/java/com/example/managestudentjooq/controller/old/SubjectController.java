//package com.example.managestudentjooq.controller.old;
//
//import com.example.managestudentjooq.ServiceResult;
//import com.example.managestudentjooq.dto.request.SubjectRequest;
//import com.example.managestudentjooq.dto.response.SubjectResponse;
//import com.example.managestudentjooq.service.old.SubjectService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/subject")
//public class SubjectController {
//
//    @Autowired
//    private SubjectService subjectService;
//
//    @GetMapping("/getAllSubject")
//    ResponseEntity<ServiceResult<List<SubjectResponse>>> findAll() {
//        return ResponseEntity.ok(subjectService.findAll());
//    }
//
//    @PostMapping("/findSubjectByID")
//    ResponseEntity<ServiceResult<SubjectResponse>> findByID(Integer id) {
//        return ResponseEntity.ok(subjectService.findById(id));
//    }
//
//    @PostMapping("/addNewSubject")
//    ResponseEntity<ServiceResult<SubjectResponse>> addNewSubject(@RequestBody SubjectRequest subjectRequest) {
//        return ResponseEntity.ok(subjectService.addSubject(subjectRequest));
//    }
//
//    @PostMapping("/updateSubject")
//    ResponseEntity<ServiceResult<SubjectResponse>> updateSubject(@Valid @RequestBody SubjectRequest subjectRequest
//            , BindingResult result) {
//        return ResponseEntity.ok(subjectService.updateSubject(subjectRequest,result));
//    }
//
//    @PostMapping("/deleteSubject")
//    ResponseEntity<ServiceResult<String>> deleteSubject(@RequestBody SubjectRequest subjectRequest) {
//        return ResponseEntity.ok(subjectService.deleteSubject(subjectRequest.getId()));
//    }
//}
