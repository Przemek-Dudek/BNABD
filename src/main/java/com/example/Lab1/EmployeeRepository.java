package com.example.Lab1;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    @Query("SELECT e FROM Employee e where e.lastName LIKE %?1")
    List<Employee> findAllWhereNameLike(String lastName);
    Employee findById(long id);
}
