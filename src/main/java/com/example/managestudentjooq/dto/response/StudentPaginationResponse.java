package com.example.managestudentjooq.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jooq.Internal;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPaginationResponse {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalRecord;
    private List<StudentResponse> studentResponses;
}
