package com.example.managestudentjooq.mapper.new_mappper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public abstract class BaseMapper<Rq, Rp, Po> {
    @Named("toPOJO")
    public abstract Po toPOJO(Rq request);

    @IterableMapping(qualifiedByName = "toPOJO")
    public abstract List<Po> toPOJOs(List<Rq> requests);

    @Named("toResponse")
    public abstract Rp toResponse(Po pojo);

    @IterableMapping(qualifiedByName = "toResponse")
    public abstract List<Rp> toResponses(List<Po> pojos);
}
