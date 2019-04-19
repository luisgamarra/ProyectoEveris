package com.everis.gamarra.repository;

import com.everis.gamarra.model.FamilyMember;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember,Integer> {

}
