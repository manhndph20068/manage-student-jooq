package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.model.tables.pojos.Role;
import com.example.managestudentjooq.model.tables.records.RoleRecord;
import org.jooq.impl.TableImpl;
import org.springframework.stereotype.Repository;

import static com.example.managestudentjooq.model.tables.Role.ROLE;

@Repository
public class RoleRepository extends AbsRepository<RoleRecord, Role, Integer>{

    @Override
    protected TableImpl<RoleRecord> getTable() {
        return ROLE;
    }

//    public Role findById(Integer Id){
//        return dslContext.selectFrom(ROLE)
//                .where(ROLE.ID.eq(Id))
//                .fetchOneInto(Role.class);
//    }
}
