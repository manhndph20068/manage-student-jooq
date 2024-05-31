/*
 * This file is generated by jOOQ.
 */
package com.example.managestudentjooq.model.tables;


import com.example.managestudentjooq.model.Keys;
import com.example.managestudentjooq.model.ManageStudents;
import com.example.managestudentjooq.model.tables.records.RoleRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Role extends TableImpl<RoleRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>manage_students.role</code>
     */
    public static final Role ROLE = new Role();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoleRecord> getRecordType() {
        return RoleRecord.class;
    }

    /**
     * The column <code>manage_students.role.id</code>.
     */
    public final TableField<RoleRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>manage_students.role.name</code>.
     */
    public final TableField<RoleRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>manage_students.role.status</code>.
     */
    public final TableField<RoleRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER, this, "");

    private Role(Name alias, Table<RoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Role(Name alias, Table<RoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>manage_students.role</code> table reference
     */
    public Role(String alias) {
        this(DSL.name(alias), ROLE);
    }

    /**
     * Create an aliased <code>manage_students.role</code> table reference
     */
    public Role(Name alias) {
        this(alias, ROLE);
    }

    /**
     * Create a <code>manage_students.role</code> table reference
     */
    public Role() {
        this(DSL.name("role"), null);
    }

    public <O extends Record> Role(Table<O> child, ForeignKey<O, RoleRecord> key) {
        super(child, key, ROLE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : ManageStudents.MANAGE_STUDENTS;
    }

    @Override
    public Identity<RoleRecord, Integer> getIdentity() {
        return (Identity<RoleRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RoleRecord> getPrimaryKey() {
        return Keys.KEY_ROLE_PRIMARY;
    }

    @Override
    public Role as(String alias) {
        return new Role(DSL.name(alias), this);
    }

    @Override
    public Role as(Name alias) {
        return new Role(alias, this);
    }

    @Override
    public Role as(Table<?> alias) {
        return new Role(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Role rename(String name) {
        return new Role(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Role rename(Name name) {
        return new Role(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Role rename(Table<?> name) {
        return new Role(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Integer, ? super String, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super String, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
