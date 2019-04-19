package com.everis.gamarra.service.dao;

//import com.everis.gamarra.controller.FamilyController;
import com.everis.gamarra.model.Parent;
import com.everis.gamarra.repository.ParentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class ParentServiceImplTest {

  @Mock
  ParentRepository parentRepository;

  @InjectMocks
  ParentServiceImpl parentServiceImpl;

  @Test
  public void getAllParents() {
    List<Parent> listaparent = parentServiceImpl.getAllParents();
    //assertThat("They are not equal!",listaparent,assertNotNull(listaparent));
    assertNotNull(listaparent);
  }

  @Test
  public void addParent() {
    Parent parent = new Parent();
    parent.setFirstName("Luis");
    parent.setMiddleName("Alberto");
    parent.setLastName("Gamarra");

    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    Parent createParent = parentServiceImpl.addParent(parent);

    assertThat("They are not equal!",parent.getFirstName(),is(createParent.getFirstName()));

  }

  @Test
  public void updateParent() {

    Parent parent = new Parent();
    parent.setId(1);
    parent.setFirstName("Luis");
    parent.setMiddleName("Alberto");
    parent.setLastName("Gamarra");

    //when(parentRepository.save(any(Parent.class))).thenReturn(new Parent());
    Parent createParent = parentServiceImpl.updateParent(parent);

    assertThat("They are not equal!",parent.getFirstName(),is(createParent.getFirstName()));
  }

  @Test
  public void deleteParent() {

    Parent parent = new Parent();
    parent.setId(1);

    parentServiceImpl.deleteParent(parent.getId());
    //assertNotNull(Parent);
  }
}