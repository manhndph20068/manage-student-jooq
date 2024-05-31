package com.example.managestudentjooq.mapper.new_mappper;

import com.example.managestudentjooq.dto.request.RoleRequest;
import com.example.managestudentjooq.dto.response.RoleResponse;
import com.example.managestudentjooq.model.tables.pojos.Role;
import org.mapstruct.Mapper;

@Mapper
public abstract class RoleMapper extends BaseMapper<RoleRequest, RoleResponse, Role>{


}
