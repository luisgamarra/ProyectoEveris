package com.everis.gamarra.repository;

import com.everis.gamarra.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {

  @Query(value = "select distinct(p.*) from parent p"
      + " inner join family_member f on p.parent_id = f.parent_id"
      + " where f.family_id = ?1", nativeQuery = true)
  List<Parent> findParentByFamilyId(Integer familyId);
}
