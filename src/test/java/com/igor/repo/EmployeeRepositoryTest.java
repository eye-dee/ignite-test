package com.igor.repo;

import static org.junit.jupiter.api.Assertions.*;

import com.igor.model.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeRepositoryTest {

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void getEmployeeDTOById() {
    EmployeeDTO saved = repository.save(1, EmployeeDTO.builder()
        .name("name")
        .isEmployed(false)
        .build());

    assertEquals(saved.getName(), repository.findById(1).get().getName());
  }
}
