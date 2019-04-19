package com.everis.gamarra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Clase padre usado para almacenar la informacion de los padres.
 */
@Data
@Entity
@Table(name = "parents")
public class Parent implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "parent_id")
  private int id;

  @NotEmpty(message = "the gender is required")
  @Size(max = 1,message = "enter the initial letter ")
  @Pattern(regexp = "F|M", message = "enter F o M")
  private String gender;

  @Column(name = "first_name")
  @NotEmpty(message = "the name is required")
  private String firstName;

  @Column(name = "middle_name")
  @NotEmpty(message = "the middle name is required")
  private String middleName;

  @Column(name = "last_name")
  @NotEmpty(message = "the last name is required")
  private String lastName;

  @Column(name = "other_parent_details")
  private String otherParentDetails;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<FamilyMember> family_member = new ArrayList<>();

  private static final long serialVersionUID = 1L;

}
