package com.example.managestudentjooq.service.new_service;

import com.example.managestudentjooq.dto.paging.Page;
import com.example.managestudentjooq.dto.request.SearchRequest;
import com.example.managestudentjooq.mapper.new_mappper.BaseMapper;
import com.example.managestudentjooq.repository.new_repository.AbsRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbsService<Rq, Rp, Po, ID, Repo extends AbsRepository<?, Po, ID>,
       Mp extends BaseMapper<Rq, Rp, Po>> {

    protected Mp mapper;
    protected Repo repository;

    public Rp insert(Rq request) {
        Po pojo = mapper.toPOJO(request);
        Optional<Po> insertedOptionalPojo = repository.insertReturning(pojo);

        if (insertedOptionalPojo.isPresent()) {
            return mapper.toResponse(insertedOptionalPojo.get());
        } else {
            throw new RuntimeException("Failed to insert record");
        }
    }

    public Rp update(ID id, Rq rq){
        Po pojo = mapper.toPOJO(rq);
        Integer updated = repository.update(id, pojo);
        if (updated > 0) {
            Optional<Po> updatedPojo = repository.findById(id);
                return mapper.toResponse(updatedPojo.get());
        } else {
            throw new RuntimeException("Failed to update record");
        }
    }

    public Rp delete(ID id){
        Integer updated = repository.deleteById(id);
        if (updated > 0) {
            Optional<Po> updatedPojo = repository.findById(id);
            return mapper.toResponse(updatedPojo.get());
        } else {
            throw new RuntimeException("Failed to delete record");
        }
    }

    public Page<Rp> search(SearchRequest searchRequest) {
        List<Po> pojos = repository.getAll(searchRequest);
        Long total = repository.count(searchRequest);
        List<Rp> responses = mapper.toResponses(pojos);
        return new Page<Rp>()
                .setTotal(total)
                .setItems(responses)
                .setKey(searchRequest.getKeyword())
                .setPage(searchRequest.getPage());
    }
}
