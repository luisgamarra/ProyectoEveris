package com.everis.gamarra.service;

import com.everis.gamarra.model.Student;

import java.util.List;

/**
 * La interfaz StudentService contiene todos los metodos que seran sobreescritos en el servicio.
 */
public interface StudentService {

	/**
	 * Metodo que se encarga de listar todos los estudiantes.
	 */
	List<Student> getAllStudents();

	/**
	 * Metodo que se encarga de registrar un estudiante.
	 * @param obj es el objeto de la clase estudiante
	 */
	Student addStudent(Student obj);

	/**
	 * Metodo que se encarga de actualizar el registro de un padre.
	 * @param obj es el objeto de la clase estudiante
	 */
	Student updateStudent(Student obj);

	/**
	 * Metodo que se encarga de eliminar un estudiante.
	 * @param id es la identificacion de un estudiante
	 */
	void deleteStudent(Integer id);
}
