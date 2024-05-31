package com.example.managestudentjooq.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class StudentResponse {
    private Integer id;
    private String fullName;
    private Integer age;
    private Integer gender;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private Integer status;
}
