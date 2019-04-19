package com.everis.gamarra.controller;

import com.everis.gamarra.model.StudentParent;
import com.everis.gamarra.service.StudentParentService;
import com.everis.gamarra.model.StudentParentPK;
import java.util.List;
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

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1.0")
public class StudentParentController {

  @Autowired
  private StudentParentService studentParentService;

  /**
   * Metodo que se encarga de listar todos los estudiantes y sus padres.
   * @return listado de estudiantes y padres
   */
  @GetMapping("/student-parents")
  @ResponseStatus(HttpStatus.OK)
  public List<StudentParent> getAllStudentParents() {
    return studentParentService.getAllStudentParents();
  }

  /**
   * Metodo que se encarga de listar un estudiante y su padre.
   * @param stuid es la identificacion de un estudiante
   * @param pareid es la identificacion de un padre
   */
  @GetMapping("/student/{stuid}/Parent/{pareid}")
  @ResponseStatus(HttpStatus.OK)
  public StudentParent get(@PathVariable("stuid") int stuid, @PathVariable("pareid") int pareid) {

    StudentParentPK studentParentPK = new StudentParentPK();
    studentParentPK.setStudentId(stuid);
    studentParentPK.setParentId(pareid);
    return studentParentService.findByStudentIdAndParentId(studentParentPK);
  }

  /**
   * Metodo que se encarga de registrar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParent
   */
  @PostMapping("/student-parents")
  //@ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<StudentParent> addStudentParents(@Valid @RequestBody StudentParent obj) {
    return new ResponseEntity<>(studentParentService.addStudentParent(obj),HttpStatus.CREATED);
  }

  /**
   * Metodo que se encarga de actualizar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParent
   */
  @PutMapping("/student-parents")
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<StudentParent> updateStudentParents(@Valid @RequestBody StudentParent obj) {
    return new ResponseEntity<>(studentParentService.updateStudentParent(obj),HttpStatus.OK);
  }

  /**
   * Metodo que se encarga de eliminar un estudiante y su padre.
   * @param stuid es la identificacion de un estudiante
   * @param pareid es la identificacion de un padre
   */
  @DeleteMapping("/student/{stuid}/Parent/{pareid}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("stuid") int stuid, @PathVariable("pareid") int pareid) {
    StudentParentPK studentParentPK = new StudentParentPK();
    studentParentPK.setStudentId(stuid);
    studentParentPK.setParentId(pareid);
    studentParentService.deleteStudentParent(studentParentPK);
  }


}
