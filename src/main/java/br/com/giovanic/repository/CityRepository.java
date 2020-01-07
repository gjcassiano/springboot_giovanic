package br.com.giovanic.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.com.giovanic.po.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Integer> {}

