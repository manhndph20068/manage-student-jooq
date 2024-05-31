package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.dto.request.SearchRequest;

import java.util.List;
import java.util.Optional;

public interface IBaseRepository<P, ID>{

    Integer insert(P pojo);

    Optional<P> insertReturning(P pojo);

    Integer update(ID id, P pojo);

    Optional<P> findById(ID id);

    Integer deleteById(ID id);

}
