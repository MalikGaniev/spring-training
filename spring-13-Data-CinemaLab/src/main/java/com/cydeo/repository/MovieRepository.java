package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieType;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    List<Movie>findByName(String name);

    //Write a derived query to list all movies between a range of prices
   List<Movie>findByPriceBetween(int t,int m);

    //Write a derived query to list all movies where duration exists in the specific list of duration
List<Movie>findByDuration(Integer m);

    //Write a derived query to list all movies with higher than a specific release date
List<Movie>findByReleaseDateAfter(LocalDate l);

    //Write a derived query to list all movies with a specific state and type
List<Movie>findByStateAndType(String state, MovieType movieType);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
@Query("select e from Movie e where e.price between 5 and 6")
    List<Movie>Price();

    //Write a JPQL query that returns all movie names
@Query("SELECT e.name from Movie e ")
    String name();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
@Query(value = "select name from Movie",nativeQuery = true)
String Name();
    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from Movie where price between 5 and 6",nativeQuery = true)
List<Movie>PriceAndRange();

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from Movie where duration between 5 and 6",nativeQuery = true)
List<Movie>movieAnd();

    //Write a native query to list the top 5 most expensive movies
@Query(value = "select * from Movie where price")

}
