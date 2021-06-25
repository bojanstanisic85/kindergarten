package com.hooloovoo.kindergarten.service;

import com.hooloovoo.kindergarten.domain.database.Child;
import com.hooloovoo.kindergarten.domain.database.ChildrenGroup;
import com.hooloovoo.kindergarten.domain.database.Teacher;
import com.hooloovoo.kindergarten.repository.ChildRepository;
import com.hooloovoo.kindergarten.repository.ChildrenGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Service
public class ChildrenGroupService {
    private ChildrenGroupRepository childrenGroupRepository;
    private ChildRepository childRepository;

    public ChildrenGroupService(ChildrenGroupRepository childrenGroupRepository, ChildRepository childRepository) {
        this.childrenGroupRepository = childrenGroupRepository;
        this.childRepository = childRepository;
    }

    public ChildrenGroup addTeacher(Teacher teacher, ChildrenGroup childrenGroup) {
        Assert.notNull(teacher, "Teacher can not be null");
        Assert.notNull(childrenGroup, "ChildrenGroup can not be null");

        childrenGroup.getTeachers().add(teacher);
        teacher.getGroups().add(childrenGroup);

        return childrenGroupRepository.save(childrenGroup);
    }

    //@Transactional
    public ChildrenGroup saveChildrenGroup(ChildrenGroup childrenGroup) {
        Assert.notNull(childrenGroup, "childrenGroup can not be null");
        for(Child child : childrenGroup.getChildren()) {
            child.setGroup(childrenGroup); // mora da se cuva na owning strani
            childRepository.save(child); //zbog @ManyToOne(cascade = CascadeType.ALL) grupa ce da se sacuva istovremeno kad i child
        }

        return childrenGroup;

        //todo: invalidate cache, look into um2 service implementation
    }
}
