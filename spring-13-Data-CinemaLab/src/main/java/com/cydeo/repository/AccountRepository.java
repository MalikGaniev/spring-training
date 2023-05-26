package com.cydeo.repository;

import com.cydeo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryContains(String Russia);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account>findByAgeLessThan(int t);

    //Write a derived query to list all accounts with a specific role
    List<Account>findByRole(String role);

    //Write a derived query to list all accounts between a range of ages
    List<Account>findByAgeBetween(int t,int r);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account>findByAddressStartingWith(String n);

    //Write a derived query to sort the list of accounts with age
    List<Account>findByOOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select e from Account e")
   List<Account>account();
    //Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role='Admin' ")
List<Account>acc();

    //Write a JPQL query to sort all accounts with age
   @Query("select t from Account t order by t.age")
List<Account>Sorting();
    // ------------------- Native QUERIES ------------------- //
    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from Account where age<25",nativeQuery = true)
List<Account>AGE();

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
@Query(value = "select * from Account where name='Malik' and address='6938 Pine Bark Line' and country='Russia' and city='Kazan' ",nativeQuery = true)
List<Account>Filter();
    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM Account WHERE age>20",nativeQuery = true)
List<Account>filterByAge();

}
