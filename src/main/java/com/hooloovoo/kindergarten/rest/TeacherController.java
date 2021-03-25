package com.hooloovoo.kindergarten.rest;

import com.hooloovoo.kindergarten.domain.database.Teacher;
import com.hooloovoo.kindergarten.service.TeacherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ( "/teacher" )
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value="{teacherId}", method = RequestMethod.GET)
    public Teacher getTeacher(@PathVariable ("teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

}
