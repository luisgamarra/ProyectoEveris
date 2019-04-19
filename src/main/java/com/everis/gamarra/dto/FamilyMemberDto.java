package com.everis.gamarra.dto;

import com.everis.gamarra.model.Parent;
import com.everis.gamarra.model.Student;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FamilyMemberDto implements Serializable {

  /**
   * Autogenerado.
   */
  private static final long serialVersionUID = 1L;

  private Integer familyId;

  private List<Student> students;

  private List<Parent> parents;
}
