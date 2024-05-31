package com.example.managestudentjooq.repository.new_repository.utils;

import com.example.managestudentjooq.dto.paging.Filter;
import com.example.managestudentjooq.dto.paging.Order;
//import com.example.managestudentjooq.utils.json.JsonArray;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SortField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.impl.TableRecordImpl;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.managestudentjooq.dto.query.Operator.NIN;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static com.example.managestudentjooq.dto.query.Operator.IN;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class MysqlUtil {

    public static <T extends TableRecordImpl<T>> Map<Field<?>, Object>
    toInsertQueries(T record, Object o) {
        record.from(o);
        return Arrays.stream(record.fields())
                .filter(f -> record.getValue(f) != null)
                .collect(Collectors.toMap(f -> f, record::getValue));
    }

    public static List<SortField<Object>> toSortField(List<Order> orderProperties, Field<?>[] fields) {
        if (CollectionUtils.isEmpty(orderProperties)) return new ArrayList<>();
        Set<String> fieldNames = Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.toSet());
        return orderProperties
                .stream()
                .filter(order -> fieldNames.contains(order.getProperty()))
                .map(order -> {
                    if (order.getDirection().equals(Order.Direction.asc.name()))
                        return DSL.field(order.getProperty()).asc();
                    else return DSL.field(order.getProperty()).desc();
                })
                .collect(Collectors.toList());
        //ket qua [DSL.field("name").asc(), DSL.field("age").desc()]
    }

    public static <R extends Record> Condition buildSearchQueries(TableImpl<R> table, String keyword) {
        if (isEmpty(keyword)) return DSL.noCondition();
        final Condition[] condition = {DSL.noCondition()};
        Arrays.stream(table.fields())
                .filter(field -> String.class.isAssignableFrom(field.getType())
                        || Long.class.isAssignableFrom(field.getType())
                        || Integer.class.isAssignableFrom(field.getType())
                )
                .forEach(field -> condition[0] = condition[0].or(field.likeRegex(keyword)));
        return condition[0];
//        ("manage_students"."students"."id" like_regex 's')
//        or ("manage_students"."students"."full_name" like_regex 's')
    }

//    public static <R extends Record> Condition buildFilterQueries(TableImpl<R> table, List<Filter> fieldFilters) {
//        if (isEmpty(fieldFilters)) return DSL.noCondition();
//        final Condition[] condition = {DSL.noCondition()};
//        fieldFilters
//                .forEach(fieldFilter -> {
//                    final Field field = table.field(fieldFilter.getName());
//                    if (field != null) {
//                        final Object valueByClass = castValueByClass(fieldFilter.getOperation(), fieldFilter.getValue(), field.getType());
//                        if (valueByClass != null) {
//                            condition[0] = condition[0].and(buildCondition(fieldFilter.getOperation(), field, valueByClass));
//
//                        } else {
//                            condition[0] = condition[0].and(field.isNull());
//                        }
//                    }
//                });
//        return condition[0];
//    }
}
