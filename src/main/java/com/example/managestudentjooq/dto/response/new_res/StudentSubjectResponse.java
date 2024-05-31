package com.example.managestudentjooq.dto.response.new_res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentSubjectResponse {
    private Integer id;
    private String fullName;
    private Integer age;
    private Integer gender;
    private List<SubjectsResponse> subjectsResponses;
}
