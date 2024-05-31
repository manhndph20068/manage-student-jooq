package com.example.managestudentjooq.mapper.new_mappper;

import com.example.managestudentjooq.dto.request.new_req.SubjectsRquest;
import com.example.managestudentjooq.dto.response.new_res.SubjectsResponse;
import com.example.managestudentjooq.model.tables.pojos.Subjects;
import org.mapstruct.Mapper;

@Mapper
public abstract class SubjectsMapper extends BaseMapper<SubjectsRquest, SubjectsResponse, Subjects>{
}
