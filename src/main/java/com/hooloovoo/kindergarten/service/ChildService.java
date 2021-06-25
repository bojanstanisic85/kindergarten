package com.hooloovoo.kindergarten.service;

import com.hooloovoo.kindergarten.domain.database.Child;
import com.hooloovoo.kindergarten.domain.database.Parent;
import com.hooloovoo.kindergarten.repository.ChildRepository;
import com.hooloovoo.kindergarten.repository.ParentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ChildService {

    private ChildRepository childRepository;
    private ParentRepository parentRepository;

    public ChildService(ChildRepository childRepository, ParentRepository parentRepository) {
        this.childRepository = childRepository;
        this.parentRepository = parentRepository;
    }

    public Child saveChild(Child child) {
        Assert.notNull(child, "Child can not be null");

        child.setJoinedAt(LocalDateTime.now());
        //check if child has parent, if not create new one
        if (child.getParent() != null && child.getParent().getId() != null) {
            Optional<Parent> parent = parentRepository.findById(child.getParent().getId());
            if (parent.isPresent()) {
                child.setParent(parent.get());
            }

        }

        return childRepository.save(child);
        //todo: invalidate cache, look into um2 service implementation
    }

    public Child getChildById(Long id) {
        Assert.notNull(id, "Id can not be null");
        return childRepository.findById(id).orElse(null);
    }
}
