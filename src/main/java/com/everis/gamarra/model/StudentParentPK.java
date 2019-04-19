package com.everis.gamarra.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * Clase StudentParentPK se usara para almacenar las llaves primarias de StudentParent.
 */
@Data
@Embeddable
public class StudentParentPK implements Serializable {


  @Column(name = "student_id")
  private int studentId;


  @Column(name = "parent_id")
  private int parentId;

  private static final long serialVersionUID = 1L;

}
