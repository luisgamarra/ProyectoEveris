package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.StudentParent;
import com.everis.gamarra.repository.StudentParentRepository;
import com.everis.gamarra.service.StudentParentService;
import com.everis.gamarra.model.StudentParentPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * El servicio StudentParentServiceImpl sobreescribe los metodos definidos.
 * Utiliza los metodos de Jparepository */

@Service
public class StudentParentServiceImpl implements StudentParentService {

  @Autowired
  StudentParentRepository studentParentRepository;

  /**
   * Metodo que se encarga de listar todos los estudiantes y sus padres.
   * @return listado de estudiantes y padres
   */
  @Override
  public List<StudentParent> getAllStudentParents() {
    return studentParentRepository.findAll();
  }

  /**
   * Metodo que se encarga de listar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParentPK
   */
  @Override
  public StudentParent findByStudentIdAndParentId(StudentParentPK obj) {
    return studentParentRepository.findById(obj).get();
  }

  /**
   * Metodo que se encarga de registrar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParent
   */
  @Override
  public StudentParent addStudentParent(StudentParent obj) {
    studentParentRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de actualizar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParent
   */
  @Override
  public StudentParent updateStudentParent(StudentParent obj) {
    studentParentRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de eliminar un estudiante y su padre.
   * @param obj es el objeto de la clase StudentParentPK
   */
  @Override
  public void deleteStudentParent(StudentParentPK obj) {
    studentParentRepository.deleteById(obj);
  }
}
