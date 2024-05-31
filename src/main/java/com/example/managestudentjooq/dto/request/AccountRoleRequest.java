package com.example.managestudentjooq.dto.request;

import com.example.managestudentjooq.dto.response.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRoleRequest {
    private Integer id;
    private String username;
    private RoleResponse roleResponse;
}
