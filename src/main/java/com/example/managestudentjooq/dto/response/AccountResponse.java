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
public class AccountResponse {
    private Integer id;
    private String userName;
    private String password;
    private String role;
    private Integer status;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
