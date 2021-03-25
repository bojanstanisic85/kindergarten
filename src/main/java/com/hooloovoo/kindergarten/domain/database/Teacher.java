package com.hooloovoo.kindergarten.domain.database;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="TEACHER")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String contact;

    @ManyToMany(mappedBy = "teachers")
    private Set<ChildrenGroup> groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<ChildrenGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<ChildrenGroup> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id.equals(teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
