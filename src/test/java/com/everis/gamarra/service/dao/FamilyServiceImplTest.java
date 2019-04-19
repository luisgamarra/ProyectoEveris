package com.everis.gamarra.service.dao;

import com.everis.gamarra.model.Family;
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
public class FamilyServiceImplTest {

  @Mock
  FamilyRepository familyRepository;

  @InjectMocks
  FamilyServiceImpl familyServiceImpl;

  @Test
  public void getAllFamilies() {

    List<Family> listfamily = familyServiceImpl.getAllFamilies();
    //assertThat("They are not equal!",listaparent,assertNotNull(listaparent));
    assertNotNull(listfamily);
  }

  @Test
  public void findByFamilyId() {
    Family family = new Family();
    //family.setId(1);

    //familyServiceImpl.findByFamilyId(family.getId());
   //when(familyServiceImpl.findByFamilyId(1)).thenReturn(Optional.of(family));
    //assertFalse(queryResult.isEmpty());
    //assertNotNull(queryResult);

  }

  @Test
  public void addFamily() {

    Family family = new Family();
    family.setFamilyName("Familia Gamarra");
    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    Family createfamily = familyServiceImpl.addFamily(family);

    assertThat("They are not equal!",family.getFamilyName(),is(createfamily.getFamilyName()));
  }

  @Test
  public void udpdateFamily() {
    Family family = new Family();
    family.setId(1);
    family.setFamilyName("Familia Gamarra");
    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    Family createfamily = familyServiceImpl.udpdateFamily(family);

    assertThat("They are not equal!",family.getFamilyName(),is(createfamily.getFamilyName()));
  }

  @Test
  public void deleteFamily() {
    Family family = new Family();
    family.setId(1);

    familyServiceImpl.deleteFamily(family.getId());
  }
}