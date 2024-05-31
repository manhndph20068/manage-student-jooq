package com.example.managestudentjooq.dto.request.new_req;

import com.example.managestudentjooq.dto.response.SubjectResponse;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StudentSubjectRequest {
    private Integer id;
    private String fullName;
    private Integer age;
    private Integer gender;
    private List<SubjectResponse> subjectResponses;
}
