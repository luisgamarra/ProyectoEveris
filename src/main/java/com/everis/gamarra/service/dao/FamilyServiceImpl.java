package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.Family;
import com.everis.gamarra.repository.FamilyRepository;
import com.everis.gamarra.service.FamilyService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * El servicio FamilyServiceImpl sobreescribe los metodos definidos.
 * Utiliza los metodos de Jparepository
 */
@Service
public class FamilyServiceImpl implements FamilyService {

  @Autowired
  FamilyRepository familyRepository;

  /**
   * Metodo que se encarga de listar todas las familias.
   * @return listado de familias
   */
  @Override
  public List<Family> getAllFamilies() {
    return familyRepository.findAll();
  }

  /**
   * Metodo que se encarga de listar una famillia.
   * @param  id es la identificacion de una familia
   * @return familia
   */
  @Override
  public Family findByFamilyId(Integer id) {
    return familyRepository.findById(id).get();
  }

  /**
   * Metodo que se encarga de registrar una familia.
   * @param  obj es un objeto de la clase familia
   */
  @Override
  public Family addFamily(Family obj) {
    familyRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que actualizar los datos de una familia.
   * @param  obj es un objeto de la clase familia
   */
  @Override
  public Family udpdateFamily(Family obj) {
    familyRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de eliminar el registro de una famillia.
   * @param  id es la identificacion de una familia
   */
  @Override
  public void deleteFamily(Integer id) {
    familyRepository.deleteById(id);
  }


}
