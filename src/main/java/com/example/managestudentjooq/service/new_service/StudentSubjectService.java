package com.example.managestudentjooq.service.new_service;

import com.example.managestudentjooq.dto.paging.Page;
import com.example.managestudentjooq.dto.request.SearchRequest;
import com.example.managestudentjooq.dto.request.new_req.StudentSubjectRequest;
import com.example.managestudentjooq.dto.response.new_res.StudentSubjectResponse;
import com.example.managestudentjooq.mapper.new_mappper.StudentSubjectMapper;
import com.example.managestudentjooq.model.tables.pojos.StudentSubject;
import com.example.managestudentjooq.model.tables.pojos.Students;
import com.example.managestudentjooq.model.tables.pojos.Subjects;
import com.example.managestudentjooq.repository.new_repository.StudentRepository;
import com.example.managestudentjooq.repository.new_repository.StudentSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.example.managestudentjooq.utils.CollectionUtils.extractField;

@Service
public class StudentSubjectService extends AbsService<StudentSubjectRequest, StudentSubjectResponse, StudentSubject, Integer,
        StudentSubjectRepository, StudentSubjectMapper>{

    public StudentSubjectService(StudentSubjectRepository repository,
                                 StudentSubjectMapper mapper){
        this.mapper = mapper;
        this.repository = repository;
    }

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    @Override
    public Page<StudentSubjectResponse> search(SearchRequest searchRequest) {
        List<Students> students =  studentRepository.getAll(searchRequest);
        List<Integer> idStudents = extractField(students, Students::getId);
        Long count = studentRepository.count(searchRequest);
        List<StudentSubject> studentSubjects = studentSubjectRepository.getByStudentIds(idStudents);
        Map<Integer, Subjects> subjectMap = studentSubjectRepository.getSubjectByStudentUserIds(idStudents);

        List<StudentSubjectResponse> subjectResponses = mapper.toResponses(students, studentSubjects, subjectMap);
        return new Page<StudentSubjectResponse>()
                .setTotal(count)
                .setItems(subjectResponses)
                .setPage(searchRequest.getPage())
                .setKey(searchRequest.getKeyword());
    }
}
