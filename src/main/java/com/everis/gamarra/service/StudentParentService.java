package com.everis.gamarra.service;

import com.everis.gamarra.model.StudentParent;
import com.everis.gamarra.model.StudentParentPK;
import java.util.List;


/**
 * La interfaz StudentParentService contiene todos los metodos que seran sobreescritos en el servicio.
 */
public interface StudentParentService {

  /**
   * Metodo que se encarga de listar todos los estudiantes y sus padres.
   */
  List<StudentParent> getAllStudentParents();

  /**
   * Metodo que se encarga de listar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParentPK
   */
  StudentParent findByStudentIdAndParentId(StudentParentPK obj);

  /**
   * Metodo que se encarga de registrar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParent
   */
  StudentParent addStudentParent(StudentParent obj);

  /**
   * Metodo que se encarga de actualizar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParent
   */
  StudentParent updateStudentParent(StudentParent obj);

  /**
   * Metodo que se encarga de eliminar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParentPK
   */
  void deleteStudentParent(StudentParentPK obj);


}
