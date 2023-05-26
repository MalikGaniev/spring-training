package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
  private final RegionRepository regionRepository;
private final DepartmentRepository departmentRepository;
private final EmployeeRepository employeeRepository;
    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository=departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------Regions------------------------");
        System.out.println("FindByCountry " + regionRepository.findByCountry("Canada"));
        System.out.println("Country containing+" + regionRepository.findByCountryContainingIgnoreCase("United"));
        System.out.println("Find by Country in Order" + regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("Find top 2 country " + regionRepository.findTop2ByCountry("United States"));
        System.out.println("Find top countries" + regionRepository.findTopByCountryContainsOrderByCountry("United States"));

        System.out.println("------------------Departments------------------------");
        System.out.println("Find by departments"+departmentRepository.findByDepartment("Furniture"));
        System.out.println("Find by Division"+departmentRepository.findByDivision("Health"));
        System.out.println("Division name ends"+departmentRepository.findByDivisionEndingWithIgnoreCase("ics"));
        System.out.println("Find divisions top 3 distinct that contains "+departmentRepository.findDistinctTop3ByDivisionContainingIgnoreCase("Hea"));
        System.out.println("------------------Employees------------------------");
        System.out.println("Find by email"+employeeRepository.findByEmail("abendelowg@google.com.hk"));
        System.out.println("Find employee"+employeeRepository.findByFirstNameAndLastNameOrEmail("Berrie","Manueau","bmanueau0@dion.ne.jp"));
        System.out.println("retrive employee"+employeeRepository.retrieveEmployeeDetail());

    }
}
