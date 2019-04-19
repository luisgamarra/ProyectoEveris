package com.everis.gamarra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Clase estudiante usado para almacenar la informacion del estudiante.
 */
@Data
@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id")
  private int id;

  @Size(max = 1,message = "enter the initial letter ")
  @Pattern(regexp = "F|M", message = "enter F o M")
  @NotEmpty(message = "the gender is required")
  private String gender;

  @Column(name = "first_name")
  @NotEmpty(message = "the first name is required")
  private String firstName;

  @Column(name = "middle_name")
  @NotEmpty(message = "the middle name is required")
  private String middleName;

  @Column(name = "last_name")
  @NotEmpty(message = "the last name is required")
  private String lastName;

  @Column(name = "date_of_birth")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;

  @Column(name = "other_student_details")
  private String otherStudentDetails;

  @OneToMany(mappedBy = "student")
  @JsonIgnore
  private List<FamilyMember> family_member = new ArrayList<FamilyMember>();


}
