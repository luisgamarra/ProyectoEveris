package com.everis.gamarra.service;

import com.everis.gamarra.dto.FamilyMemberDto;
import com.everis.gamarra.model.FamilyMember;
import java.util.List;

/**
 * La interfaz FamilyMemberService contiene todos los metodos que seran sobreescritos en el servicio.
 */
public interface FamilyMemberService {

  /**
   * Metodo que se encarga de listar los miembros de todas las familias.
   */
  List<FamilyMember> getAllFamilyMembers();

  /**
   * Metodo que se encarga de registrar el miembro de una familia.
   * @param  obj es el objeto de la clase FamilyMember
   */
  FamilyMember addFamilyMember(FamilyMember obj);

  /**
   * Metodo que se encarga de actualizar los datos del miembro de una familia.
   * @param obj es el objeto de la clase FamilyMember
   */
  FamilyMember updateFamilyMember(FamilyMember obj);

  /**
   * Metodo que se encarga de eliminar el miembro de una familia.
   * @param id es la identificacion del miembro de una familia
   */
  void deleteFamilyMember(Integer id);

  FamilyMemberDto findFamilyMemberByFamilyId(Integer familyId);

}
