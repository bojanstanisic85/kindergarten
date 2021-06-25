package com.hooloovoo.kindergarten.repository;

import com.hooloovoo.kindergarten.domain.database.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
