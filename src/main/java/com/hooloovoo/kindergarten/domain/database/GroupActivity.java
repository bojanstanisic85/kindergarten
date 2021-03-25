package com.hooloovoo.kindergarten.domain.database;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "GROUP_ACTIVITY")
public class GroupActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String activity_name;

    @OneToMany(mappedBy = "groupActivity")
    private Set<Impression> impressions;

    @ManyToMany(mappedBy = "groupActivities")
    private Set<ChildrenGroup> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public Set<Impression> getImpressions() {
        return impressions;
    }

    public void setImpressions(Set<Impression> impressions) {
        this.impressions = impressions;
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
        GroupActivity that = (GroupActivity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
