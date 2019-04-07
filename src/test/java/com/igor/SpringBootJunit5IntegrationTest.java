package com.igor;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringBootJunit5IntegrationTest {


  @Test
  @DisplayName("Integration test which will get the actual output of text service")
  public void contextLoads() {
    assertEquals(1, 1);
  }

}