package com.example.managestudentjooq.service.new_service;

import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.dto.response.StudentResponse;
import com.example.managestudentjooq.mapper.old.StudentMapper;
import com.example.managestudentjooq.model.tables.pojos.Students;
import com.example.managestudentjooq.repository.new_repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends AbsService<StudentReqest, StudentResponse, Students, Integer,
        StudentRepository, StudentMapper>{

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

//    @Override
//    public Page<StudentResponse> search(SearchRequest searchRequest) {
//        List<Students> students =  repository.getAll(searchRequest);
//        List<Integer> idStudents = extractField(students, Students::getId);
//
//        return super.search(searchRequest);
//    }
}
