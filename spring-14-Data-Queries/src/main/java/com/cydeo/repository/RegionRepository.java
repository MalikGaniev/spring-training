package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {
//Display all regions in Canada
List<Region> findByCountry(String country);

//Display all regions with country name includes united

    List<Region>findByCountryContainingIgnoreCase(String country);

//display all regions with country name includes united in order(region)
List<Region>findByCountryContainsOrderByRegionDesc(String country);
//Display top 2 regions in United State
    List<Region>findTop2ByCountry(String country);

}
