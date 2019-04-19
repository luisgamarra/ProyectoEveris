package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.Family;
import com.everis.gamarra.model.FamilyMember;
import com.everis.gamarra.repository.FamilyMemberRepository;
import com.everis.gamarra.repository.FamilyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FamilyMemberServiceImplTest {

  @Mock
  FamilyMemberRepository familyMemberRepository;

  @InjectMocks
  FamilyMemberServiceImpl familyMemberServiceImpl;

  @Test
  public void getAllFamilyMembers() {

    List<FamilyMember> listfamilymember = familyMemberServiceImpl.getAllFamilyMembers();
    //assertThat("They are not equal!",listaparent,assertNotNull(listaparent));
    assertNotNull(listfamilymember);
  }

  @Test
  public void addFamilyMember() {

    FamilyMember familymember = new FamilyMember();
    familymember.setParentOrStudentMember("Student");
    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    FamilyMember createfamilymember = familyMemberServiceImpl.addFamilyMember(familymember);

    assertThat("They are not equal!",familymember.getParentOrStudentMember(),is(createfamilymember.getParentOrStudentMember()));
  }

  @Test
  public void updateFamilyMember() {

    FamilyMember familymember = new FamilyMember();
    familymember.setId(1);
    familymember.setParentOrStudentMember("Student");
    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    FamilyMember createfamilymember = familyMemberServiceImpl.updateFamilyMember(familymember);

    assertThat("They are not equal!",familymember.getParentOrStudentMember(),is(createfamilymember.getParentOrStudentMember()));
  }

  @Test
  public void deleteFamilyMember() {
    FamilyMember familyMember = new FamilyMember();
    familyMember.setId(1);

    familyMemberServiceImpl.deleteFamilyMember(familyMember.getId());
  }

}