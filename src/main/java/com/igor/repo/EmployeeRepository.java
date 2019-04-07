package com.igor.repo;

import com.igor.model.EmployeeDTO;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "employee-cache")
public interface EmployeeRepository
    extends IgniteRepository<EmployeeDTO, Integer> {
  //EmployeeDTO getEmployeeDTOById(Integer id);
}
