package com.hooloovoo.kindergarten.repository;

import com.hooloovoo.kindergarten.domain.database.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
}
