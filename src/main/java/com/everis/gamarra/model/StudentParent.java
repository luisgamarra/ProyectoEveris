package com.everis.gamarra.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;


/**
 * Clase estudiante padres usado para almacenar la informacion de un estudiante y sus padres.
 */
@Data
@Entity
@Table(name = "student_parents")
public class StudentParent {

  @EmbeddedId
  //@JsonIgnore
  private StudentParentPK studentParentPK;


  @ManyToOne
  @MapsId("student_id")
  @JoinColumn(name = "student_id")
  //@NotEmpty(message = "the student is required")
  private Student student = new Student();


  @ManyToOne
  @MapsId("parent_id")
  @JoinColumn(name = "parent_id")
  //@NotEmpty(message = "the Parent is required")
  private Parent parent = new Parent();


  //private static final long serialVersionUID = 1L;
}
