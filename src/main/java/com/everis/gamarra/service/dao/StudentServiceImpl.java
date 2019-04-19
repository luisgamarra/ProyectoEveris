package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.Student;
import com.everis.gamarra.repository.StudentRepository;
import com.everis.gamarra.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * El servicio StudentServiceImpl sobreescribe los metodos definidos.
 * Utiliza los metodos de Jparepository
 */
@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  /**
   * Metodo que se encarga de listar todos los estudiantes.
   * @return listado de estudiantes
   */
  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  /**
   * Metodo que se encarga de registrar un estudiante.
   * @param obj es el objeto de la clase estudiante
   */
  @Override
  public Student addStudent(Student obj) {
    studentRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de actualizar el registro de un padre.
   * @param obj es el objeto de la clase estudiante
   */
  @Override
  public Student updateStudent(Student obj) {
    studentRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de eliminar un estudiante.
   * @param id es la identificacion de un estudiante
   */
  @Override
  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }
}
