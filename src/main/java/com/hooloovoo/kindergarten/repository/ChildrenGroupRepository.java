package com.hooloovoo.kindergarten.repository;

import com.hooloovoo.kindergarten.domain.database.ChildrenGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenGroupRepository extends JpaRepository<ChildrenGroup, Long> {
}
