package com.everis.gamarra.service.dao;

import com.everis.gamarra.dto.FamilyMemberDto;
import com.everis.gamarra.model.FamilyMember;
import com.everis.gamarra.repository.FamilyMemberRepository;
import com.everis.gamarra.repository.ParentRepository;
import com.everis.gamarra.repository.StudentRepository;
import com.everis.gamarra.service.FamilyMemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * El servicio FamilyMemberServiceImpl sobreescribe los metodos definidos.
 * Utiliza los metodos de Jparepository
 */
@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

  @Autowired
  FamilyMemberRepository familyMemberRepository;
  @Autowired
  ParentRepository parentRepository;
  @Autowired
  StudentRepository studentRepository;

  /**
   * Metodo que se encarga de listar los miembros de todas las familias.
   * @return listado miembros de familias
   */
  @Override
  public List<FamilyMember> getAllFamilyMembers() {
    return familyMemberRepository.findAll();
  }

  /**
   * Metodo que se encarga de registrar el miembro de una familia.
   * @param  obj es el objeto de la clase FamilyMember
   */
  @Override
  public FamilyMember addFamilyMember(FamilyMember obj) {
    familyMemberRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de actualizar los datos del miembro de una familia.
   * @param obj es el objeto de la clase FamilyMember
   */
  @Override
  public FamilyMember updateFamilyMember(FamilyMember obj) {
    familyMemberRepository.save(obj);
    return obj;
  }

  /**
   * Metodo que se encarga de eliminar el miembro de una familia.
   * @param id es la identificacion del miembro de una familia
   */
  @Override
  public void deleteFamilyMember(Integer id) {
    familyMemberRepository.deleteById(id);
  }

  @Override
  public FamilyMemberDto findFamilyMemberByFamilyId(Integer familyId) {
    // TODO Auto-generated method stub
    FamilyMemberDto dto = new FamilyMemberDto();
    dto.setFamilyId(familyId);
    dto.setParents(parentRepository.findParentByFamilyId(familyId));
    dto.setStudents(studentRepository.findStudentByFamilyId(familyId));
    return dto;
  }

}
