package com.henryxi.springdata.keyvalue;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);
}
