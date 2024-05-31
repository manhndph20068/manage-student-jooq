package com.example.managestudentjooq.mapper.new_mappper;

import com.example.managestudentjooq.dto.request.new_req.StudentSubjectRequest;
import com.example.managestudentjooq.dto.response.new_res.StudentSubjectResponse;
import com.example.managestudentjooq.model.tables.pojos.StudentSubject;
import com.example.managestudentjooq.model.tables.pojos.Students;
import com.example.managestudentjooq.model.tables.pojos.Subjects;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper
public abstract class StudentSubjectMapper extends BaseMapper<StudentSubjectRequest,
        StudentSubjectResponse, StudentSubject>{

    @Autowired
    private SubjectsMapper subjectsMapper;

    public abstract StudentSubjectResponse toResponse(Students students, @Context List<Subjects> subjects);

    @AfterMapping
    protected void afterResponse(@MappingTarget StudentSubjectResponse studentSubjectResponse, @Context List<Subjects> subjects){
        studentSubjectResponse.setSubjectsResponses(subjectsMapper.toResponses(subjects));
    }

    public List<StudentSubjectResponse> toResponses(List<Students> students,
                                                     List<StudentSubject> studentSubjects,
                                                     Map<Integer, Subjects> subjectsMap){

        Map<Integer, List<Subjects>> studentSubjectMap = studentSubjects.stream()
                .filter(studentSubject -> subjectsMap.containsKey(studentSubject.getSubjectId()))
                .collect(
                        Collectors.groupingBy(
                            StudentSubject::getStudentId,
                                Collectors.mapping(
                                        studentSubject -> subjectsMap.get(studentSubject.getSubjectId()),
                                        Collectors.toList()
                                )
                        )
                );
//  truoc mapping      {
//            1: [StudentSubject(1, 101), StudentSubject(1, 102)],
//            2: [StudentSubject(2, 103)],
//            3: [StudentSubject(3, 101)]
//        }
 //       {
//            1: [Subject(101, eng), Subject(102, math)],
//            2: [Subject(103, phy)],
//            3: [Subject(101, eng)]
//        }
        return students.stream()
                .map(st -> toResponse(st, studentSubjectMap.getOrDefault(st.getId(), new ArrayList<>())))
                .collect(Collectors.toList());
    }


}
