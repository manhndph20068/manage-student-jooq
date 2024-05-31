package com.example.managestudentjooq.repository.old;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Table;

import java.util.List;

public abstract class BaseRepo<T, R extends Record> {

    private final DSLContext dslContext;

    private final Table<R> table;

    protected BaseRepo(DSLContext dslContext, Table<R> table) {
        this.dslContext = dslContext;
        this.table = table;
    }


    public T findById(Integer id, Class<T> clazz){
        return dslContext.selectFrom(table)
                .where(table.field("id", Integer.class).eq(id))
                .fetchOne()
                .into(clazz);
    };

    public T add(T t){
        return null;
    };
    public T update(T t){
        return null;
    };
    public Integer delete(Integer id){
        return null;
    };
    public List<T> findAll(){
        return null;
    };
}
