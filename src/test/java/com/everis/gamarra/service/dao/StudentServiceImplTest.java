package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.Family;
import com.everis.gamarra.model.Student;
import com.everis.gamarra.repository.FamilyRepository;
import com.everis.gamarra.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class StudentServiceImplTest {

  @Mock
  StudentRepository studentRepository;

  @InjectMocks
  StudentServiceImpl studentServiceImpl;

  @Test
  public void getAllStudents() {

    List<Student> liststudent = studentServiceImpl.getAllStudents();
    //assertThat("They are not equal!",listaparent,assertNotNull(listaparent));
    assertNotNull(liststudent);
  }

  @Test
  public void addStudent() {

    Student student = new Student();
    student.setFirstName("Luis");
    Student createstudent = studentServiceImpl.addStudent(student);

    assertThat("They are not equal!",student.getFirstName(),is(createstudent.getFirstName()));
  }

  @Test
  public void updateStudent() {

    Student student = new Student();
    student.setId(1);
    student.setFirstName("Luis");
    Student createstudent = studentServiceImpl.updateStudent(student);

    assertThat("They are not equal!",student.getFirstName(),is(createstudent.getFirstName()));
  }

  @Test
  public void deleteStudent() {
    Student student = new Student();
    student.setId(1);

    studentServiceImpl.deleteStudent(student.getId());
  }
}