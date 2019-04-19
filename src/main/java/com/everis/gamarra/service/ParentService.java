package com.everis.gamarra.service;

import com.everis.gamarra.model.Parent;

import java.util.List;

/**
 * La interfaz ParentService contiene todos los metodos que seran sobreescritos en el servicio.
 */
public interface ParentService {

  /**
   * Metodo que se encarga de listar todos los padres.
   */
  List<Parent> getAllParents();

  /**
   * Metodo que se encarga de registrar una padre.
   * @param obj es el objeto de la clase Parent
   */
  Parent addParent(Parent obj);

  /**
   * Metodo que se encarga de actualizar los datos de un padre.
   * @param obj es el objeto de la clase Parent
   */
  Parent updateParent(Parent obj);

  /**
   * Metodo que se encarga de eliminar el registro de un padre.
   * @param id es la identificacion de un padre
   */
  void deleteParent(Integer id);


}
