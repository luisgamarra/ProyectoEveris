package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.Parent;
import com.everis.gamarra.repository.ParentRepository;
import com.everis.gamarra.service.ParentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * El servicio ParentServiceImpl sobreescribe los metodos definidos.
 * Utiliza los metodos de Jparepository
 */
@Service
public class ParentServiceImpl implements ParentService {

  @Autowired
  private ParentRepository parentRepository;

  /**
   * Metodo que se encarga de listar todos los padres.
   * @return listado de padres
   */
  @Override
  public List<Parent> getAllParents() {
    return parentRepository.findAll();
  }

  /**
   * Metodo que se encarga de registrar una padre.
   * @param obj es el objeto de la clase Parent
   */
  @Override
  public Parent addParent(Parent obj) {
    parentRepository.save(obj);
    return obj;

  }

  /**
   * Metodo que se encarga de actualizar los datos de un padre.
   * @param obj es el objeto de la clase Parent
   */
  @Override
  public Parent updateParent(Parent obj) {
    parentRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de eliminar el registro de un padre.
   * @param id es la identificacion de un padre
   */
  @Override
  public void deleteParent(Integer id) {
    parentRepository.deleteById(id);
  }

}
