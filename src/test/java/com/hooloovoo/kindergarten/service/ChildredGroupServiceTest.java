package com.hooloovoo.kindergarten.service;

import com.hooloovoo.kindergarten.domain.database.Child;
import com.hooloovoo.kindergarten.domain.database.ChildrenGroup;
import com.hooloovoo.kindergarten.domain.database.Teacher;
import com.hooloovoo.kindergarten.repository.ChildRepository;
import com.hooloovoo.kindergarten.repository.ChildrenGroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class ChildredGroupServiceTest {

    @Mock
    private ChildRepository childRepository;
    @Mock
    private ChildrenGroupRepository childrenGroupRepository;

    @InjectMocks
    private ChildrenGroupService childrenGroupService;

    @Captor
    private ArgumentCaptor<Child> childCaptor;

    @Captor
    private ArgumentCaptor<ChildrenGroup> childrenGroupCaptor;

    @Test
    public void shouldSaveChildrenGroup() {
        ChildrenGroup childrenGroup = new ChildrenGroup();
        Set<Child> children1 = Set.of(new Child(1L,5, LocalDateTime.now(), "Mali", "Milojica"));
        Set<Child> children = new HashSet<>();
        children.add(new Child(1L,5, LocalDateTime.now(), "Mali", "Milojica"));
        childrenGroup.setChildren(children);
        childrenGroupService.saveChildrenGroup(childrenGroup);

        Mockito.verify(childRepository).save(childCaptor.capture());
        Child testChild = childCaptor.getValue();
        Assertions.assertEquals("Mali", testChild.getName());
        Assertions.assertEquals("Milojica", testChild.getSurname());
        Assertions.assertEquals(5, testChild.getAge());

        Assertions.assertEquals(childrenGroup, testChild.getGroup());
    }

    @Test
    public void shouldSaveAllChildren() {
        ChildrenGroup childrenGroup = new ChildrenGroup();
        Set<Child> children = Set.of(new Child(1L,5, LocalDateTime.now(), "Mali", "Milojica"),
                new Child(2L,2, LocalDateTime.now(), "Namjmanji", "Milojica"));

        childrenGroup.setChildren(children);
        childrenGroupService.saveChildrenGroup(childrenGroup);

        Mockito.verify(childRepository, Mockito.times(2)).save(Mockito.any(Child.class));
    }

    @Test
    public void shouldAddTeacher() {
        ChildrenGroup childrenGroup = new ChildrenGroup();
        childrenGroup.setTeachers(new HashSet<>());
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("TeacherName");
        teacher.setGroups(new HashSet<>());

        childrenGroupService.addTeacher(teacher, childrenGroup);

        Mockito.verify(childrenGroupRepository).save(childrenGroupCaptor.capture());
        Assertions.assertTrue(childrenGroupCaptor.getValue().getTeachers().contains(teacher));
    }
}
