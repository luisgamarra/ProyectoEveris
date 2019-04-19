package com.everis.gamarra.repository;

import com.everis.gamarra.model.StudentParentPK;
import com.everis.gamarra.model.StudentParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentParentRepository extends JpaRepository<StudentParent, StudentParentPK> {
}
