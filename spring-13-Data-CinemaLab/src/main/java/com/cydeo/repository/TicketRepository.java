package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought


    //Write a derived query to list all tickets by specific email


    //Write a derived query to count how many tickets are sold for a specific movie


    //Write a derived query to list all tickets between a range of dates


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user


    //Write a JPQL query that returns all tickets between a range of dates


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought


    //Write a native query to count the number of tickets a user bought in a specific range of dates


    //Write a native query to distinct all tickets by movie name


    //Write a native query to find all tickets by user email
@Query(value = "select * from ticket t join user_account ua on t.user_account_id=ua.id"+"where ua.email=?1",nativeQuery = true)
List<Ticket>findAllByUserEmail(@Param("email")String email);
    //Write a native query that returns all tickets
@Query(value = "SELECT * from ticket",nativeQuery = true)
    List<Ticket>retrieveAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
@Query(value = "select * from ticket t join user_account ua on t.user_account_id = ua.id "+"join account_details ad on ad.id=ua.account_details_id"+"join movie_cinema mc pn mc.id=t.movie_cinema_id"+"join movie m on mc.movie_id=m.id"+"where ua.username ILIKE concat('%',?1,'%') or"+"ad.name ILIKE concat('%',?1,'%')+"+"or m.name ILIKE concat('%',?1,'%') "
        +,
        nativeQuery = true)
    List<Ticket>findspecialTicket();

}
