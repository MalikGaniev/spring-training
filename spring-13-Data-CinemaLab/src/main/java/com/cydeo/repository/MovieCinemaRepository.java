package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id


    //Write a derived query to count all movie cinemas with a specific cinema id
   int countMovieCinemaById(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id


    //Write a derived query to list all movie cinemas with higher than a specific date
List<MovieCinema>findByMovie_ReleaseDate(LocalDate l);

    //Write a derived query to find the top 3 expensive movies
List<MovieCinema>findTop3ByMovie_Price();

    //Write a derived query to list all movie cinemas that contain a specific movie name
List<MovieCinema>findByMovie_Name(String name);

    //Write a derived query to list all movie cinemas in a specific location name
List<MovieCinema>findByMovie_State(String state);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
List<MovieCinema>findByMovieGreaterThanEqualOrDateTime(LocalDate f);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
@Query(value = "select count(id)from MovieCinema ",nativeQuery = true)
long count();
    //Write a native query that returns all movie cinemas by location name
@Query(value = "select * from MovieCinema where cinema.location='Russia' ",nativeQuery = true)
List<Movie>t();
}
