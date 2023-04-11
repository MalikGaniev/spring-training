package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

//display all departments in Furniture Department
    List<Department> findByDepartment(String department);
//display all departments in the health division
    List<Department>findByDivision(String division);
    //display all department with division name ends with 'ics'
    List<Department>findByDivisionEndingWithIgnoreCase(String end);
//Display top 3 department with division name includes 'Hea' without duplicates
    List<Department>findDistinctTop3ByDivisionContainingIgnoreCase(String pattern);
}
