package com.example.managestudentjooq.mapper.old;

import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.dto.response.StudentPaginationResponse;
import com.example.managestudentjooq.dto.response.StudentResponse;
import com.example.managestudentjooq.mapper.new_mappper.BaseMapper;
import com.example.managestudentjooq.model.tables.pojos.Students;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class StudentMapper extends BaseMapper<StudentReqest, StudentResponse, Students> {


//    public abstract StudentResponse toStudentResponse (Students students);
//
//    public List<StudentResponse> toListStudentResponse(List<Students> students){
//        return students.stream()
//                .map(this::toStudentResponse)
//                .collect(Collectors.toList());
//    }
//
//    public abstract Students toStudentsByStudentReqest(StudentReqest studentReqest);
//
//    @AfterMapping
//    void initFields(@MappingTarget Students students) {
//        students.setCreateAt(LocalDateTime.now());
//        students.setUpdatedAt(LocalDateTime.now());
//        students.setStatus(0);
//    }
//
//
//    public StudentPaginationResponse toStudentPaginationResponse(List<Students> students, Integer currentPage, Integer pageSize, Integer totalRecord) {
//        StudentPaginationResponse paginationResponse = new StudentPaginationResponse();
//        paginationResponse.setCurrentPage(currentPage);
//        paginationResponse.setPageSize(pageSize);
//        paginationResponse.setTotalRecord(totalRecord);
//        paginationResponse.setTotalPage((int) Math.ceil((double) totalRecord / pageSize));
//        List<StudentResponse> studentResponses = toListStudentResponse(students);
//        paginationResponse.setStudentResponses(studentResponses);
//        return paginationResponse;
//    }

}
