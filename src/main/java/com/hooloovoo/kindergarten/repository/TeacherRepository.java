package com.hooloovoo.kindergarten.repository;

import com.hooloovoo.kindergarten.domain.database.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
