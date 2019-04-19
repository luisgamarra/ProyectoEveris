package com.everis.gamarra.controller;

import com.everis.gamarra.dto.FamilyMemberDto;
import com.everis.gamarra.model.FamilyMember;
import com.everis.gamarra.service.FamilyMemberService;
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
@RequestMapping("/api/v1.0/family-members")
public class FamilyMemberController {

  @Autowired
  private FamilyMemberService familyMemberService;

  /**
   * Metodo que se encarga de listar los miembros de todas las familias.
   * @return listado miembros de familias
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<FamilyMember> getAllFamiliMembers() {
    return familyMemberService.getAllFamilyMembers();
  }

  /**
   * Metodo que se encarga de registrar el miembro de una familia.
   * @param  obj es el objeto de la clase FamilyMember
   */
  @PostMapping
  //@ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<FamilyMember> addFamilyMember(@Valid @RequestBody FamilyMember obj) {
    return new ResponseEntity<>(familyMemberService.addFamilyMember(obj),HttpStatus.CREATED);
  }

  /**
   * Metodo que se encarga de actualizar los datos del miembro de una familia.
   * @param obj es el objeto de la clase FamilyMember
   */
  @PutMapping
  //@ResponseStatus(HttpStatus.OK)
  public ResponseEntity<FamilyMember> updateFamilyMember(@Valid @RequestBody FamilyMember obj) {
    return new ResponseEntity<>(familyMemberService.updateFamilyMember(obj),HttpStatus.OK);
  }

  /**
   * Metodo que se encarga de eliminar el miembro de una familia.
   * @param id es la identificacion del miembro de una familia
   */
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteFamilyMember(@PathVariable ("id") Integer id) {
    familyMemberService.deleteFamilyMember(id);
  }

  @GetMapping("/family/{id}")
  public FamilyMemberDto findMembersByFamily(@PathVariable("id")Integer familyId) {
    return familyMemberService.findFamilyMemberByFamilyId(familyId);
  }


}
