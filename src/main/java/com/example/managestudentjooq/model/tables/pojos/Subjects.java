/*
 * This file is generated by jOOQ.
 */
package com.example.managestudentjooq.model.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private Integer status;

    public Subjects() {}

    public Subjects(Subjects value) {
        this.id = value.id;
        this.name = value.name;
        this.description = value.description;
        this.createAt = value.createAt;
        this.updatedAt = value.updatedAt;
        this.status = value.status;
    }

    public Subjects(
        Integer id,
        String name,
        String description,
        LocalDateTime createAt,
        LocalDateTime updatedAt,
        Integer status
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    /**
     * Getter for <code>manage_students.subjects.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>manage_students.subjects.id</code>.
     */
    public Subjects setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>manage_students.subjects.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>manage_students.subjects.name</code>.
     */
    public Subjects setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>manage_students.subjects.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>manage_students.subjects.description</code>.
     */
    public Subjects setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>manage_students.subjects.create_at</code>.
     */
    public LocalDateTime getCreateAt() {
        return this.createAt;
    }

    /**
     * Setter for <code>manage_students.subjects.create_at</code>.
     */
    public Subjects setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
        return this;
    }

    /**
     * Getter for <code>manage_students.subjects.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>manage_students.subjects.updated_at</code>.
     */
    public Subjects setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Getter for <code>manage_students.subjects.status</code>.
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>manage_students.subjects.status</code>.
     */
    public Subjects setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Subjects other = (Subjects) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.createAt == null) {
            if (other.createAt != null)
                return false;
        }
        else if (!this.createAt.equals(other.createAt))
            return false;
        if (this.updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        }
        else if (!this.updatedAt.equals(other.updatedAt))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.createAt == null) ? 0 : this.createAt.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Subjects (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(createAt);
        sb.append(", ").append(updatedAt);
        sb.append(", ").append(status);

        sb.append(")");
        return sb.toString();
    }
}
