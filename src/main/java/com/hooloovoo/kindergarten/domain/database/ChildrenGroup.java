package com.hooloovoo.kindergarten.domain.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity

@Table(name = "CHILDREN_GROUP")
public class ChildrenGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String groupName;


    @OneToMany(mappedBy = "group")
    private Set<Child> children;

    @ManyToMany
    @JoinTable(
            name = "GroupActivitiesGroups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "group_activity_id"))
    Set<GroupActivity> groupActivities;

    @ManyToMany
    @JoinTable(
            name = "GroupTeachers",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    Set<Teacher> teachers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public Set<GroupActivity> getGroupActivities() {
        return groupActivities;
    }

    public void setGroupActivities(Set<GroupActivity> groupActivities) {
        this.groupActivities = groupActivities;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildrenGroup group = (ChildrenGroup) o;
        return id.equals(group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
