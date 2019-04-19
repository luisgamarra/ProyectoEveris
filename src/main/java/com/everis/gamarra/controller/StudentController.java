package com.everis.gamarra.controller;

import com.everis.gamarra.model.Student;
import com.everis.gamarra.service.StudentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("api/v1.0/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  /**
   * Metodo que se encarga de listar todos los estudiantes.
   * @return listado de estudiantes
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  /**
   * Metodo que se encarga de registrar un estudiante.
   * @param obj es el objeto de la clase estudiante
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Student> addStudent(@Valid @RequestBody Student obj) {
    return new ResponseEntity<>(studentService.addStudent(obj),HttpStatus.CREATED);
  }

  /**
   * Metodo que se encarga de actualizar el registro de un padre.
   * @param obj es el objeto de la clase estudiante
   */
  @PutMapping
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student obj) {
    return new ResponseEntity<>(studentService.updateStudent(obj),HttpStatus.OK);
  }

  /**
   * Metodo que se encarga de eliminar un estudiante.
   * @param id es la identificacion de un estudiante
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteStudent(@PathVariable("id") Integer id) {
    studentService.deleteStudent(id);
  }


}
