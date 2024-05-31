package com.example.managestudentjooq.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPaginationRequest {
    private Integer page;
    private Integer pageSize;
    private String nameSearch;
    private Integer age;
    private Integer gender;
}
