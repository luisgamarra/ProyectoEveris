package com.everis.gamarra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

import java.io.Serializable;


/**
 * Clase mienbros de familia usado para almacenar la informacion de los miembros de una familia.
 */
@Data
@Entity
@Table(name = "family_members")
public class FamilyMember implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_member_id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "family_id")
  private Family family;

  @Column(name = "parent_or_student_member")
  @NotEmpty(message = "the field is required")
  private String parentOrStudentMember;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Parent parent;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  private static final long serialVersionUID = 1L;
}
