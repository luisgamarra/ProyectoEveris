package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.*;
import com.everis.gamarra.repository.StudentParentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class StudentParentServiceImplTest {

  @Mock
  StudentParentRepository studentParentRepository;

  @InjectMocks
  StudentParentServiceImpl studentParentServiceImpl;

  @Test
  public void getAllStudentParents() {

    List<StudentParent> liststudentparent = studentParentServiceImpl.getAllStudentParents();
    //assertThat("They are not equal!",listaparent,assertNotNull(listaparent));
    assertNotNull(liststudentparent);
  }

  @Test
  public void findByStudentIdAndParentId() {

   /* Student student = new Student();
    student.setId(1);
    Parent Parent = new Parent();
    Parent.setId(1);


    StudentParentPK studentParentPK = new StudentParentPK();
    studentParentPK.setStudentId(student.getId());
    studentParentPK.setParentId(Parent.getId());

    studentParentServiceImpl.findByStudentIdAndParentId(studentParentPK);*/
  }

  @Test
  public void addStudentParent() {

    Student student = new Student();
    student.setId(1);
    Parent parent = new Parent();
    parent.setId(1);

    StudentParent studentParent = new StudentParent();
    studentParent.setParent(parent);
    studentParent.setStudent(student);
    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    StudentParent createstudentparent = studentParentServiceImpl.addStudentParent(studentParent);

    assertThat("They are not equal!",studentParent.getParent(),is(createstudentparent.getParent()));
  }

  @Test
  public void updateStudentParent() {

    Student student = new Student();
    student.setId(1);
    Parent parent = new Parent();
    parent.setId(1);

    StudentParent studentParent = new StudentParent();
    studentParent.setParent(parent);
    studentParent.setStudent(student);
    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    StudentParent createstudentparent = studentParentServiceImpl.updateStudentParent(studentParent);

    assertThat("They are not equal!",studentParent.getParent(),is(createstudentparent.getParent()));
  }

  @Test
  public void deleteStudentParent() {
    Student student = new Student();
    student.setId(1);
    Parent parent = new Parent();
    parent.setId(1);


    StudentParentPK studentParentPK = new StudentParentPK();
    studentParentPK.setStudentId(student.getId());
    studentParentPK.setParentId(parent.getId());

   studentParentServiceImpl.deleteStudentParent(studentParentPK);
  }
}