package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
@Query("select e from Genre e")
    List<Genre>Genres();

    // ------------------- Native QUERIES ------------------- //
@Query(value = "select * from Genre where name='Malik'",nativeQuery = true)
        List<Genre>Native();
    //Write a native query that returns genres by containing name


}
