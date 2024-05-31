//package com.example.managestudentjooq.service.old.impl;
//
//import com.example.managestudentjooq.ServiceResult;
//import com.example.managestudentjooq.config.AppConstant;
//import com.example.managestudentjooq.dto.request.StudentReqest;
//import com.example.managestudentjooq.dto.response.StudentPaginationResponse;
//import com.example.managestudentjooq.dto.response.StudentResponse;
//import com.example.managestudentjooq.exception.DataNotFoundException;
//import com.example.managestudentjooq.mapper.old.StudentMapper;
//import com.example.managestudentjooq.model.tables.pojos.Students;
//import com.example.managestudentjooq.repository.old.StudentRepository;
//import com.example.managestudentjooq.service.old.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@Service
//public class StudentServiceImpl implements StudentService {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//    @Override
//    public List<StudentResponse> findAll() {
//        List<Students> studentRecords = studentRepository.findAll();
//        return studentMapper.toListStudentResponse(studentRecords);
//    }
//
//    @Override
//    public StudentResponse findById(Integer id) {
//        return null;
////        StudentsRecord studentRecord = studentRepository.findById(id);
////        return studentMapper.toStudentResponse(studentRecord);
//    }
//
//    @Override
//    public StudentResponse addStudent(StudentReqest studentReqest) {
//        Students students = studentRepository
//                .addStudent(studentMapper.toStudentsByStudentReqest(studentReqest));
//        return studentMapper.toStudentResponse(students);
//    }
//
//    @Override
//    public ServiceResult<StudentResponse> updateStudent(StudentReqest studentReqest, BindingResult bindingResult) {
//        try {
//            if (bindingResult.hasErrors()) {
//                List<String> errors = bindingResult.getAllErrors().stream()
//                        .map(error -> error.getDefaultMessage())
//                        .toList();
//                String errorsMessage = String.join(", ", errors);
//                throw new DataNotFoundException(errorsMessage);
//            }else {
//                Students student = studentRepository.findById(studentReqest.getId());
//                if (student == null) {
//                    throw new DataNotFoundException("Student not found");
//                }
//
//                studentRepository
//                        .updateStudent(studentMapper.toStudentsByStudentReqest(studentReqest));
//                Students studentRecord = studentRepository.findById(studentReqest.getId());
//                return new ServiceResult<>(
//                        AppConstant.SUCCESS, "Update student success",
//                        studentMapper.toStudentResponse(studentRecord)
//                );
//            }
//        } catch (Exception e) {
//            return new ServiceResult<>(
//                    AppConstant.BAD_REQUEST, e.getMessage(), null
//            );
//        }
//    }
//
//    @Override
//    public ServiceResult<String> deleteStudent(Integer id) {
//        try {
//            Students student = studentRepository.findById(id);
//            if (student == null) {
//                throw new DataNotFoundException("Student not found");
//            }
//            Integer result = studentRepository.deleteStudent(id);
//            if (result == 1) {
//                return new ServiceResult<>(
//                        AppConstant.SUCCESS, "Delete student success", null
//                );
//            }else {
//                throw new SQLException("Sql error");
//            }
//        }catch (Exception e){
//            return new ServiceResult<>(
//                    AppConstant.BAD_REQUEST, e.getMessage(), null
//            );
//        }
//    }
//
//    @Override
//    public ServiceResult<StudentPaginationResponse> findAllWithPagination(int page, int pageSize, String nameSearch,
//                                                                          Integer age, Integer gender) {
//        List<Students> students =
//                studentRepository.findAllWithPagination(page, pageSize, nameSearch, age, gender);
//        return new ServiceResult<>(
//                AppConstant.SUCCESS,
//                "Get student success",
//                studentMapper.toStudentPaginationResponse(students
//                        , page, pageSize, studentRepository.countTotalRecordStudent(page, pageSize, nameSearch, age, gender))
//        );
//    }
//}
