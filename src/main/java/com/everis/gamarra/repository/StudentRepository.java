package com.everis.gamarra.repository;

import com.everis.gamarra.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

  @Query(value = "select distinct(s.*) from student s"
      + " inner join family_member f on s.student_id=f.student_id"
      + " where f.family_id=?1", nativeQuery = true)
  List<Student> findStudentByFamilyId(Integer familyId);
}
