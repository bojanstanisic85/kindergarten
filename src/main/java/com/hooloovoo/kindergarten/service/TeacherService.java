package com.hooloovoo.kindergarten.service;

import com.hooloovoo.kindergarten.domain.database.Teacher;
import com.hooloovoo.kindergarten.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher saveTeacher(Teacher teacher) {
        Assert.notNull(teacher, "Teacher can not be null");
        return teacherRepository.save(teacher);
        //todo: invalidate cache, look into um2 service implementation
    }

    public Teacher getTeacherById(Long id) {
        Assert.notNull(id, "Id can not be null");
        return teacherRepository.findById(id).orElse(null);
    }

}
