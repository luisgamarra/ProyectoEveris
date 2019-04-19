package com.everis.gamarra.service;

import com.everis.gamarra.model.Family;
import java.util.List;


/**
 * La interfaz FamilyService contiene todos los metodos que seran sobreescritos en el servicio.
 */
public interface FamilyService {

  /**
   * Metodo que se encarga de listar todas las familias.
   */
  List<Family> getAllFamilies();

  /**
   * Metodo que se encarga de listar una famillia.
   * @param  id es la identificacion de una familia
   */
  Family findByFamilyId(Integer id);

  /**
   * Metodo que se encarga de registrar una familia.
   * @param  obj es un objeto de la clase familia
   */
  Family addFamily(Family obj);

  /**
   * Metodo que actualizar los datos de una familia.
   * @param  obj es un objeto de la clase familia
   */
  Family udpdateFamily(Family obj);

  /**
   * Metodo que se encarga de eliminar el registro de una famillia.
   * @param  id es la identificacion de una familia
   */
  void deleteFamily(Integer id);


}
