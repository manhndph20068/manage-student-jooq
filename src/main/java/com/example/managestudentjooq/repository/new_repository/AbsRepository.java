package com.example.managestudentjooq.repository.new_repository;

import com.example.managestudentjooq.dto.request.SearchRequest;
import com.example.managestudentjooq.repository.new_repository.utils.MysqlUtil;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.jooq.DSLContext;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.impl.TableRecordImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbsRepository<R extends TableRecordImpl<R>, P, ID> implements IBaseRepository<P, ID> {

    @Autowired
    protected DSLContext dslContext;
    protected R record;
    private Class<P> pojoClass;
    protected TableField<R, ID> fieldID;

    protected abstract TableImpl<R> getTable();

    @SneakyThrows
    @PostConstruct
    public void init() {
        this.record = ((Class<R>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0])
                .getDeclaredConstructor()
                .newInstance();
        this.pojoClass = ((Class<P>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1]);
        this.fieldID = (TableField<R, ID>) Arrays.stream(getTable().fields())
                .filter(field -> field.getName().equalsIgnoreCase("id"))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer insert(P pojo) {
        return dslContext.insertInto(getTable())
                .set(MysqlUtil.toInsertQueries(record,pojo))
                .execute();
    }

    @Override
    public Optional<P> insertReturning(P pojo) {
        return Optional.of(dslContext.insertInto(getTable())
                .set(MysqlUtil.toInsertQueries(record, pojo))
                .returning()
                .fetchOne()
                .into(pojoClass));
    }

    @Override
    public Integer update(ID id, P pojo) {
        if (fieldID != null)
        return dslContext.update(getTable())
                .set(MysqlUtil.toInsertQueries(record, pojo))
                .where(fieldID.eq(id))
                .execute();
        return 0;
    }

    @Override
    public Optional<P> findById(ID id) {
        return Optional.of(dslContext.selectFrom(getTable())
                .where(fieldID.eq(id))
                .fetchOneInto(pojoClass));
    }

    @Override
    public Integer deleteById(ID id) {
        if (fieldID != null)
            return dslContext.update(getTable())
                    .set(DSL.field("status"), 1)
                    .where(fieldID.eq(id))
                    .execute();
        return 0;
    }

    public List<P> getAll(SearchRequest searchRequest) {
        return dslContext.selectFrom(getTable())
                .where(MysqlUtil.buildSearchQueries(getTable(), searchRequest.getKeyword()))
                .orderBy(MysqlUtil.toSortField(searchRequest.getSorts(), getTable().fields()))
                .offset(searchRequest.getOffset())
                .limit(searchRequest.getPageSize())
                .fetchInto(pojoClass);
    }

    public Long count(SearchRequest searchRequest) {
        return dslContext
                .selectCount()
                .from(getTable())
                .where(MysqlUtil.buildSearchQueries(getTable(), searchRequest.getKeyword()))
                .fetchOneInto(Long.class);
    }


}
