package com.example.managestudentjooq.dto.request.new_req;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubjectsRquest {
    private Integer id;
    private String name;
    private String description;
}
