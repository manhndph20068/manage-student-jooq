//package com.example.managestudentjooq.controller.old;
//
//import com.example.managestudentjooq.service.old.StudentSubjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/studentSubject")
//public class StudentSubjectController {
//
//    @Autowired
//    private StudentSubjectService studentSubjectService;
//
//    @PostMapping("/findById")
//    ResponseEntity<?> findStudentSubject() {
//        return ResponseEntity.ok(studentSubjectService.findById(1));
//    }
//}
