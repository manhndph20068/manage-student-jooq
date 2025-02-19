/*
 * This file is generated by jOOQ.
 */
package com.example.managestudentjooq.model.tables;


import com.example.managestudentjooq.model.Indexes;
import com.example.managestudentjooq.model.Keys;
import com.example.managestudentjooq.model.ManageStudents;
import com.example.managestudentjooq.model.tables.records.AccountRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
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
public class Account extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>manage_students.account</code>
     */
    public static final Account ACCOUNT = new Account();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>manage_students.account.id</code>.
     */
    public final TableField<AccountRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>manage_students.account.username</code>.
     */
    public final TableField<AccountRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>manage_students.account.password</code>.
     */
    public final TableField<AccountRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>manage_students.account.create_at</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> CREATE_AT = createField(DSL.name("create_at"), SQLDataType.LOCALDATETIME(0), this, "");

    /**
     * The column <code>manage_students.account.updated_at</code>.
     */
    public final TableField<AccountRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0), this, "");

    /**
     * The column <code>manage_students.account.status</code>.
     */
    public final TableField<AccountRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>manage_students.account.role_id</code>.
     */
    public final TableField<AccountRecord, Integer> ROLE_ID = createField(DSL.name("role_id"), SQLDataType.INTEGER, this, "");

    private Account(Name alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Account(Name alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>manage_students.account</code> table reference
     */
    public Account(String alias) {
        this(DSL.name(alias), ACCOUNT);
    }

    /**
     * Create an aliased <code>manage_students.account</code> table reference
     */
    public Account(Name alias) {
        this(alias, ACCOUNT);
    }

    /**
     * Create a <code>manage_students.account</code> table reference
     */
    public Account() {
        this(DSL.name("account"), null);
    }

    public <O extends Record> Account(Table<O> child, ForeignKey<O, AccountRecord> key) {
        super(child, key, ACCOUNT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : ManageStudents.MANAGE_STUDENTS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.ACCOUNT_ROLE_ID);
    }

    @Override
    public Identity<AccountRecord, Integer> getIdentity() {
        return (Identity<AccountRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<AccountRecord> getPrimaryKey() {
        return Keys.KEY_ACCOUNT_PRIMARY;
    }

    @Override
    public List<UniqueKey<AccountRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_ACCOUNT_USERNAME_UNIQUE);
    }

    @Override
    public List<ForeignKey<AccountRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ACCOUNT_IBFK_1);
    }

    private transient Role _role;

    /**
     * Get the implicit join path to the <code>manage_students.role</code>
     * table.
     */
    public Role role() {
        if (_role == null)
            _role = new Role(this, Keys.ACCOUNT_IBFK_1);

        return _role;
    }

    @Override
    public Account as(String alias) {
        return new Account(DSL.name(alias), this);
    }

    @Override
    public Account as(Name alias) {
        return new Account(alias, this);
    }

    @Override
    public Account as(Table<?> alias) {
        return new Account(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(String name) {
        return new Account(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Name name) {
        return new Account(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Table<?> name) {
        return new Account(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, LocalDateTime, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super Integer, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super Integer, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
