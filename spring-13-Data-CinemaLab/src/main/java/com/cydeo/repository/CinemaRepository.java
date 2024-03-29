package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
List<Cinema>findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
List<Cinema>findTop3ByNameContaining(String s);

    //Write a derived query to list all cinemas in a specific country
List<Cinema>findByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
List<Cinema>findByNameOrSponsoredName(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
@Query("select e from  Cinema e where e.id=123 ")
List<Cinema>findId(String id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
@Query("select e from Cinema e where e.location.name='Russia' ")
    List<Cinema>Name();

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
@Query(value = "select * from Cinema where name='Malik' ",nativeQuery = true)
List<Cinema>Specific(String names);
    //Write a native query to sort all cinemas by name
    @Query(value = "select * from Cinema order by name",nativeQuery = true)
List<Cinema>sorting();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "select * from Cinema order by sponsoredName")
List<Cinema>t();

}
