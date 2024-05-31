//package com.example.managestudentjooq.controller.old;
//
//import com.example.managestudentjooq.ServiceResult;
//import com.example.managestudentjooq.dto.request.StudentPaginationRequest;
//import com.example.managestudentjooq.dto.request.StudentReqest;
//import com.example.managestudentjooq.dto.response.StudentPaginationResponse;
//import com.example.managestudentjooq.dto.response.StudentResponse;
//import com.example.managestudentjooq.service.old.StudentService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
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
//@RequestMapping("api/v1/student")
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping("/getAllStudents")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//    ResponseEntity<List<StudentResponse>> findAll() {
//        return ResponseEntity.ok(studentService.findAll());
//    }
//
//    @PostMapping("/findByID")
//    ResponseEntity<StudentResponse> findByID(@RequestBody StudentResponse studentResponse) {
//        return ResponseEntity.ok(studentService.findById(studentResponse.getId()));
//    }
//
//    @PostMapping("/addNewStudent")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    ResponseEntity<StudentResponse> addStudent(@RequestBody StudentReqest studentReqest) {
//        return ResponseEntity.ok(studentService.addStudent(studentReqest));
//    }
//
//    @PostMapping("/updateStudent")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    ResponseEntity<ServiceResult<StudentResponse>> updateStudent(@Valid @RequestBody StudentReqest studentReqest
//            , BindingResult result) {
//        return ResponseEntity.ok(studentService.updateStudent(studentReqest,result));
//    }
//
//    @PostMapping("/deleteStudent")
//    ResponseEntity<ServiceResult<String>> deleteStudent(@RequestBody StudentReqest studentReqest) {
//        return ResponseEntity.ok(studentService.deleteStudent(studentReqest.getId()));
//    }
//
//    @PostMapping("/getAllStudentsWithPagination")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    ResponseEntity<ServiceResult<StudentPaginationResponse>> findAllWithPagination(@RequestBody StudentPaginationRequest studentPaginationRequest) {
//        return ResponseEntity.ok( studentService.
//                findAllWithPagination(
//                        studentPaginationRequest.getPage(),
//                        studentPaginationRequest.getPageSize(),
//                        studentPaginationRequest.getNameSearch(),
//                        studentPaginationRequest.getAge(),
//                        studentPaginationRequest.getGender()
//                )
//        );
//    }
//}
