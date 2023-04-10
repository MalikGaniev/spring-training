package com.cydeo;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
  private final RegionRepository regionRepository;

    public QueryDemo(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {



        System.out.println("FindByCountry "+regionRepository.findByCountry("Canada"));
        System.out.println("Country containing+"+regionRepository.findByCountryContainingIgnoreCase("United"));
        System.out.println("Find by Country in Order"+regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("Find top 2 country "+regionRepository.findTop2ByCountry("United States"));
    }
}
