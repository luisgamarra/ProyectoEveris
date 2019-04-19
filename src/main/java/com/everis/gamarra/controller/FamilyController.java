package com.everis.gamarra.controller;

import com.everis.gamarra.model.Family;
import com.everis.gamarra.service.FamilyService;
import com.everis.gamarra.utility.exceptions.RecordNotFoundException;
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
@RequestMapping("/api/v1.0/families")
class FamilyController {

  @Autowired
  private FamilyService familyService;

  /**
   * Metodo que se encarga de listar todas las familias.
   * @return listado de familias
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Family> getAllFamilies() {
    return familyService.getAllFamilies();
  }

  /**
   * Metodo que se encarga de listar una famillia.
   * @param  id es la identificacion de una familia
   * @return familia
   */
  @GetMapping("/{id}")
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Family> findByFamilyId(@PathVariable("id") Integer id) {

   /* Family family = familyService.findByFamilyId(id);

    if(family == null) {
      throw new RecordNotFoundException("Invalid family id : " + id);
    }*/

    return new ResponseEntity<>(familyService.findByFamilyId(id),HttpStatus.OK);
  }

  /**
   * Metodo que se encarga de registrar una familia.
   * @param  obj es un objeto de la clase familia
   */
  @PostMapping
  //@ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Family> addFamily(@Valid @RequestBody Family obj) {
    return new ResponseEntity<>(familyService.addFamily(obj), HttpStatus.CREATED);
  }

  /**
   * Metodo que actualizar los datos de una familia.
   * @param  obj es un objeto de la clase familia
   */
  @PutMapping
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Family> updateFamily(@Valid @RequestBody Family obj) {
    return new ResponseEntity<>(familyService.udpdateFamily(obj),HttpStatus.OK);
  }

  /**
   * Metodo que se encarga de eliminar el registro de una famillia.
   * @param  id es la identificacion de una familia
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteFamily(@PathVariable("id") Integer id) {
    familyService.deleteFamily(id);
  }

}
