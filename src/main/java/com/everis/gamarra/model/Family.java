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

/**
 * Clase familia usado para almacenar la informacion de la familia.
 */
@Data
@Entity
@Table(name = "families")
public class Family {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "family_id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id")
  //@NotEmpty(message = "the head of family Parent is required")
  private Parent headOfFamilyParent;

  @Column(name = "family_name")
  @NotEmpty(message = "the family name is required")
  private String familyName;

}
