package com.igor.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

@Getter
@Setter
@Builder
public class EmployeeDTO implements Serializable {

  @QuerySqlField(index = true)
  private Integer id;

  @QuerySqlField(index = true)
  private String name;

  @QuerySqlField(index = true)
  private boolean isEmployed;

  // getters, setters
}