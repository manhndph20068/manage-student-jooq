package com.example.managestudentjooq.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentReqest {
    private Integer id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Min(value = 3, message = "age must be greater than 3")
    @NotNull(message = "age is required")
    private Integer age;

    @NotNull(message = "gender is required")
    private Integer gender;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private Integer status;

}
