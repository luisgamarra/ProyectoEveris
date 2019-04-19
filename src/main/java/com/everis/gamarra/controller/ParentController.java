package com.everis.gamarra.controller;

import com.everis.gamarra.model.Parent;
import com.everis.gamarra.service.ParentService;

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
@RequestMapping("/api/v1.0/parents")
public class ParentController {

  @Autowired
  private ParentService parentService;

  /**
   * Metodo que se encarga de listar todos los padres.
   * @return listado de padres
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Parent> findAllParents() {
    return parentService.getAllParents();
  }

  /**
   * Metodo que se encarga de registrar una padre.
   * @param obj es el objeto de la clase Parent
   */
  @PostMapping
  //@ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Parent> addParent(@Valid @RequestBody Parent obj) {
    return new ResponseEntity<>(parentService.addParent(obj),HttpStatus.CREATED);
  }

  /**
   * Metodo que se encarga de actualizar los datos de un padre.
   * @param obj es el objeto de la clase Parent
   */
  @PutMapping
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Parent> updateParent(@Valid @RequestBody Parent obj) {
    return new ResponseEntity<>(parentService.updateParent(obj),HttpStatus.OK);
  }

  /**
   * Metodo que se encarga de eliminar el registro de un padre.
   * @param id es la identificacion de un padre
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteParent(@PathVariable("id") Integer id) {
    parentService.deleteParent(id);
  }

}
