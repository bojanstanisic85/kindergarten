package com.hooloovoo.kindergarten.domain.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CHILD")
public class Child {

    public Child() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;
    private LocalDateTime joinedAt;
    private String name;
    private String surname;

    public Child(Long id, int age, LocalDateTime joinedAt, String name, String surname) {
        this.id = id;
        this.age = age;
        this.joinedAt = joinedAt;
        this.name = name;
        this.surname = surname;
    }

    @ManyToOne(cascade=CascadeType.ALL) //provjeri MERGE sta radi
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @JsonIgnore
    //@ManyToOne(cascade = CascadeType.ALL) - moze i bez transakcije ako se stavi ovo, i bez @JsonIgnore takodje
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private ChildrenGroup group;

    @OneToMany(mappedBy = "child")
    private Set<Impression> impressions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public ChildrenGroup getGroup() {
        return group;
    }

    public void setGroup(ChildrenGroup group) {
        this.group = group;
    }

    public Set<Impression> getImpressions() {
        return impressions;
    }

    public void setImpressions(Set<Impression> impressions) {
        this.impressions = impressions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return id.equals(child.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
